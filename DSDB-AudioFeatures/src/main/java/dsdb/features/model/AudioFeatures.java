package dsdb.features.model;

import lombok.Data;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "features")
public class AudioFeatures implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int audioId;
    @CsvBindByPosition(position = 10)
    private double danceability;
    @CsvBindByPosition(position = 11)
    private double energy;
    @CsvBindByPosition(position = 12)
    private double key;
    @CsvBindByPosition(position = 13)
    private double loudness;
    @CsvBindByPosition(position = 14)
    private double mode;
    @CsvBindByPosition(position = 15)
    private double speechiness;
    @CsvBindByPosition(position = 16)
    private double acousticness;
    @CsvBindByPosition(position = 17)
    private double instrumentalness;
    @CsvBindByPosition(position = 18)
    private double liveness;
    @CsvBindByPosition(position = 19)
    private double valence;
    @CsvBindByPosition(position = 20)
    private double tempo;
    @CsvBindByPosition(position = 21)
    private double duration_ms;
}
