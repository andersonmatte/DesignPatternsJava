package br.com.webmatte.estrutural.frontcontroller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Anderson Matte
 */
@Slf4j
@WebServlet("*.andersonmatte")
public class FrontController extends HttpServlet {

    @Override
    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String[] split = httpServletRequest.getRequestURI().split("/");

        String controllerName = split[2];
        String actionName = split[3].split("\\.")[0];

        log.info(controllerName);
        log.info(actionName);

        try {
            Class<?> controllerClass = Class.forName("controllers." + controllerName);
            Method method = controllerClass.getDeclaredMethod(actionName);

            Object controller = controllerClass.getDeclaredConstructor().newInstance();
            method.invoke(controller);

            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/" + controllerName + "/" + actionName + " .jsp");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);

        } catch (Exception e) {
            log.error("Error processing request for controller: {}, action: {}", controllerName, actionName, e);
        }

    }

}
