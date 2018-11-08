import java.sql.*;
public class ListaTabela2
{
    public static void main (String args[])
    {
        try
        {
            int contador = 3;
            String url = "jdbc:sqlserver://localhost;databaseName=AulaJava;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con; con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            ResultSet rs;
            rs =  st.executeQuery("SELECT * FROM tbfuncs where cod_func = "+contador+"");
            //IMPLEMENT
            /*
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
            */
            //mostraRS(rs);
            
            
            rs.next();
            System.out.println(rs.getString("nome_func"));
            System.out.println(rs.getString("sal_func"));
                //inTxt4.setText("Ale");
            int cargo = Integer.parseInt(rs.getString("cod_cargo"));
            if(cargo == 1)
            {
                System.out.println("Administrador");
            }
            else if(cargo == 2)
            {
                System.out.println("Presidente");
            }
            else if(cargo == 3)
            {
                System.out.println("Diretor");
            }
            else if(cargo == 4)
            {
                System.out.println("Supervisor");
            }
            else if(cargo == 5)
            {
                System.out.println("Encarregado");
            }
            else if(cargo == 6)
            {
                System.out.println("Operador");
            }
            
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