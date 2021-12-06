import java.sql.*;

public class DBConnection {
    public static String getVal(String room) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "1234");
        Statement statement = connection.createStatement();
        String result = "";
        String query = "select * from users where roomId = " + room;
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            result += resultSet.getString("userId");
            result+=" : ";
            result+=resultSet.getString("message")+'\n';
        }
        return result;
    }

    public static void postVal(String uid, String rid, String msg) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "1234");
        Statement statement = connection.createStatement();
        String query = "insert  into users (roomId,userId,message) values ("+"'"+uid+"'"+","+"'"+rid+"'"+","+"'"+msg+"'"+")";
        statement.executeUpdate(query);
        //return query;
    }
}
