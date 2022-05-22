package dsdb.users.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name="street")
public class Street implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "street_id")
    private int streetId;
    private String streetName;

    @Override
    public String toString() {
        return "\nStreet{" +
                "streetId=" + streetId + "," +
                "streetName=" + streetName +
                '}';
    }

    public Street(String streetName) {
        this.streetName = streetName;
    }

    public Street() {
    }
}
