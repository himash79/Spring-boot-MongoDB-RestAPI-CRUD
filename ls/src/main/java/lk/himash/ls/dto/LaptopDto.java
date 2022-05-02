package lk.himash.ls.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopDto {

    private String id;
    private String manufacture;
    private String model;
    private String price;
    private String status;
}
