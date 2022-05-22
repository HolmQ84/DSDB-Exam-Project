package dsdb.features.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import dsdb.features.model.AudioFeatures;
import dsdb.features.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    @Autowired
    FeatureRepository featureRepository;

    public List<AudioFeatures> findAllAudioFeatures() {
        try {
            return featureRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AudioFeatures updateAudioFeatures(int audioId, AudioFeatures audioFeatures) {
        try {
            audioFeatures.setAudioId(audioId);
            return featureRepository.save(audioFeatures);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteAudioFeatures(int audioId) {
        try {
            featureRepository.deleteById(audioId);
            return "Audio Features successfully deleted.";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Failed to delete Audio Features.";
    }

    public AudioFeatures getAudioFeaturesById(int audioId) {
        try {
            return featureRepository.findById(audioId).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AudioFeatures createNewAudioFeature(AudioFeatures audioFeatures) {
        try {
            return featureRepository.save(audioFeatures);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AudioFeatures> convertCSVtoListOfMusic() {
        try{

            CSVReader reader =
                    new CSVReaderBuilder(new FileReader("C:\\Users\\marti\\IdeaProjects\\DataScience-ExamProject\\DataScience-SongManagement\\data\\cleanedDatasetWithFeatures.csv")).
                            withSkipLines(1). // Skiping first line as it is header. // TODO - Replace with own path.
                            build();
            List<AudioFeatures> musicList = reader.readAll().stream().map(data-> {
                AudioFeatures audioFeatures = new AudioFeatures();
                audioFeatures.setAudioId(Integer.parseInt(data[0]));
                audioFeatures.setDanceability(Double.parseDouble(data[9]));
                audioFeatures.setEnergy(Double.parseDouble(data[10]));
                audioFeatures.setKey(Double.parseDouble(data[11]));
                audioFeatures.setLoudness(Double.parseDouble(data[12]));
                audioFeatures.setSpeechiness(Double.parseDouble(data[13]));
                audioFeatures.setAcousticness(Double.parseDouble(data[14]));
                audioFeatures.setInstrumentalness(Double.parseDouble(data[15]));
                audioFeatures.setLiveness(Double.parseDouble(data[16]));
                audioFeatures.setValence(Double.parseDouble(data[17]));
                audioFeatures.setTempo(Double.parseDouble(data[18]));
                audioFeatures.setDuration_ms(Double.parseDouble(data[19]));
                return audioFeatures;
            }).collect(Collectors.toList());
            return musicList;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<AudioFeatures>();
        }
    }

    public int storeListOfFeaturesInDB(List<AudioFeatures> musicList) {
        return featureRepository.saveAll(musicList).size();
    }

}
