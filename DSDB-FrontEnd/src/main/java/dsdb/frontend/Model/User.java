package dsdb.frontend.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String userLevel;
    private Person person;
}

