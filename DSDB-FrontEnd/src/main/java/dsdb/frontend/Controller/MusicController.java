package dsdb.frontend.Controller;

import dsdb.frontend.Model.Song;
import dsdb.frontend.Service.MusicClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/music")
@RestController
public class MusicController {

    @Autowired
    MusicClient musicClient;

    @GetMapping("/region/{region}")
    public List<Song> getSongsByRegion(@PathVariable String region) {
        return musicClient.getTop10RankedSongsByRegion(region);
    }

    @GetMapping("/artist/{artist}")
    public List<Song> getSongsByArtistLike(@PathVariable String artist) {
        return musicClient.getSongsByArtistLike(artist);
    }
}
