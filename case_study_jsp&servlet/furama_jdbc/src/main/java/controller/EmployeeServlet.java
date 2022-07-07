package controller;

import model.employee.DivisionEmployee;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.PositionEmployee;
import service.class_service.employee.DivisionService;
import service.class_service.employee.EducationDegreeService;
import service.class_service.employee.EmployeeService;
import service.class_service.employee.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    EmployeeService employeeService = new EmployeeService();
    PositionService positionService = new PositionService();
    DivisionService divisionService = new DivisionService();
    EducationDegreeService degreeService = new EducationDegreeService();

    List<Employee> employeeList = new ArrayList<>();
    List<PositionEmployee> positionEmployeeList = new ArrayList<>();
    List<DivisionEmployee> divisionEmployees = new ArrayList<>();
    List<EducationDegree> degreeList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showEditEmployee(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                listEmployee(request, response);
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
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                listEmployee(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            positionEmployeeList = positionService.listPosition();
            request.setAttribute("position", positionEmployeeList);

            divisionEmployees = divisionService.listDivision();
            request.setAttribute("division",divisionEmployees);

            degreeList = degreeService.educationList();
            request.setAttribute("education", degreeList);
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        employeeList.clear();
        employeeList = employeeService.findAll();
        request.setAttribute("employee", employeeList);

        positionEmployeeList = positionService.listPosition();
        request.setAttribute("position", positionEmployeeList);

        divisionEmployees = divisionService.listDivision();
        request.setAttribute("division",divisionEmployees);

        degreeList = degreeService.educationList();
        request.setAttribute("education", degreeList);

        request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String numberPhone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int division = Integer.parseInt(request.getParameter("division"));
        int education = Integer.parseInt(request.getParameter("education"));

        Employee employee = new Employee(name, dayOfBirth, idCard, salary, numberPhone, email, address, position, division, education);
        employeeService.createEmployee(employee);
        response.sendRedirect("/employee");
    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);

        positionEmployeeList = positionService.listPosition();
        request.setAttribute("position", positionEmployeeList);

        divisionEmployees = divisionService.listDivision();
        request.setAttribute("division",divisionEmployees);

        degreeList = degreeService.educationList();
        request.setAttribute("education", degreeList);
        request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String numberPhone = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int division = Integer.parseInt(request.getParameter("division"));
        int education = Integer.parseInt(request.getParameter("education"));

        Employee employee = new Employee(id, name, dayOfBirth, idCard, salary, numberPhone, email, address, position, division, education);
        employeeService.editEmployee(employee);
        response.sendRedirect("/employee");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        employeeService.deleteEmployee(id);
        List<Employee> listEmployee = employeeService.findAll();
        request.setAttribute("employee", listEmployee);

        positionEmployeeList = positionService.listPosition();
        request.setAttribute("position", positionEmployeeList);

        divisionEmployees = divisionService.listDivision();
        request.setAttribute("division",divisionEmployees);

        degreeList = degreeService.educationList();
        request.setAttribute("education", degreeList);
        request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        employeeList = employeeService.findEmployee(name,email,address);
        request.setAttribute("employee",employeeList);

        positionEmployeeList = positionService.listPosition();
        request.setAttribute("position", positionEmployeeList);

        divisionEmployees = divisionService.listDivision();
        request.setAttribute("division",divisionEmployees);

        degreeList = degreeService.educationList();
        request.setAttribute("education", degreeList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
