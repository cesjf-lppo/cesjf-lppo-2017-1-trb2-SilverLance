package br.cesjf.lppo.servlets;

import br.cesjf.lppo.DAO.ColetaDAO;
import br.cesjf.lppo.classes.Coleta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adriano
 */
@WebServlet(name = "ListarColetasServlet", urlPatterns = {"/listar-coletas.html"})
public class ListarColetasServlet extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Coleta> coletas;
        
        try {
            ColetaDAO dao = new ColetaDAO();
            coletas = dao.listarColetas();
        } catch (Exception ex) {
            Logger.getLogger(ListarColetasServlet.class.getName()).log(Level.SEVERE, null, ex);
            coletas = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
    
        request.setAttribute("coletas", coletas);
        request.getRequestDispatcher("/WEB-INF/listar-coletas.jsp").forward(request, response);
    }

}
