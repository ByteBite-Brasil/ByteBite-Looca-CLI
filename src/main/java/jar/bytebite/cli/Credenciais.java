/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jar.bytebite.cli;

import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ViniciusJesus
 */
public class Credenciais {
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConnection();
    private String id;
    private String senha;

//    public Credenciais(String id, String senha) {
//        this.id = id;
//        this.senha = senha;
//    }
    public Boolean selectLogin(String id, String senha) {
        try {
            Map<String, Object> registro = con.queryForMap(
                    "select * from maquina where idMaquina = ? and senha = ?", this.id, this.senha);
            System.out.println("Login realizado com sucesso.");
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
