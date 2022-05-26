package dsdb.lyrics.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import dsdb.lyrics.Model.Lyric;
import dsdb.lyrics.Repository.LyricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EnableMongoRepositories(basePackages = "dsdb.lyrics.Repository")
@Service
public class LyricService {

    @Autowired
    LyricRepository lyricRepository;

    public List<Lyric> convertCSVtoListOfLyrics() {
        try{
            CSVReader reader=
                    new CSVReaderBuilder(new FileReader("C:\\Users\\Nmtur\\PycharmProjects\\Cphbusiness 2_semester\\eksamens projekt\\DataScience-ExamProject\\DataScience-SongManagement\\data\\2000songWithLyrics.csv")).
                            withSkipLines(1). // Skiping firstline as it is header
                            build();
            List<Lyric> lyricList = reader.readAll().stream().map(data-> {
                Lyric lyric = new Lyric();
                lyric.setSongId(data[0]);
                lyric.setLyrics(data[19]);
                return lyric;
            }).collect(Collectors.toList());
            return lyricList;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<Lyric>();
        }
    }

    public int storeListOfLyricsInMongoDB(List<Lyric> lyricList) {
        return lyricRepository.saveAll(lyricList).size();
    }

    public List<Lyric> getAllLyrics() {
        return lyricRepository.findAll();
    }

    public Lyric getLyricsById(int lyricId) {
        Lyric lyric = lyricRepository.findLyricsById(lyricId);
        System.out.println(lyric);
        return lyric;
    }
}
