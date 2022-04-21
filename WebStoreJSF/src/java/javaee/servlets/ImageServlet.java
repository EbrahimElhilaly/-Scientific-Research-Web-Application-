/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.servlets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author helali
 */
@WebServlet(name = "ImageServlet", urlPatterns = {"/ImageServlet"})
public class ImageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
     
     
	 OutputStream os = response.getOutputStream();

        String employeeId = request.getParameter("id");

        Connection conn = null;
        try {

              DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "ebook", "ebook");
//                    
//                    Context ctx = new InitialContext();
//                    DataSource ds = (DataSource) ctx.lookup("ACCDS"); 
//                    conn = ds.getConnection();

            System.out.println("DB Connection ok");

            String sql = "SELECT BOOK_ID, BOOK_IMAGE "
                    + " FROM BOOK"
                    + " WHERE BOOK_ID =?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, employeeId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob("BOOK_IMAGE");
                BufferedInputStream in = new BufferedInputStream(blob.getBinaryStream());
                int b;
                byte[] buffer = new byte[10240];
                while ((b = in.read(buffer, 0, 10240)) != -1) {
                    os.write(buffer, 0, b);
                }
                os.close();
            } else {

                ServletContext sc = getServletContext();
                String filename = sc.getRealPath("/resources/img/no-profile-img.gif"); ////image if DB no image
                String mimeType = sc.getMimeType(filename);
                response.setContentType(mimeType);
                File file = new File(filename);
                response.setContentLength((int) file.length());
                FileInputStream in = new FileInputStream(file);
                OutputStream out = response.getOutputStream();
                byte[] buf = new byte[1024];
                int count = 0;
                while ((count = in.read(buf)) >= 0) {
                    out.write(buf, 0, count);
                }
                in.close();
                out.close();
            }

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
            ServletContext sc = getServletContext();
            String filename = "";
            filename = sc.getRealPath("/resources/img/no-profile-img.gif");//image error
            String mimeType = sc.getMimeType(filename);
            response.setContentType(mimeType);
            File file = new File(filename);
            response.setContentLength((int) file.length());
            FileInputStream in = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            byte[] buf = new byte[1024];
            int count = 0;
            while ((count = in.read(buf)) >= 0) {
                out.write(buf, 0, count);
            }
            in.close();
            out.close();

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sql) {
                System.out.println("SQLException error");
            }
        }

    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
