/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controle;

import dominio.DaoUsuario;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitória
 */
@WebServlet(name = "ControleUsuario", urlPatterns = {"/ControleUsuario"})
public class ControleUsuario extends HttpServlet {
       private Usuario usu = new Usuario(null, null, null, null);
       private DaoUsuario daoUsu = new DaoUsuario();
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControleUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControleUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.getWriter().append("served at: ").append(request.getContextPath());
        System.out.println("GET CHEGOU!!");
        try {
             List<Usuario> lu = daoUsu.consultar();
             request.setAttribute("lu", lu);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
           }
        request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperar os dados enviados pelo formulário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = (request.getParameter("telefone"));
        String cpf = (request.getParameter("cpf"));
        usu.setNome(nome);
        usu.setEmail(email);
        usu.setTelefone(telefone);
        usu.setCpf(cpf);
        System.out.println(nome);
        System.out.println(email);
        System.out.println(telefone);
        System.out.println(cpf);
           try {
               daoUsu.inserir(nome, email, telefone, cpf);
               response.sendRedirect("listarUsuarios.jsp");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
           }
    }


}
