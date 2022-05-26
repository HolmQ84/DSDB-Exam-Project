package dsdb.frontend.Model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Features features;
    private Lyrics lyrics;
    private Collaborators collaborators;
}
