import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class myRegister extends HttpServlet {
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

        String fname = request.getParameter("fname");
        String sname = request.getParameter("sname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pnumber = request.getParameter("pnumber");

        try {
            PreparedStatement st = con.prepareStatement(
                    "INSERT INTO Customers (FirstName, SecondName, Username, Password, Mobile) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, fname);
            st.setString(2, sname);
            st.setString(3, username);
            st.setString(4, password);
            st.setString(5, pnumber);

            st.executeUpdate();

            out.println("<h3 style='text-align:center; color:green;'>Registered successfully!</h3>");
            out.println("<h3 style='text-align:center;'><a href='myLogin.jsp'>Login here</a></h3>");
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
