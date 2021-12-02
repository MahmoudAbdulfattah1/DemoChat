
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "chat",urlPatterns = "/chat")
public class Demo_servlet extends HttpServlet {
    String userId,roomId,message;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    HashMap<String, ArrayList<String>> data = new HashMap<String ,ArrayList<String>>();
    ArrayList<String> messages=new ArrayList();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("RID");

        for (String msg: data.get(id)){
            response.getWriter().println(msg);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userId=request.getParameter("UID");
        roomId=request.getParameter("RID");
        message=request.getParameter("MSG");
        messages.add(userId+":"+message+" "+now);
        data.put(roomId,messages);
        response.setStatus(200);

    }
}
