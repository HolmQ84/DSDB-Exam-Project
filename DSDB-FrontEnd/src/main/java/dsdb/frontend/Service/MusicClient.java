package dsdb.frontend.Service;

import dsdb.frontend.Model.Song;
import dsdb.frontend.Model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("DSDB-Music")
public interface MusicClient {

    @GetMapping("/songs/")
    @Cacheable("music")
    public List<Song> getAllSongs();

    //@Cacheable(value = "music", key = "#music.id")
    @GetMapping("/songs/{id}")
    public Song getSongById(@PathVariable Integer id);

    @GetMapping("/songs/search/artist/{artistLike}")
    public List<Song> getSongsByArtistLike(@PathVariable String artistLike);

    @GetMapping("/songs/search/region/{region}")
    public List<Song> getTop10RankedSongsByRegion(@PathVariable String region);

    @PostMapping("/songs/")
    public User createUser(@ModelAttribute User user);

    @PutMapping("/songs/{id}")
    public User updateUser(@ModelAttribute User user, @PathVariable int id);

    //@CacheEvict(value = "music", key = "#music.id")
    @DeleteMapping("/songs/{id}")
    public String deleteUser(@PathVariable int id);
}
