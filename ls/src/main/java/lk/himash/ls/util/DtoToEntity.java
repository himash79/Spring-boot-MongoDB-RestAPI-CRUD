package lk.himash.ls.util;

import lk.himash.ls.dto.LaptopDto;
import lk.himash.ls.model.Laptop;

public class DtoToEntity {

    public static Laptop convertLaptopDtoToModel(LaptopDto lapDto) {
        Laptop lap = new Laptop();
        lap.setId(lapDto.getId());
        lap.setManufacture(lapDto.getManufacture());
        lap.setModel(lapDto.getModel());
        lap.setPrice(lapDto.getPrice());
        lap.setStatus(lapDto.getStatus());
        return lap;
    }

}
