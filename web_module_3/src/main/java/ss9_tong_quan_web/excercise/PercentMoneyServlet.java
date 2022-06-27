package ss9_tong_quan_web.excercise;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PercentMoneyServlet", value = "/change")
public class PercentMoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float money = Float.parseFloat(request.getParameter("money"));
        float percent = Float.parseFloat(request.getParameter("percent"));

        double discountAmount = money * percent * 0.01;
        double discountPrice = money - discountAmount;

        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ss9_tong_quan_web/excercise/displaygit.jsp");
        requestDispatcher.forward(request,response);
    }
}
