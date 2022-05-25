package dsdb.frontend.Model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
public class City implements Serializable {
    private int cityId;
    private String cityName;
    private int postalCode;
}

