package dsdb.frontend.Model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private int addressId;
    private String country;
    private Street street;
    private String streetNumber;
    private City city;
}
