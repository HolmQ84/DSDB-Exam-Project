package dsdb.music.Controller;

import dsdb.music.Model.Music;
import dsdb.music.Service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController {

    @Autowired
    MusicService musicService;

    @GetMapping("/")
    public List<Music> getAllMusic() {
        return musicService.getAllMusic();
    }

    @GetMapping("/{id}")
    public Music getMusicById(@PathVariable int id) {
        return musicService.getMusicById(id);
    }

    @GetMapping("/search/artist/{artist}")
    public List<Music> getMusicByArtist(@PathVariable String artist) {
        System.out.println(artist);
        return musicService.getMusicByArtist(artist);
    }

    @GetMapping("/search/region/{region}")
    public List<Music> getTop10SongsByRegion(@PathVariable String region) {
        return musicService.getTop10SongsByRegion(region);
    }

    @GetMapping("/filldb")
    public String musicToDB() {
        int value = musicService.storeListOfMusicInMongoDB(musicService.convertCSVtoListOfMusic());
        return "Music list successfully stored in MongoDB. " + value + " song added.";
    }
}
