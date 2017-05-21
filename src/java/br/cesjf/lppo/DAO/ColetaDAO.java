package br.cesjf.lppo.DAO;

import br.cesjf.lppo.classes.Coleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adriano
 */
public class ColetaDAO {
    private final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final PreparedStatement opListarColeta;
    private final PreparedStatement opNovaColeta;
    
    

    public ColetaDAO() throws Exception {
        Connection conexao = ConnectionFactory.createConnection();
        opListarColeta = conexao.prepareStatement("SELECT * FROM coleta");
        opNovaColeta = conexao.prepareStatement("INSERT INTO coleta(descricao, data) Values(?, ?)");
    }

    public List<Coleta> listarColetas() throws Exception {
        try {
            List<Coleta> coletas = new ArrayList<>();

            ResultSet resultado = opListarColeta.executeQuery();
            while (resultado.next()) {
                Coleta coletaAtual = new Coleta();
                coletaAtual.setId(resultado.getInt("id"));
                coletaAtual.setDescricao(resultado.getString("descricao"));
                coletaAtual.setData(resultado.getTimestamp("atualizacao"));
                coletas.add(coletaAtual);
            }
            return coletas;
        } catch (SQLException ex) {
            throw new Exception("Erro ao listar os coletas no banco!", ex);
        }
    }

    public void criarColeta(Coleta novaColeta) throws Exception {
        try {
            opNovaColeta.clearParameters();
            opNovaColeta.setLong(1, novaColeta.getId());
            opNovaColeta.setString(2, novaColeta.getDescricao());
            opNovaColeta.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir novo coleta!", ex);
        }
    }

}
