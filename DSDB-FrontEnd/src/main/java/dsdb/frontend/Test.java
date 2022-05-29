package dsdb.frontend;

import dsdb.frontend.Model.User;
import dsdb.frontend.Service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Test {

    static UserClient userClient;

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("Two", 1);
        map.put("Three", 1);
        if (map.containsKey("One")) {
            map.put("One", map.get("One")+1);
        }
        System.out.println(Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());
    }
}
