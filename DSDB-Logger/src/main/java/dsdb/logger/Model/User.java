package dsdb.logger.Model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "users")
public class User implements Serializable {
    private int userId;
    private String username;
    private String email;
    private String userLevel;
    private String loggerMessage;
}
