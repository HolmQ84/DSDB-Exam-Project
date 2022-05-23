package dsdb.collaborators.repository;

import dsdb.collaborators.Model.Song;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "songs", path = "songs")
public interface SongRepository extends Neo4jRepository<Song, Long> {

    Song getSongByName(String title);

    Iterable<Song> findSongByNameLike(String name);

    @Query("MATCH (m:Song)<-[r:SANG]-(a:Person) RETURN m,r,a LIMIT $props")
    Collection<Song> graph(@Param("props") int limit);
}
