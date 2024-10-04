import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class myLogin extends HttpServlet {
    private Connection con;

    public void init(ServletConfig config) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java03", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            PreparedStatement st = con.prepareStatement(
                    "SELECT * FROM Customers WHERE username = ? AND password = ?");
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String fullName = rs.getString("FirstName") + " " + rs.getString("SecondName");
                out.println("<h3 style='text-align:center; color:blue;'>Welcome, " + fullName + "</h3>");
            } else {
                out.println("<h3 style='text-align:center; color:red;'>Username or password does not match</h3>");
                out.println("<h3 style='text-align:center;'><a href='myLogin.jsp'>Try again</a></h3>");
            }
        } catch (SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
