package dsdb.users.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;
    private String firstName;
    private String lastName;
    private Date birthdate;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @Override
    public String toString() {
        return "\nPerson{" +
                "personId=" + personId +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", birthdate=" + birthdate +
                ", address=" + address +
                '}';
    }
}
