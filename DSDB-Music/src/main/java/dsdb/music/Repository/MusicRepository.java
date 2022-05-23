package dsdb.music.Repository;

import dsdb.music.Model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Song, String> {

    @Query("{ 'artist': {$regex:?0} }")
    List<Song> findSongsByArtist(String artist);

    @Query("{ 'musicId': ?0 }")
    Song findSongById(int id);

    @Query("{ 'region' : {$regex:?0} , 'rank' : {$lte: 10} }")
    List<Song> getTop10SongsByRegion(String region);

    // Query Example.
    // @Query("{ 'title' : {$regex:?0}, 'rank' : { $gte : ?1 , $lte : ?2 }}")
    // public Page findByNameAndAgeRange(String title, int rankFrom, int rankTo);
}
