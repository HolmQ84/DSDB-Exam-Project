package dsdb.frontend.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Features implements Serializable {
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
}
