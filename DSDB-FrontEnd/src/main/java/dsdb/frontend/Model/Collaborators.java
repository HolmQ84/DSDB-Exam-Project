package dsdb.frontend.Model;

import java.util.ArrayList;
import java.util.List;

public class Collaborators {
    private List<String> singers = new ArrayList<>();
    private List<String> writers = new ArrayList<>();
    private List<String> producers = new ArrayList<>();
    private List<String> featurings = new ArrayList<>();


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

    public List<String> getFeaturings() {
        return featurings;
    }

    public void setFeaturings(String featuring) {
        this.featurings.add(featuring);
    }
}
