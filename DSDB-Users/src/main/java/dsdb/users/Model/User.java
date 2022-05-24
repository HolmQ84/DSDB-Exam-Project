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
    private String userLevel;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    public User(int userId, String username, String password, String email, String userLevel, Person person) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userLevel = userLevel;
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
                ", userLevel=" + userLevel +
                '}';
    }
}
