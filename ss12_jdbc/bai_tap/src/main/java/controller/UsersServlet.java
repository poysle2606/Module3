package controller;

import model.Users;
import repository.IUsersRepository;
import repository.UsersRepositoryImpl;
import service.IUsersService;
import service.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UsersServlet", value = "/user")
public class UsersServlet extends HttpServlet {
    IUsersService repository = new UsersServiceImpl();
    List<Users> usersList = new ArrayList<>();

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
                removeUsers(request, response);

                break;
            case "Search":
                findByName(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
            default:
                allListUser(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addUsers(request, response);
                break;
            case "edit":
                editUsers(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                allListUser(request, response);
        }
    }

    private void allListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        usersList = repository.findAll();
        usersList = repository.findAllSp();
        request.setAttribute("users", usersList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void addUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Users users = new Users(name, email, address);
        repository.createUser(users);
        response.sendRedirect("/user");

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = repository.findById(id);
        request.setAttribute("users", users);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void editUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Users users = new Users(id, name, email, address);
        // repository.editUsers(users);
        repository.updateUsersSp(users);
        response.sendRedirect("/user");
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("searchName");
        usersList = repository.findByName(name);
        request.setAttribute("users", usersList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = repository.findById(id);
        request.setAttribute("users", users);
        request.getRequestDispatcher("delete.jsp").forward(request, response);
    }

//    public void removeUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        repository.deleteUser(id);
//        List<Users> users = repository.findAll();
//        request.setAttribute("users", users);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
//        dispatcher.forward(request, response);
//    }

    public void removeUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        repository.deleteUser(id);
        repository.deleteUsersSp(id);
        List<Users> users = repository.findAll();
        request.setAttribute("users",users);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        usersList = repository.sort(name);
        request.setAttribute("users", usersList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
