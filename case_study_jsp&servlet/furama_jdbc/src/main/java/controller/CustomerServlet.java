package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import service.class_service.customer.CustomerService;
import service.class_service.customer.CustomerTypeService;
import service.interface_service.customer.ICustomerService;
import service.interface_service.customer.ICustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

    ICustomerService customerService = new CustomerService();
    ICustomerTypeService customerTypeService = new CustomerTypeService();

    List<Customer> customerList = new ArrayList<>();
    List<CustomerType> customerTypes = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditCustomer(request, response);
                break;
            case "search":
                searchByName(request, response);
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
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                findAllCustomer(request, response);
                break;
        }
    }

    private void findAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerList = customerService.findAll();
        request.setAttribute("customer", customerList);

        customerTypes = customerTypeService.listCustomer();
        request.setAttribute("customerType", customerTypes);

        request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerTypes = customerTypeService.listCustomer();
        request.setAttribute("customerType", customerTypes);
        request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idType = Integer.parseInt(request.getParameter("typeCustomer"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String numberPhone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(idType, name, dayOfBirth, gender, idCard, numberPhone, email, address);
        customerService.createCustomer(customer);

        response.sendRedirect("/customer");
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerTypes = customerTypeService.listCustomer();
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.setAttribute("customerType", customerTypes);
        request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idType = Integer.parseInt(request.getParameter("typeCustomer"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String numberPhone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, idType, name, dayOfBirth, gender, idCard, numberPhone, email, address);
        customerService.editCustomer(customer);
        try {
            findAllCustomer(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        customerService.deleteCustomer(id);

        List<Customer> customers = customerService.findAll();
        request.setAttribute("customer", customers);

        customerTypes = customerTypeService.listCustomer();
        request.setAttribute("customerType", customerTypes);

        request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String type = request.getParameter("type");

        customerList = customerService.findCustomer(name,email,type);
        request.setAttribute("customer", customerList);
        customerTypes = customerTypeService.listCustomer();
        request.setAttribute("customerType", customerTypes);
        request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
    }

}
