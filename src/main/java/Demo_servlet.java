
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "chat", urlPatterns = "/chat")
public class Demo_servlet extends HttpServlet {
    String userId, roomId, message;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("RID");
        try {
            String result = DBConnection.getVal(id);
            System.out.println(result);
            response.getWriter().println(result);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userId = request.getParameter("UID");
        roomId = request.getParameter("RID");
        message = request.getParameter("MSG");

        try {
            DBConnection.postVal(roomId, userId, message);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        response.setStatus(200);

    }
}
