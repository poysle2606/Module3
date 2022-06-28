import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperation = Float.parseFloat(request.getParameter("firstOperand"));
        float secondOperation = Float.parseFloat(request.getParameter("secondOperand"));
        String operator = request.getParameter("operand");
        PrintWriter write = response.getWriter();
        write.println("<html>");
        write.println("<h1>Result:</h1>");
        try{
            float result = Calculator.calculate(firstOperation,secondOperation,operator);
            write.println(firstOperation + " " + operator + " " + secondOperation + "" + "=" + result);
        } catch (Exception e) {
         write.println("Exception" + e.getMessage());
        }
        write.println("</html>");
    }
}
