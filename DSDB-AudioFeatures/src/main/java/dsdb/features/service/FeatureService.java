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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
                audioFeatures.setDanceability(data[8]);
                audioFeatures.setEnergy(data[9]);
                audioFeatures.setOnKey(data[10]);
                audioFeatures.setLoudness(data[11]);
                audioFeatures.setSpeechiness(data[12]);
                audioFeatures.setAcousticness(data[13]);
                audioFeatures.setInstrumentalness(data[14]);
                audioFeatures.setLiveness(data[15]);
                audioFeatures.setValence(data[16]);
                audioFeatures.setTempo(data[17]);
                audioFeatures.setDuration_ms(data[18]);
                return audioFeatures;
            }).collect(Collectors.toList());
            return musicList;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<AudioFeatures>();
        }
    }

    public int storeListOfFeaturesInDB(List<AudioFeatures> audioFeaturesList) {
        return featureRepository.saveAll(audioFeaturesList).size();
    }
}
