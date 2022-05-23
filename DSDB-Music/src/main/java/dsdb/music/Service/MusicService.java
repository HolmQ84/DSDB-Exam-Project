package dsdb.music.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import dsdb.music.Model.Music;
import dsdb.music.Repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Music> convertCSVtoListOfMusic() {
        try{
            CSVReader reader=
                    new CSVReaderBuilder(new FileReader("C:\\Users\\marti\\IdeaProjects\\DataScience-ExamProject\\DataScience-SongManagement\\data\\cleanedDatasetWithFeatures.csv")).
                            withSkipLines(1). // Skiping firstline as it is header
                            build();
            List<Music> musicList = reader.readAll().stream().map(data-> {
                Music music = new Music();
                music.setMusicId(data[0]);
                music.setTitle(data[1]);
                music.setRank(data[2]);
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = sdf1.parse(data[3]);
                    music.setDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                music.setArtist(data[4]);
                music.setSpotifyUrl(data[5]);
                music.setRegion(data[6]);
                music.setStreams(data[7]);
                return music;
            }).collect(Collectors.toList());
            return musicList;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<Music>();
        }
    }

    public int storeListOfMusicInMongoDB(List<Music> musicList) {
        return musicRepository.saveAll(musicList).size();
    }

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public List<Music> getMusicByArtist(String artist) {
        List<Music> music = musicRepository.findMusicByArtist(artist);
        System.out.println(music);
        return music;
    }

    public Music getMusicById(int musicId) {
        Music music = musicRepository.findMusicById(musicId);
        System.out.println(music);
        return music;
    }

    public List<Music> getTop10SongsByRegion(String region) {
        return musicRepository.getTop10SongsByRegion(region);
    }
}
