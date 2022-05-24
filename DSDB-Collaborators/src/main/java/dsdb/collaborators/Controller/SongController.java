package dsdb.collaborators.Controller;

import dsdb.collaborators.Model.Song;
import dsdb.collaborators.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    SongRepository songRepository;

    @GetMapping
    public Iterable<Song> findAll() {
        return songRepository.getAllSongs();
    }

    @GetMapping("/{name}")
    public Song getSongByName(@PathVariable String name) {
        return songRepository.getSongByName(name);
    }

    @GetMapping("/search/{name}")
    public Iterable<Song> findSongByNameLike(@PathVariable String name) {
        return songRepository.findSongByNameLike(name);
    }

    @GetMapping("/test1/{title}")
    public List<Song> getSong(@PathVariable String title) {
        return songRepository.getSong(title);
    }

    @GetMapping("/test2/{title}")
    public Optional<Song> getSong2(@PathVariable String title) {
        return songRepository.getOptionalPersonViaQuery(title);
    }
}
