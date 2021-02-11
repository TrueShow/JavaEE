package Lesson_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "HttpServlet", urlPatterns = "/test")
public class HttpServlet extends javax.servlet.http.HttpServlet {
    private static Logger LOG = LoggerFactory.getLogger(HttpServlet.class);
    ArrayList<Product> products = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        products.add(new Product(1,"Potato", 30));
        products.add(new Product(2,"Onion", 15.3));
        products.add(new Product(3,"Tomato", 100));
        products.add(new Product(4,"Milk", 60));
        products.add(new Product(5,"Curd", 110));
        products.add(new Product(6,"Yogurt", 55.4));
        products.add(new Product(7,"Cheese", 150.5));
        products.add(new Product(8,"Butter", 157));
        products.add(new Product(9,"Bacon", 167.9));
        products.add(new Product(10,"Bread", 30.2));
    }

    private void printProducts(ArrayList<Product> list, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        for (int i = 0; i < list.size(); i++) {
            writer.print("<h4>");
            writer.printf("%-3d%-15s%11.2f%n",list.get(i).getId(), list.get(i).getTitle(), list.get(i).getCost());
            writer.print("</h4>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("GET");
        resp.getWriter().println("<p>Продукты</p>");
        printProducts(products, resp);
    }
}
