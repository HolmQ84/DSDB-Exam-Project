package dsdb.frontend;

import dsdb.frontend.Model.User;
import dsdb.frontend.Service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    static UserClient userClient;

    public static void main(String[] args) {
        User user = userClient.authenticate(new User());
        System.out.println(user);
    }
}
