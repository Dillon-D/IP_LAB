import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p12_db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/character", "root", "");
            if (conn != null) {
                out.println("<h1> Character Information</h1>");
            }
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM characters";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String cid = rs.getString("cid");
                String Name = rs.getString("Name");
                String Anime_name = rs.getString("Anime_name");
                Integer Imdb_rating = rs.getInt("Imdb_rating");
                Integer Total_no_of_episodes = rs.getInt("Total_no_of_episodes");
                out.println("<hr><p> <b>Character ID :</b> " + cid + "<br>");
                out.println("<b>Name : </b>" + Name + "<br>");
                out.println("<b>Anime Name : </b>" + Anime_name + "<br>");
                out.println("<b>Imdb Rating : </b>" + Imdb_rating + "<br>");
                out.println("<b>Total Episodes : </b>" + Total_no_of_episodes + "<br></p>");
            }
            out.println("</body></html>");
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}
