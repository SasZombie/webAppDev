package org.example.lab2.services;
import org.example.lab2.domain.User;
import org.example.lab2.domain.User;

import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends CoreJDBCDao implements UserService {

    List<User> users = new ArrayList(List.of(
            new User(28L, "Andrei", "andrei@yahoo.com"),
            new User(20L, "John", "john@outlook.com"),
            new User(19L, "Gabriel", "sadStudent@gmail.com"))
    );
 
    @Override
    public List<User> findAll() {
        List<User> users=new ArrayList<>();
        String findAllAddressSQL = "SELECT * FROM Users";
        try (
                PreparedStatement findAllAddress = connection.prepareStatement(findAllAddressSQL);
        ) {
            ResultSet rs = findAllAddress.executeQuery();
            while (rs.next()){
                User ad=new User(rs.getLong("id"),rs.getString("name"), 
                                    rs.getString("email"));
                users.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User p) {
        List<User> Users = findAll();
        if(Users.contains(p))
            return;

        String insertAddressSQL = "INSERT into Users(name, email) values(?,?)";
        try (
           PreparedStatement insertUsers = connection.prepareStatement(insertAddressSQL);
        ) {
            insertUsers.setString(2, p.getName());
            insertUsers.setString(2, p.getEmail());

            insertUsers.executeQuery();
            ResultSet generatedKeys = insertUsers.getGeneratedKeys();
            if (generatedKeys.next()) {
                p.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
