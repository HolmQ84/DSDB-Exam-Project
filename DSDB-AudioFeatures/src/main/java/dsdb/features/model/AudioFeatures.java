package dsdb.features.model;

import lombok.Data;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "features")
public class AudioFeatures implements Serializable {

    @Id
    @CsvBindByPosition(position = 0)
    private int audioId;
    @CsvBindByPosition(position = 8)
    private String danceability;
    @CsvBindByPosition(position = 9)
    private String energy;
    @CsvBindByPosition(position = 10)
    private String onKey;
    @CsvBindByPosition(position = 11)
    private String loudness;
    @CsvBindByPosition(position = 12)
    private String speechiness;
    @CsvBindByPosition(position = 13)
    private String acousticness;
    @CsvBindByPosition(position = 14)
    private String instrumentalness;
    @CsvBindByPosition(position = 15)
    private String liveness;
    @CsvBindByPosition(position = 16)
    private String valence;
    @CsvBindByPosition(position = 17)
    private String tempo;
    @CsvBindByPosition(position = 18)
    private String duration_ms;
}
