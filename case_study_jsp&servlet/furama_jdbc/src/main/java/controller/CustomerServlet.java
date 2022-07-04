package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.class_repository.CustomerTypeRepository;
import service.class_service.CustomerService;
import service.class_service.CustomerTypeService;
import service.interface_service.ICustomerService;
import service.interface_service.ICustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    List<Customer> customerList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                findAllCustomer(request, response);
                break;
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
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                findAllCustomer(request, response);
                break;
        }
    }

    private void findAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerList = customerService.findAll();
        request.setAttribute("customer", customerList);
        request.getRequestDispatcher("view/list.jsp").forward(request,response);
    }
}
