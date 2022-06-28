package controller;

import customers.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer("Mai Van Hoan", "1983-8-23", "Ha Noi", "https://i.pinimg.com/564x/93/89/38/938938a4a0be44821f63bfa2bcdd52d3.jpg"));
        customers.add(new Customer("Nguyen Van Nam", "1983-08-21", "Bac Giang", "https://znews-photo.zingcdn.me/w660/Uploaded/ofh_btgazspf/2019_10_20/1_1.jpg"));
        customers.add(new Customer("Nguyen Thai Hoa", "1983-08-23", "Nam Dinh", "https://static2.yan.vn/YanNews/2167221/202003/meme-la-gi-meme-bat-nguon-tu-dau-7cd70894-a3891f06.png"));
        customers.add(new Customer("Tran Dang Khoa", "1983-08-17", "Ha Tay", "https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/10/meme-hot-1.jpg"));
        customers.add(new Customer("Nguyen Dinh Thi", "1983-08-19", "Ha Noi", "https://i.pinimg.com/564x/93/89/38/938938a4a0be44821f63bfa2bcdd52d3.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customers);
        request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
