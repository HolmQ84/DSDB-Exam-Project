package dsdb.logger.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "songs")
public class Song implements Serializable {
    private int songId;
    private String title;
    private String artist;
    private int rank;
    private String date;
    private String spotifyUrl;
    private String region;
    private int streams;
    private String loggerMessage;
    private Date timeStamp;
}
