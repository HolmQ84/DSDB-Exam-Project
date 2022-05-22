package dsdb.users.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String username;
    private String password;
    private String email;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    public User(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username=" + username +
                ", password=" + password +
                ", email=" + email +
                ", person=" + person +
                '}';
    }
}
