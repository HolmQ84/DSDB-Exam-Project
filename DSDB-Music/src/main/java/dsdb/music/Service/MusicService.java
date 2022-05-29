package dsdb.music.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import dsdb.music.Model.Song;
import dsdb.music.Repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@EnableMongoRepositories(basePackages = "dsdb.music.Repository")
@Service
public class MusicService {

    @Autowired
    MusicRepository musicRepository;

    public void deleteOne(Song song){
        Song song1 = new Song(1 , "Chantaje (feat. Maluma)");
        musicRepository.delete(song);
    }


    public List<Song> convertCSVtoListOfMusic() {
        try{
            CSVReader reader=
                    new CSVReaderBuilder(new FileReader("C:\\Users\\patr5\\IdeaProjects\\DataScience-ExamProject\\DataScience-SongManagement\\data\\cleanedDatasetWithFeatures.csv")).
                            withSkipLines(1). // Skiping firstline as it is header
                            build();
            List<Song> songList = reader.readAll().stream().map(data-> {
                Song song = new Song();
                song.setMusicId(data[0]);
                song.setTitle(data[1]);
                song.setRank(data[2]);
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = sdf1.parse(data[3]);
                    song.setDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                song.setArtist(data[4]);
                song.setSpotifyUrl(data[5]);
                song.setRegion(data[6]);
                song.setStreams(data[7]);
                return song;
            }).collect(Collectors.toList());
            return songList;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<Song>();
        }
    }

    public int storeListOfMusicInMongoDB(List<Song> songList) {
        return musicRepository.saveAll(songList).size();
    }

    public List<Song> getAllSongs() {
        return musicRepository.findAll();
    }

    public List<Song> getSongByArtist(String artist) {
        return musicRepository.findSongsByArtist(artist);
    }

    public Song getSongById(int songId) {
        return musicRepository.findSongById(songId);
    }

    public List<Song> getTop10SongsByRegion(String region) {
        return musicRepository.getTop10SongsByRegion(region);
    }
}
