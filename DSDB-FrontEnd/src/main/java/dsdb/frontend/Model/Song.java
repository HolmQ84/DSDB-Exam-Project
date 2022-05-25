package dsdb.frontend.Model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Song implements Serializable {
    private int musicId;
    private String title;
    private String artist;
    private int rank;
    private Date date;
    private String spotifyUrl;
    private String region;
    private int streams;
}
