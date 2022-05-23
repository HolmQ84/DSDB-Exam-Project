package dsdb.collaborators.repository;

import dsdb.collaborators.Model.Person;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (person:Person) RETURN person")
    List<Person> getAllPersons();

    Person getPersonByName(String name);

    Iterable<Person> findPersonByNameLike(String name);

    @Query("MATCH (am:Song)<-[ai:SANG]-(p:Person)-[d:PRODUCED]->(dm:Song) return p, collect(ai), collect(d), collect(am), collect(dm)")
    List<Person> getPersonsWhoActAndDirect();


}
