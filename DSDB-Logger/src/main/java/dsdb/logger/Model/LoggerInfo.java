package dsdb.logger.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "log")
public class LoggerInfo implements Serializable {
    private String name;
    private String type;
    private String start;
    private String end;

}
