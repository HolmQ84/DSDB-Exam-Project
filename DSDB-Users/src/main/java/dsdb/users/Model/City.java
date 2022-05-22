package dsdb.users.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name="city")
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    private String cityName;
    private int postalCode;

    @Override
    public String toString() {
        return "\nCity{" +
                "cityId=" + cityId + "," +
                "cityName=" + cityName + "," +
                "postalCode=" + postalCode +
                '}';
    }

    public City(String cityName, int postalCode) {
        this.cityName = cityName;
        this.postalCode = postalCode;
    }

    public City() {
    }
}

