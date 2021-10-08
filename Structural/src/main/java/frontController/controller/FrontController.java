package frontController.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Anderson Matte
 */
@WebServlet("*.andersonmatte")
public class FrontController extends HttpServlet {

    private static final Long serialVersionUID = 1L;

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String[] split = httpServletRequest.getRequestURI().split("/");

        String controllerName = split[2];
        String actionName = split[3].split("\\.")[0];

        System.out.println(controllerName);
        System.out.println(actionName);

        try {
            Class<?> controllerClass = Class.forName("controllers." + controllerName);
            Method method = controllerClass.getDeclaredMethod(actionName);

            Object controller = controllerClass.newInstance();
            method.invoke(controller);

            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + controllerName + "/" + actionName + " .jsp");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
