package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Util util = new Util();
        util.getConnection();
        UserServiceImpl userS = new UserServiceImpl();
        userS.createUsersTable();
        userS.saveUser("Maksim", "Fedorov", (byte) 22);
        userS.saveUser("Dima", "Alekseev", (byte) 26);
        userS.saveUser("Ivan", "Ivanov", (byte) 25);
        userS.removeUserById(4);
        List<User> user = userS.getAllUsers();
        for(User u:user){
            System.out.println(u.toString());
        }
        userS.cleanUsersTable();
        userS.dropUsersTable();

    }
}




