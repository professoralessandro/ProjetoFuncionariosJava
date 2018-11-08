import java.sql.*;
public class ListaTabela
{
    public static void main (String args[])
    {
        try
        {
            String url = "jdbc:sqlserver://localhost;databaseName=AulaJava;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con; con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            ResultSet rs;
            rs =  st.executeQuery("SELECT * FROM tbfuncs");
            //IMPLEMENT
            
            int i;
            ResultSetMetaData rsmd = rs.getMetaData();
            int numcols = rsmd.getColumnCount();
            System.out.println("Total de colunas: "+numcols);
            for(i=1;i<=numcols;i++)
            System.out.print(rsmd.getColumnLabel(i)+" , ");
            System.out.println("\n");
            while (rs.next())
            {
                for (i=1;i<=4;i++)
                {
                    System.out.print(rs.getString(i)+" - ");
                }
                System.out.print("\n");
            }//mostraRS
            
            //mostraRS(rs);
            con.close();
            
            //IMPLEMENT
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }//CATCH
        /*
        private static void mostraRS(ResultSet rs) throws SQLException
        {
            int i;
            ResultSetMetaData rsmd = rs.getMetaData();
            int numcols = rsmd.getColumnCount();
            System.out.println("Total de colunas: "+numcols);
            for(i=1;i<=numcols;i++)
            System.out.print(rsmd.getColumnLabel(i)+" , ");
            System.out.println("\n");
            while (rs.next())
            {
                for (i=1;i<=4;i++)
                {
                    System.out.print(rs.getString(i)+" - ");
                }
                System.out.print("\n");
            }//mostraRS
        }//*/
    }//MAIN
}//CLASS