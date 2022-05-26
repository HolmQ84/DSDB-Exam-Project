package dsdb.music.Controller;

import dsdb.music.Model.Song;
import dsdb.music.Service.KafkaService;
import dsdb.music.Service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/songs")
@RestController
public class SongController {

    @Autowired
    MusicService musicService;

    @Autowired
    KafkaService kafkaService;

    @GetMapping("/")
    public List<Song> getAllSongs() {
        return musicService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable int id) {
        Song song = musicService.getSongById(id);
        kafkaService.sendToMusicTopic(kafkaService.songToObject(song), "Get Request - Song By ID");
        return song;
    }

    @GetMapping("/search/artist/{artist}")
    public List<Song> getSongByArtist(@PathVariable String artist) {
        System.out.println(artist);
        return musicService.getSongByArtist(artist);
    }

    @GetMapping("/search/region/{region}")
    public List<Song> getTop10SongsByRegion(@PathVariable String region) {
        return musicService.getTop10SongsByRegion(region);
    }

    @GetMapping("/filldb")
    public String musicToDB() {
        int value = musicService.storeListOfMusicInMongoDB(musicService.convertCSVtoListOfMusic());
        return "Songs list successfully stored in MongoDB. " + value + " song added.";
    }
}
