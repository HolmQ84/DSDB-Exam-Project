package dsdb.frontend.Service;

import net.minidev.json.JSONArray;

import dsdb.frontend.Model.Collaborators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CollaboratorClient {

    @Autowired
    RestTemplate restTemplate;

    public Collaborators getSongCollaborators() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8085/songs/Chantaje", HttpMethod.GET, entity, Collaborators.class).getBody();
    }
}
