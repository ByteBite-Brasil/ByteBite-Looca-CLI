/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jar.bytebite.cli;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author ViniciusJesus
 */
public class Login {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConnection();
        Captura captura = new Captura();
        Componente comp = new Componente();
        Credenciais credenciais = new Credenciais();
        Integer fkConfig;
        Scanner leitor = new Scanner(System.in);
        System.out.println("Olá, seja bem vindo ao sistema de captura de dados da ByteBite Solutions");
        System.out.println("Insira o id da máquina:");
        String id = leitor.nextLine();
        credenciais.setId(id);
        System.out.println("Insira a senha:");
        String senha = leitor.nextLine();
        credenciais.setSenha(senha);
        if (credenciais.selectLogin(id, senha)) {
            captura.mostrarInfoSistema();
            comp.inserirComponente();
            if (comp.consultarConfig(id) < 3) {
                comp.inserirConfiguracao(id);
            }
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    //Data 
                    Date dataHoraAtual = new Date();
                    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
                    String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
//                    captura.mostrar();
//                    comp.mostrar();
                    captura.inserirNoBanco(id, senha, data, hora);
                    captura.inserirNoBancoMySQL(id, senha, data, hora);
                }
            }, 0, 10000);

        } else {
            System.out.println("Credenciais Incorretas.");
        }
    }
}
