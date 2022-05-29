package dsdb.frontend.Controller;

import dsdb.frontend.Model.*;
import dsdb.frontend.Model.Error;
import dsdb.frontend.Service.*;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/music")
@RestController
public class MusicController {

    @Autowired
    MusicClient musicClient;
    @Autowired
    SessionService sessionService;
    @Autowired
    FeaturesClient featuresClient;
    @Autowired
    LyricsClient lyricsClient;
    @Autowired
    CollaboratorClient collaboratorClient;
    @Autowired
    KafkaService kafkaService;

    @GetMapping("/region/{region}")
    public List<Song> getSongsByRegion(@PathVariable String region, HttpSession session, HttpServletResponse response) {
        sessionService.sessionCheck(session, response);
        sessionService.updateSession(session, response, "getSongsByRegion", region);
        return musicClient.getTop10RankedSongsByRegion(region);
    }

    @GetMapping("/artist/{artist}")
    public List<Song> getSongsByArtistLike(@PathVariable String artist, HttpSession session, HttpServletResponse response) {
        sessionService.sessionCheck(session, response);
        sessionService.updateSession(session, response, "getSongsByArtistLike", artist);
        return musicClient.getSongsByArtistLike(artist);
    }

    @GetMapping("/{id}")
    public ModelAndView getSongById(@PathVariable int id, HttpSession session, HttpServletResponse response) {
        sessionService.sessionCheck(session, response);
        sessionService.updateSession(session, response, "getSongById", Integer.toString(id));
        Song song = musicClient.getSongById(id);
        if (song != null) {
            try {
                song.setFeatures(featuresClient.getFeaturesById(id));
            } catch (Exception e) {
                kafkaService.sendToErrorTopic(kafkaService.errorToObject(new Error(e.getMessage(), e.getClass().getName())));
            }

            song.setLyrics(lyricsClient.getLyricsById(id));
            song.setCollaborators(collaboratorClient.getSongCollaborators());
        }
        ModelAndView modelAndView = new ModelAndView("song");
        modelAndView.addObject("song", song);
        modelAndView.addObject("user", (User) session.getAttribute("user"));
        return modelAndView;
    }

    @GetMapping()
    public ModelAndView getAllSongsLimitedTo100(HttpSession session, HttpServletResponse response) {
        // TODO - Remove this hardcoded
        User user = new User();
        user.setUserLevel("admin");
        user.setUsername("ADMIN");
        session.setAttribute("user", user);
        Session session1 = new Session(1);
        session.setAttribute("session", session1);
        // TODO - End.
        sessionService.sessionCheck(session, response);
        sessionService.updateSession(session, response, "getAllSongsLimitedTo100", null);
        List<Song> songs = musicClient.getAllSongs().stream().limit(100).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("songs");
        modelAndView.addObject("songs", songs);
        modelAndView.addObject("user", (User) session.getAttribute("user"));
        return modelAndView;
    }
}
