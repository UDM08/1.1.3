package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    private Connection connection = getConnection();

    public void createUsersTable() {
        PreparedStatement preparedStatement = null;
        String sql = ("CREATE TABLE USERS (Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,Name VARCHAR(20) NOT NULL,last_Name VARCHAR(40) NOT NULL, Age INT NOT NULL)");
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dropUsersTable() {
        PreparedStatement preparedStatement = null;
        String sql = ("DROP TABLE USERS");
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement preparedStatement = null;
        String sql = ("INSERT INTO USERS (name, last_name, age) values (?, ?, ?)");

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User имя "+ name + " фамилия "+ lastName + " возраст "+ age + " добавлен в базу данных ");

        } catch (SQLException |NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void removeUserById(long id) {
        PreparedStatement preparedStatement = null;
        String SQL = "DELETE FROM USERS WHERE ID=?";
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<User> getAllUsers() {

        String sql = "SELECT * FROM USERS";
        List<User> users = new ArrayList<>();
        try {
            connection = getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge((byte) resultSet.getInt("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    }
                }
            }
        return users;
    }

    public void cleanUsersTable() {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USERS";
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (SQLException |NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
