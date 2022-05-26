package dsdb.collaborators.Repository;

import dsdb.collaborators.Model.Song;
import net.minidev.json.JSONObject;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends Neo4jRepository<Song, Long> {

    @Query("MATCH (s:Song)-[r]-(p:Person) RETURN s.name as song, type(r) as type, p.name as name")
    List<List<JSONObject>> getAllSongs();

    @Query("MATCH (s:Song {name: $props })-[r]-(p:Person) RETURN type(r) as type, p.name as name")
    List<JSONObject> findSongBySongTitle(@Param("props") String name);
}
