/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.webstore.controller.services;

import java.io.IOException;
import java.util.ArrayList;
import javaee.webstore.jdbc.users.User;
import javaee.webstore.jdbc.users.UserHandler;
import static javaee.webstore.jdbc.users.UserHandler.closeSession;
import static javaee.webstore.jdbc.users.UserHandler.openSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;

/**
 *
 * @author helali
 */
public class UserServices {

    public static int insertUser(User user) {

        UserHandler.insertUser(user);

        return 1;

    }

    public static int updateUser(User user) {

        UserHandler.updateUser(user);

        return 1;
    }

    public static User getUserById(int userId) {

        return UserHandler.getUserById(userId);
    }

    public static int deleteUser(int userId) {

        UserHandler.deleteUser(userId);

        return 1;
    }

    public static ArrayList<User> getAllUsers() {

        
            
        return UserHandler.getAllUsers();
    }

}
