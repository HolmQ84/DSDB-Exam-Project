package dsdb.frontend.Service;

import dsdb.frontend.Model.Lyrics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("DSDB-Lyrics")
public interface LyricsClient {

    @GetMapping("/lyrics/")
    public List<Lyrics> getAllLyrics();

    @GetMapping("/lyrics/{id}")
    public Lyrics getLyricsById(@PathVariable Integer id);
}
