package dsdb.users.Service;

import com.github.javafaker.Faker;
import dsdb.users.Model.Address;
import dsdb.users.Model.Person;
import dsdb.users.Model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FakerUsers {

    public User createFakeUser() {
        Random random = new Random();
        Faker faker = new Faker();
        User user = new User();
        Person person = new Person();
        // Generate name.
        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());
        // Generate email
        String shortname = person.getFirstName().substring(0,3)+person.getLastName().substring(0,3);
        user.setUsername(shortname);
        user.setEmail(shortname.toLowerCase(Locale.ROOT)+(random.nextInt(899)+100)+"@gmail.com");
        // Generate Birthdate.
        Date birthdate = new Date(faker.date().birthday(0, 90).getTime());
        person.setBirthdate(birthdate);
        // Generate password.
        String password = faker.crypto().md5();
        user.setPassword(password);
        // Get random address.
        FakerAddress fakerAddress = new FakerAddress();
        Address address = fakerAddress.createAddress();
        person.setAddress(address);
        user.setPerson(person);
        return user;
    }
}
