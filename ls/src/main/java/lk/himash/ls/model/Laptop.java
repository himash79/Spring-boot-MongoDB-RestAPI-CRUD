package lk.himash.ls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "laptop")
public class Laptop {

    @Id
    private String id;
    private String manufacture;
    private String model;
    private String price;
    private String status;
}
