package project;
import java.sql.*;

public class AppRead {
    public static void main(String[] args) throws Exception {
        create(3, 10_000.00);
    }
    
    public static void read() throws Exception{
        String url = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String pwd = "";
        System.out.println(url);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        System.out.println("Conectado");
        String readSql = "SELECT * FROM contas";
        PreparedStatement readStm = conexao.prepareStatement(readSql);
        ResultSet resultSet = readStm.executeQuery();
        while(resultSet.next()){
            System.out.println("Numero da conta: " +resultSet.getLong("nro"));
        }
        conexao.close();
        System.out.println("Encerrado");
    }
    
    public static void create(long nro, double saldo) throws Exception{
        String url = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String pwd = "";
        System.out.println(url);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexao = DriverManager.getConnection(url, user, pwd);
        System.out.println("Conectado");
        String readSql = "INSERT INTO contas VALUES(?, ?)";
        PreparedStatement readStm = conexao.prepareStatement(readSql);
        readStm.setLong(1, nro);
        readStm.setDouble(2, saldo);
        int rows = readStm.executeUpdate();
        System.out.println("Linhas afetadas: " +rows);
        conexao.close();
        
    }
}
