package dsdb.lyrics.Model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "lyrics")
public class Lyric implements Serializable {
    @CsvBindByPosition(position = 0)
    private int songId;
    @CsvBindByPosition(position = 19)
    private String lyrics;


    public Lyric(String songId, String lyrics) {
        this.songId = Integer.parseInt(songId);
        this.lyrics = lyrics;
    }

    public Lyric() {
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(String musicId) {
        this.songId = Integer.parseInt(musicId);
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

}
