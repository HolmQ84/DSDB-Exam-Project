package dsdb.features.controller;

import dsdb.features.model.AudioFeatures;
import dsdb.features.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @GetMapping("/")
    public List<AudioFeatures> getAllAudioFeatures() {
        return featureService.findAllAudioFeatures();
    }

    @GetMapping("/{audioId}")
    public AudioFeatures getUserById(@PathVariable int audioId) {
        return featureService.getAudioFeaturesById(audioId);
    }

    @PostMapping("/")
    public AudioFeatures createNewAudioFeatures(@RequestBody AudioFeatures audioFeatures) {
        return featureService.createNewAudioFeature(audioFeatures);
    }

    @PutMapping("/{audioId}")
    public AudioFeatures updateExistingUser(@PathVariable int audioId, @RequestBody AudioFeatures audioFeatures) {
        return featureService.updateAudioFeatures(audioId, audioFeatures);
    }

    @DeleteMapping("/{audioId}")
    public String deleteExistingUser(@PathVariable int audioId) {
        return featureService.deleteAudioFeatures(audioId);
    }

    @GetMapping("/db/fill")
    public String fillDBWithAudioFeatures() {
        int value = featureService.storeListOfFeaturesInDB(featureService.convertCSVtoListOfMusic());
        return "Music list successfully stored in MongoDB. " + value + " song added.";
    }
}
