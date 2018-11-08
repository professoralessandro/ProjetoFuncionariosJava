import java.sql.*;
    public class Conexao { public static void main(String args[])
    {
        try
        {
            String url = "jdbc:sqlserver://localhost;databaseName=AulaJava;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con;
            con = DriverManager.getConnection(url);
            System.out.println ("Conexao OK");
            //dados da conexao
            DatabaseMetaData db = con.getMetaData();
            System.out.println("Conectado a "+db.getURL());
            System.out.println("Conexao     "+db.getConnection());
            System.out.println("Driver      "+db.getDriverName());
            System.out.println("Usuario     "+db.getUserName());
            System.out.println("----------------------------------");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}