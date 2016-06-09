/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl_BD;

import dao.DevolucaoDao;
import static dao.impl_BD.DaoBd.comando;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Devolucao;
import model.Retirada;

/**
 *
 * @author saulovieira
 */
public class DevolucaoDaoBd  extends DaoBd<Devolucao> implements DevolucaoDao{
    
    
    public void salvar(Retirada retirada) {
        int id = 0;
        try {
            String sql = "INSERT INTO devolucao (retirada, devolvido)"
                    + "VALUES (?,?)";
            conectarObtendoId(sql);
            
            comando.setInt(1, retirada.getId());
            java.sql.Date dataSqldevolvido = new java.sql.Date(System.currentTimeMillis());
            comando.setDate(2, dataSqldevolvido);
           
            comando.executeUpdate();
            //Obtém o resultSet para pegar a matricula
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta a matricula para o objeto
                id = resultado.getInt(1);
                retirada.setId(id);
            }
            else{
                System.err.println("Erro de Sistema - Nao gerou Id conforme esperado!");
                throw new BDException("Nao gerou a Id conforme esperado!");
            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao salvar retirada no Banco de Dados!");
            throw new RuntimeException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void salvar(Devolucao dominio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Devolucao objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Devolucao objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Devolucao> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Devolucao procurarPorId(int matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}