package dsdb.lyrics.Repository;

import dsdb.lyrics.Model.Lyric;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LyricRepository extends MongoRepository<Lyric, String> {

    @Query("{ 'songId': ?0 }")
    Lyric findLyricsById(int id);

    // Query Example.
    // @Query("{ 'title' : {$regex:?0}, 'rank' : { $gte : ?1 , $lte : ?2 }}")
    // public Page findByNameAndAgeRange(String title, int rankFrom, int rankTo);
}
