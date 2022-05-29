package dsdb.frontend;

import dsdb.frontend.Model.User;
import dsdb.frontend.Service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class Test {

    static UserClient userClient;

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        if (map.containsKey(1)) {
            map.put(1, map.get(1)+1);
        }
        System.out.println(map);
    }
}
