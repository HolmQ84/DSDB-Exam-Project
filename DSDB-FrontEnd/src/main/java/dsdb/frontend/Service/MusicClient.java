package dsdb.frontend.Service;

import dsdb.frontend.Model.Song;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("DSDB-Music")
public interface MusicClient {

    @GetMapping("/songs/")
    public List<Song> getAllSongs();

    @GetMapping("/songs/{id}")
    public Song getSongById(@PathVariable Integer id);

    @GetMapping("/songs/search/artist/{artistLike}")
    public List<Song> getSongsByArtistLike(@PathVariable String artistLike);

    @GetMapping("/songs/search/region/{region}")
    public List<Song> getTop10RankedSongsByRegion(@PathVariable String region);
}
