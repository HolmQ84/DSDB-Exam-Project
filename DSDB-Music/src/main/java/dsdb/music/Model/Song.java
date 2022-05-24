package dsdb.music.Model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "music")
public class Song implements Serializable {
    @CsvBindByPosition(position = 0)
    private int musicId;
    @CsvBindByPosition(position = 2)
    private String title;
    @CsvBindByPosition(position = 5)
    private String artist;
    @CsvBindByPosition(position = 3)
    private int rank;
    @CsvBindByPosition(position = 4)
    private Date date;
    @CsvBindByPosition(position = 6)
    private String spotifyUrl;
    @CsvBindByPosition(position = 7)
    private String region;
    @CsvBindByPosition(position = 8)
    private int streams;

    public Song(String musicId, String title, String rank, Date date, String artist, String spotifyUrl,
                String region, String streams) {
        this.musicId = Integer.parseInt(musicId);
        this.title = title;
        this.rank = Integer.parseInt(rank);
        this.date = date;
        this.artist = artist;
        this.spotifyUrl = spotifyUrl;
        this.region = region;
        this.streams = (int) Double.parseDouble(streams);
    }

    public Song() {
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = Integer.parseInt(musicId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = Integer.parseInt(rank);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSpotifyUrl() {
        return spotifyUrl;
    }

    public void setSpotifyUrl(String spotifyUrl) {
        this.spotifyUrl = spotifyUrl;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getStreams() {
        return streams;
    }

    public void setStreams(String streams) {
        this.streams = (int) Double.parseDouble(streams);
    }

}
