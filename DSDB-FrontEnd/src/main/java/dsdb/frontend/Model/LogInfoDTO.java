package dsdb.frontend.Model;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
@Data
public class LogInfoDTO {
    public int numberOfVisitors;
    public String mostVisitedPage;
    public double avgPages;
    public int avgTime;
    public Map<String, Integer> pages = new HashMap<>();
    public Map<Integer, Integer> visitTimeOfDay = new HashMap<>();

    public LogInfoDTO() {
        visitTimeOfDay.put(1, 0);
        visitTimeOfDay.put(2, 0);
        visitTimeOfDay.put(3, 0);
        visitTimeOfDay.put(4, 0);
        visitTimeOfDay.put(5, 0);
        visitTimeOfDay.put(6, 0);
        visitTimeOfDay.put(7, 0);
        visitTimeOfDay.put(8, 0);
        visitTimeOfDay.put(9, 0);
        visitTimeOfDay.put(10, 0);
        visitTimeOfDay.put(11, 0);
        visitTimeOfDay.put(12, 0);
        visitTimeOfDay.put(13, 0);
        visitTimeOfDay.put(14, 0);
        visitTimeOfDay.put(15, 0);
        visitTimeOfDay.put(16, 0);
        visitTimeOfDay.put(17, 0);
        visitTimeOfDay.put(18, 0);
        visitTimeOfDay.put(19, 0);
        visitTimeOfDay.put(20, 0);
        visitTimeOfDay.put(21, 0);
        visitTimeOfDay.put(22, 0);
        visitTimeOfDay.put(23, 0);
        visitTimeOfDay.put(24, 0);
    }
}
