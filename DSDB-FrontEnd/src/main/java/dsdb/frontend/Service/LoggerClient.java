package dsdb.frontend.Service;

import dsdb.frontend.Model.Features;
import dsdb.frontend.Model.Session;
import dsdb.frontend.Model.Song;
import dsdb.frontend.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("DSDB-Logger")
public interface LoggerClient {

    @GetMapping("/sessions/")
    public List<Session> getAllSessions();

    @GetMapping("/logger/songs")
    public List<Song> getAllSongs();

    @GetMapping("/logger/users")
    public List<User> getAllUsers();

    @GetMapping("/logger/features")
    public List<Features> getAllFeatures();
}
