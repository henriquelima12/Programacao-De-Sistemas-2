package project;
import java.util.*;
import java.sql.*;

public class GerenciadorNomesDB implements GerenciadorNomes {
    
    private List<String> nomes = new ArrayList<String>();
    
    public List<String> obterNomes() throws Exception{
        String url = "jdbc:mysql://localhost:3306/gerencia_nomes";
        String user = "root";
        String pwd = "";
        System.out.println(url);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        System.out.println("Conectado");
        String readSql = "SELECT * FROM nomes";
        PreparedStatement readStm = conexao.prepareStatement(readSql);
        ResultSet resultSet = readStm.executeQuery();
        while(resultSet.next()){
            System.out.println("Nome: " +resultSet.getString("nome"));
        }
        conexao.close();
        System.out.println("Encerrado");
        return nomes;
    }
  
    public void adicionarNome(String nome) throws Exception{
        String url = "jdbc:mysql://localhost:3306/gerencia_nomes";
        String user = "root";
        String pwd = "";
        System.out.println(url);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        System.out.println("Conectado");
        String readSql = "INSERT INTO nomes VALUES(?)";
        PreparedStatement readStm = conexao.prepareStatement(readSql);
        readStm.setString(1, nome);
        int rows = readStm.executeUpdate();
        System.out.println("Linhas afetadas: " +rows);
        conexao.close();
    }
}
