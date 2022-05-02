package lk.himash.ls.service;

import lk.himash.ls.model.Laptop;
import org.springframework.http.ResponseEntity;

public interface LaptopService {

    public ResponseEntity<?> getAllLaptops();

    public ResponseEntity<?> addLaptop(Laptop laptop);

    public ResponseEntity<?> getLaptopDetails(String id);

    public ResponseEntity<?> deleteLaptopDetails(String id);

    public ResponseEntity<?> updateLaptopDetails(Laptop newLapDetails, String id);

    public ResponseEntity<?> getlaptopRelatedStatus(String status);

    public ResponseEntity<?> getLaptopPriceGreaterThan(String priceGt, String priceLt);

}
