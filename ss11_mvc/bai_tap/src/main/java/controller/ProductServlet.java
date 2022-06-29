package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    static List<Product> productList = new ArrayList<>();
    private IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(request, response);
                break;
            case "edit":
                showEditProduct(request, response);
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                listProduct(request, response);
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
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productList = productService.findAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = idCreate();
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String production = request.getParameter("production");

        Product product = new Product(id, name, price, amount, production);
        this.productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        request.setAttribute("message", "Add new product success.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String production = request.getParameter("production");
        Product product = productService.findById(id);
        product.setName(name);
        product.setPrice(price);
        product.setAmount(amount);
        product.setProduction(production);

        productService.update(id, product);

        request.setAttribute("productList", productList);
        request.setAttribute("message", "Update product success.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int idCreate() {
        int max = 0;
        int id;
        for (Product product : productList) {
            if (product.getId() > max) {
                max = product.getId();
            }
        }
        id = max + 1;
        return id;
    }


}
