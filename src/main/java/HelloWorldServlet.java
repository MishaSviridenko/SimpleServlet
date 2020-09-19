import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        HelloWorld helloWorld = new HelloWorld();
        String message = helloWorld.helloWorld();

        ServletContext servletContext = getServletContext();
        request.setAttribute(Constants.MESSAGE, message);
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(
                Constants.SLASH + Constants.START_PAGE);
        requestDispatcher.forward(request, response);
    }
}
