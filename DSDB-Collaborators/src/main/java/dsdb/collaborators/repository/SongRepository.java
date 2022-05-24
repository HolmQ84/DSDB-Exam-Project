package dsdb.collaborators.repository;

import dsdb.collaborators.Model.Person;
import dsdb.collaborators.Model.Song;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Flux;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SongRepository extends Neo4jRepository<Song, Long> {

    Song getSongByName(String title);

    Iterable<Song> findSongByNameLike(String name);

    @Query("MATCH (m:Song)<-[r:SANG]-(a:Person) RETURN m,r,a LIMIT $props")
    Collection<Song> graph(@Param("props") int limit);

    @Query("MATCH (song:Song) RETURN song")
    List<Song> getAllSongs();

    @Query("MATCH (song:Song {name: $songName }) RETURN song")
    List<Song> getSong(@Param("songName") String songName);

    @Query("MATCH (song:Song) WHERE song.name =~ ('(?i).*'+$title+'.*') RETURN song")
    Collection<Song> findByTitleContaining(@Param("title") String title);

    @Query("MATCH (n:Song{name::#{#part1}}) return n")
    Optional<Song> getOptionalPersonViaQuery(@Param("part1") String part1);

    @Query("MATCH(song:Song) WHERE song.name =~ $title RETURN song")
    Flux<Song> findByTitleContains(String title);
}
