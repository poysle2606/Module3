package controller;

import model.Users;
import repository.UsersRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {

    UsersRepositoryImpl usersRepository = new UsersRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                    deleteUser(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //hiển thị danh sách người dùng.
    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> usersList = usersRepository.selectAllUsers();
        request.setAttribute("userList", usersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Users newUser = new Users(name, email, address);
        usersRepository.insertUser(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
        request.setAttribute("message", "Create User success.");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Users users = new Users(id, name, email, address);
        usersRepository.updateUsers(users);
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = usersRepository.selectUser(id);
        request.setAttribute("users", users);
        request.getRequestDispatcher("edit.jsp").forward(request, response);

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean users = usersRepository.deleteUsers(id);
        request.setAttribute("users",users);
        request.getRequestDispatcher("delete.jsp").forward(request,response);

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {

    }

}
