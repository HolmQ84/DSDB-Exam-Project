package dsdb.frontend.Model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Person implements Serializable {
    private int personId;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private Address address;
}
