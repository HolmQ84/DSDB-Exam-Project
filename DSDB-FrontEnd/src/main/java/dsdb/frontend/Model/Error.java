package dsdb.frontend.Model;

import lombok.Data;

import java.util.Date;

@Data
public class Error {
    private int errorId;
    private String errorMessage;
    private String timeStamp;
    private String errorClass;

    public Error(String errorMessage, String errorClass) {
        this.errorMessage = errorMessage;
        this.errorClass = errorClass;
        this.timeStamp = new Date().toString();
    }
}
