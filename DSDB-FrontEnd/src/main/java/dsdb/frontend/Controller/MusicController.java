package dsdb.frontend.Controller;

import dsdb.frontend.Model.Collaborators;
import dsdb.frontend.Model.Error;
import dsdb.frontend.Model.Song;
import dsdb.frontend.Model.User;
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
    public ModelAndView getSongsByRegion(@PathVariable String region, HttpSession session, HttpServletResponse response) {
        sessionService.sessionCheck(session, response);
        sessionService.updateSession(session, response, "/music/region/{region}", region);
        List<Song> songs = musicClient.getTop10RankedSongsByRegion(region);
        ModelAndView modelAndView = new ModelAndView("songs");
        modelAndView.addObject("songs", songs);
        modelAndView.addObject("user", (User) session.getAttribute("user"));
        return modelAndView;
    }

    @GetMapping("/artist/{artist}")
    public ModelAndView getSongsByArtistLike(@PathVariable String artist, HttpSession session, HttpServletResponse response) {
        sessionService.sessionCheck(session, response);
        sessionService.updateSession(session, response, "/music/artist/{artist}", artist);
        List<Song> songs = musicClient.getSongsByArtistLike(artist);
        ModelAndView modelAndView = new ModelAndView("songs");
        modelAndView.addObject("songs", songs);
        modelAndView.addObject("user", (User) session.getAttribute("user"));
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getSongById(@PathVariable int id, HttpSession session, HttpServletResponse response) {
        sessionService.sessionCheck(session, response);
        sessionService.updateSession(session, response, "/music/{id}", Integer.toString(id));
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
        sessionService.sessionCheck(session, response);
        sessionService.updateSession(session, response, "/music/", null);
        List<Song> songs = musicClient.getAllSongs().stream().limit(100).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("songs");
        modelAndView.addObject("songs", songs);
        modelAndView.addObject("user", (User) session.getAttribute("user"));
        return modelAndView;
    }
}
