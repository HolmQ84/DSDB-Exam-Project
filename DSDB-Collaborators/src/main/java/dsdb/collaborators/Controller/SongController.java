package dsdb.collaborators.Controller;

import dsdb.collaborators.Model.Song;
import dsdb.collaborators.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    SongRepository songRepository;

    @GetMapping
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @GetMapping("/{name}")
    public Song getSongByName(@PathVariable String name) {
        return songRepository.getSongByName(name);
    }

    @GetMapping("/search/{name}")
    public Iterable<Song> findSongByNameLike(@PathVariable String name) {
        return songRepository.findSongByNameLike(name);
    }
}
