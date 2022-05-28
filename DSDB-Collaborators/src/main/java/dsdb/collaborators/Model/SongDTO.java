package dsdb.collaborators.Model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
public class SongDTO {
    private String name;
    private List<String> singers = new ArrayList<>();
    private List<String> producers = new ArrayList<>();
    private List<String> writers = new ArrayList<>();
    private List<String> features = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSingers() {
        return singers;
    }

    public void addSinger(String singer) {
        this.singers.add(singer);
    }

    public List<String> getProducers() {
        return producers;
    }

    public void addProducer(String producer) {
        this.producers.add(producer);
    }

    public List<String> getWriters() {
        return writers;
    }

    public void addWriter(String writer) {
        this.writers.add(writer);
    }

    public List<String> getFeatures() {
        return features;
    }

    public void addFeature(String feature) {
        this.features.add(feature);
    }
}
