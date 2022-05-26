package dsdb.frontend.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Lyrics implements Serializable {
    private int songId;
    private String lyrics;
}
