package dsdb.frontend.Model;

import lombok.Data;

import java.io.Serializable;

@Data

public class Street implements Serializable {
    private int streetId;
    private String streetName;
}
