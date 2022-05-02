package lk.himash.ls.repository;

import lk.himash.ls.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends MongoRepository<Laptop, String> {

    @Query("{status : ?0}")
    public List<Laptop> getLaptopRelatedStatus(String status);

    @Query("{ price : { $gte : ?0, $lte : ?1}}")
    public List<Laptop> getLaptopPriceGreaterThan(String priceGt, String priceLt);
}
