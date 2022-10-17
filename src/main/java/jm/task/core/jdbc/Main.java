package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final UserService userS = new UserServiceImpl();
    public static void main(String[] args) throws SQLException {

        userS.createUsersTable();
        userS.saveUser("Maksim", "Fedorov", (byte) 22);
        userS.saveUser("Dima", "Alekseev", (byte) 26);
        userS.saveUser("Ivan", "Ivanov", (byte) 25);
        userS.removeUserById(4);
        userS.getAllUsers();
        userS.cleanUsersTable();
        userS.dropUsersTable();

    }
}




