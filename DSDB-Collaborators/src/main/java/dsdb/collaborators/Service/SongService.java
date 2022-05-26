package dsdb.collaborators.Service;

import dsdb.collaborators.Model.SongDTO;
import dsdb.collaborators.Repository.SongRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public SongDTO convertObjectToSongDTO(String name) {
        List<JSONObject> jsonSong = songRepository.findSongBySongTitle(name);
        SongDTO song = new SongDTO();
        song.setName(name);
        for (JSONObject jsonObject : jsonSong) {
            String type = (String) jsonObject.get("type");
            if (type.equalsIgnoreCase("featured")) {
                song.addFeature((String) jsonObject.get("name"));
            }
            if (type.equalsIgnoreCase("produced")) {
                song.addProducer((String) jsonObject.get("name"));
            }
            if (type.equalsIgnoreCase("wrote")) {
                song.addWriter((String) jsonObject.get("name"));
            }
            if (type.equalsIgnoreCase("sang")) {
                song.addSinger((String) jsonObject.get("name"));
            }
        }
        return song;
    }

    public List<List<JSONObject>> getAllSongs() {
        return songRepository.getAllSongs();
    }
}
