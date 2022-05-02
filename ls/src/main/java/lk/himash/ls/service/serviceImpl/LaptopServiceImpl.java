package lk.himash.ls.service.serviceImpl;

import lk.himash.ls.model.Laptop;
import lk.himash.ls.repository.LaptopRepository;
import lk.himash.ls.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository lapRepo;

    @Override
    public ResponseEntity<?> getAllLaptops() {
        List<Laptop> laps = lapRepo.findAll();
        return new ResponseEntity(laps, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addLaptop(Laptop laptop) {
        Laptop laptopObj = lapRepo.save(laptop);
        return new ResponseEntity(laptopObj, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getLaptopDetails(String id) {
        Laptop lap = lapRepo.findById(id).get();
        return new ResponseEntity(lap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteLaptopDetails(String id) {
        lapRepo.deleteById(id);
        return new ResponseEntity(id + " Laptop removed successfully ", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateLaptopDetails(Laptop newLapDetails, String id) {
        Laptop oldLapDetails = lapRepo.findById(id).get();
        Laptop updatedLaptopDetails = updatedLaptopDetails(newLapDetails, oldLapDetails);
        Laptop saveUpdatedLaptop = lapRepo.save(updatedLaptopDetails);
        return new ResponseEntity(saveUpdatedLaptop, HttpStatus.OK);
    }

    private Laptop updatedLaptopDetails(Laptop newLapDetails, Laptop oldLapDetails) {
        oldLapDetails.setManufacture(newLapDetails.getManufacture());
        oldLapDetails.setModel(newLapDetails.getModel());
        oldLapDetails.setPrice(newLapDetails.getPrice());
        oldLapDetails.setStatus(newLapDetails.getStatus());
        return oldLapDetails;
    }

    @Override
    public ResponseEntity<?> getlaptopRelatedStatus(String status) {
        List<Laptop> laps = lapRepo.getLaptopRelatedStatus(status);
        return new ResponseEntity(laps, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getLaptopPriceGreaterThan(String priceGt, String priceLt) {
        List<Laptop> laps = lapRepo.getLaptopPriceGreaterThan(priceGt, priceLt);
        return new ResponseEntity(laps, HttpStatus.OK);
    }
}
