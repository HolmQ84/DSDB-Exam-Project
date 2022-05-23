package dsdb.collaborators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableNeo4jRepositories("dsdb.collaborators.repository")
@SpringBootApplication(scanBasePackages = {"dsdb.collaborators"})
public class DsdbCollaboratorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsdbCollaboratorsApplication.class, args);
    }

}
