package br.cesjf.lppo.servlets;

import br.cesjf.lppo.DAO.ColetaDAO;
import br.cesjf.lppo.classes.Coleta;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = sdf.parse(request.getParameter("data"));
        } catch (ParseException ex) {
            Logger.getLogger(CriaColetaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Coleta novaColeta = new Coleta();
        novaColeta.setDescricao(request.getParameter("descricao"));
        novaColeta.setData(data);

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
