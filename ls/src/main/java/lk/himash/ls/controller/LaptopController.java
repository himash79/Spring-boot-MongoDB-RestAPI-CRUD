package lk.himash.ls.controller;

import lk.himash.ls.dto.LaptopDto;
import lk.himash.ls.model.Laptop;
import lk.himash.ls.service.LaptopService;
import lk.himash.ls.util.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // specify the URL if you need
@RestController
public class LaptopController {

    @Autowired
    private LaptopService lapService;

    @GetMapping("/lapApi/getAllLapDetails")
    public ResponseEntity<?> getAllLaptops() {
        return lapService.getAllLaptops();
    }

    @PostMapping("/lapApi/addLapDetails")
    public ResponseEntity<?> addLaptop(@RequestBody LaptopDto lapDto) {
        Laptop laptopObj = DtoToEntity.convertLaptopDtoToModel(lapDto);
        return lapService.addLaptop(laptopObj);
    }

    @GetMapping("/lapApi/getLap/{id}")
    public ResponseEntity<?> getLaptopDetails(@PathVariable String id) {
        return lapService.getLaptopDetails(id);
    }

    @DeleteMapping("/lapApi/removeLap/{id}")
    public ResponseEntity<?> removeLaptop(@PathVariable String id) {
        return lapService.deleteLaptopDetails(id);
    }

    @PutMapping("/lapApi/updateLapDetails/{id}")
    public ResponseEntity<?> updateLaptopDetails(@RequestBody LaptopDto lapDto, @PathVariable String id) {
        Laptop newLaptopDetails = DtoToEntity.convertLaptopDtoToModel(lapDto);
        return lapService.updateLaptopDetails(newLaptopDetails, id);
    }

    @GetMapping("/lapApi/getLapDetailsRelatedStatus/{status}")
    public ResponseEntity<?> getLaptopRelatedStatus(@PathVariable String status) {
        return lapService.getlaptopRelatedStatus(status);
    }

    @GetMapping("/lapApi/getLapsWithPriceRange/{priceLt}/{priceGt}")
    public ResponseEntity<?> getLaptopPriceGreaterThan(@PathVariable String priceGt, @PathVariable String priceLt) {
        return lapService.getLaptopPriceGreaterThan(priceGt, priceLt);
    }

}
