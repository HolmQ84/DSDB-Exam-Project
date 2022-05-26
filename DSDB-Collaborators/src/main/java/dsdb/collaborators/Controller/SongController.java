package dsdb.collaborators.Controller;

import dsdb.collaborators.Model.SongDTO;
import dsdb.collaborators.Repository.SongRepository;
import dsdb.collaborators.Service.SongService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    SongService songService;

    @GetMapping
    public List<List<JSONObject>> findAll() {
        return songRepository.getAllSongs();
    }

    @GetMapping("/{song}")
    public SongDTO findSongByTitle(@PathVariable String song) {
        return songService.convertObjectToSongDTO(song);
    }
}
