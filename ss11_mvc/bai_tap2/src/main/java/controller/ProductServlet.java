package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    List<Product> productList = new ArrayList<>();
    IProductService iProductService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("view/create.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "Search":
                searchByName(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
            default:
                findAll(request, response);
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
                creatProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            default:
                findAll(request, response);
                break;
        }
    }


    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productList = iProductService.findAll();
        request.setAttribute("product", productList);
        request.getRequestDispatcher("view/list.jsp").forward(request, response);
    }

    private void creatProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String production = request.getParameter("production");

        Product product = new Product(name, price, production);
        iProductService.create(product);
        response.sendRedirect("/products");

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view/edit.jsp").forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String production = request.getParameter("production");

        Product product = new Product(id, name, price, production);
        iProductService.edit(product);
        response.sendRedirect("/products");
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("searchName");
        productList = iProductService.findByName(name);
        request.setAttribute("product", productList);
        request.getRequestDispatcher("view/search.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.delete(id);
        List<Product> productList = iProductService.findAll();
        request.setAttribute("product", productList);
        request.getRequestDispatcher("view/list.jsp").forward(request, response);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
       List<Product> list = iProductService.sortByName(name);
       request.setAttribute("product", list);
       request.getRequestDispatcher("view/list.jsp").forward(request,response);
    }
}
