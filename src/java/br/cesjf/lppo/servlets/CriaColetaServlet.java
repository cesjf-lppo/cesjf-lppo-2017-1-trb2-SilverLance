package br.cesjf.lppo.servlets;

import br.cesjf.lppo.DAO.ColetaDAO;
import br.cesjf.lppo.classes.Coleta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adriano
 */
@WebServlet(name = "CriaColetaServlet", urlPatterns = {"/nova-coleta.html"})
public class CriaColetaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/nova-coleta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Coleta novaColeta = new Coleta();
        novaColeta.setDescricao(request.getParameter("descricao"));
        
        try {
            ColetaDAO dao = new ColetaDAO();
            dao.criarColeta(novaColeta);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/nova-coleta.jsp");
            
        }
        
        response.sendRedirect("listar-coletas.html");
        
    }

}
