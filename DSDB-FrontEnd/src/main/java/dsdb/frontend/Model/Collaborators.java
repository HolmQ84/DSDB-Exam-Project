package dsdb.frontend.Model;

import java.util.ArrayList;
import java.util.List;

public class Collaborators {
    private final List<String> singers = new ArrayList<>();
    private final List<String> writers = new ArrayList<>();
    private final List<String> producers = new ArrayList<>();
    private final List<String> features = new ArrayList<>();

    public List<String> getSingers() {
        return singers;
    }

    public void addSinger(String singer) {
        this.singers.add(singer);
    }

    public List<String> getWriters() {
        return writers;
    }

    public void addWriter(String writer) {
        this.writers.add(writer);
    }

    public List<String> getProducers() {
        return producers;
    }

    public void addProducer(String producer) {
        this.producers.add(producer);
    }

    public List<String> getFeatures() {
        return features;
    }

    public void addFeatures(String features) {
        this.producers.add(features);
    }
}
