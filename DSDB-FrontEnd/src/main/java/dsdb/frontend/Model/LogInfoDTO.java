package dsdb.frontend.Model;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
@Data
public class LogInfoDTO {
    public int numberOfUsers;
    public double avgPages;
    public Map<String, Integer> pages = new HashMap<>();
    public int avgTime;
    public Map<Integer, Integer> visitTimeOfDay = new HashMap<>();
}
