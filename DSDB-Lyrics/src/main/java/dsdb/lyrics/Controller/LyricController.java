package dsdb.lyrics.Controller;

import dsdb.lyrics.Model.Lyric;
import dsdb.lyrics.Service.LyricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/lyrics")
@RestController
public class LyricController {

    @Autowired
    LyricService lyricService;

    @GetMapping("/")
    public List<Lyric> getAllLyrics() {
        return lyricService.getAllLyrics();
    }

    @GetMapping("/{id}")
    public Lyric getLyricsById(@PathVariable int id) {
        return lyricService.getLyricsById(id);
    }

    @GetMapping("/filldb")
    public String musicToDB() {
        int value = lyricService.storeListOfLyricsInMongoDB(lyricService.convertCSVtoListOfLyrics());
        return "Lyrics list successfully stored in MongoDB. " + value + " lyrics added.";
    }
}
