package dsdb.logger.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "features")
public class AudioFeatures implements Serializable {

    @Id
    private int audioId;
    private String danceability;
    private String energy;
    private String onKey;
    private String loudness;
    private String speechiness;
    private String acousticness;
    private String instrumentalness;
    private String liveness;
    private String valence;
    private String tempo;
    private String duration_ms;
    private String loggerMessage;
}
