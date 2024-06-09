package com.rossypotentials.controller;

import com.rossypotentials.dao.UserDao;
import com.rossypotentials.model.User;
import com.rossypotentials.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "user", value = "/signup")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email  = request.getParameter("email");
        String password= request.getParameter("password");

        //Instantiate User and UserDao class
        User newUser = new User(firstName,lastName,email,password);
        UserDao userDao = new UserDao(ConnectionUtil.getConnection());
        userDao.addUser(newUser);

        response.sendRedirect("signup-Success.jsp");
    }
}
