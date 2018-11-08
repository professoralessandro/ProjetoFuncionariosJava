import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;


class FormTp03b extends JFrame implements ActionListener 
{
    //CRIA«√O DOS BOT’ES
    public JButton b1;// = new JButton("CliqueAqui");
    public JButton b2;
    public JButton b3;
	
    //CRIAÁ„o DOS LABELS
    public JLabel l1;
    public JLabel l2;
    public JLabel l3; 
    public JLabel l4;
	
    //CRIA«√O DOS TEXTBOX
    public JTextField inTxt1;
    public JTextField inTxt2;
    public JTextField inTxt3;
    public JTextField inTxt4;
        
    //INSTANCIA ESTATICA DE LIVRODEBIBLIOTECA E CRIA«√O DE UM OBJETO STATICO
    //private static LivroDeBiblioteca lvb = new LivroDeBiblioteca();

    //CONSTRUTOR DA CLASSE
    FormTp03b(String titulo, int largura , int altura, int colinic,int lininic)
    {
        //TITULO DA SUPERCLASSE
	super(titulo);
		
	//PEGAR ALTURA E LARGURA
	setSize(largura, altura);
		
	//LOCALIZA√á√ÉO DO LAYOUT
	setLocation(colinic, lininic);
	//setLayout(new FlowLayout());
		
	//CRIA√á√ÉO DO OBJETO LAYOUT
	setLayout(new BorderLayout());
		
	//COLOCANDO OS TEXTOS NOS BOTOES
	b1 = new JButton("Pesquisar");
	b2 = new JButton("Anterior");
	b3 = new JButton("PrÛximo");
		
	//INSERINDO OS TEXTOS
	l1 = new JLabel("Nome: ");
	l2 = new JLabel("Nome: ");
	l3 = new JLabel("Sal·rio: ");
	l4 = new JLabel("Cargo: ");
		
	//INFORMANDO A QUANTIDADE DE CARACTERES DO TEXTBOX
	inTxt1 = new JTextField("", 8);
	inTxt2 = new JTextField("", 8);
	inTxt3 = new JTextField("", 8);
	inTxt4 = new JTextField("", 8);
		
	//CRIANDO OUVINTES NOS BOT’ES DE EVENTOS NA PROPRIA CLASSE
	b1.addActionListener(this); 
	b2.addActionListener(this); 
	b3.addActionListener(this);
		
	//CRIANDO O JPAINEL NORTE
	JPanel painelNorte = new JPanel();
		
	//INFORMANDO O NUMERO DE LINHAS E COLUNAS (6 LINHAS POR 2 COLUNAS)
	painelNorte.setLayout(new GridLayout(1,1));
	//painelNorte.setLayout(new FlowLayout(FlowLayout.CENTER));
		
	//INFORMANDO A COR DO BACKGOUND VERDE
	//painelNorte.setBackground(Color.green);
		
	//ADICIONANDO TODOS OS ITENS NO PAINEL NORTE
	painelNorte.add(l1);
	painelNorte.add(inTxt1);
        painelNorte.add(b1);
        /*
	painelNorte.add(l2);
	painelNorte.add(inTxt2);
	painelNorte.add(l3);
	painelNorte.add(inTxt3);
	painelNorte.add(l4);
	painelNorte.add(inTxt4);
		*/
	//inTxt.setBackground(Color.white);
		
	//CRIANDO O PAINEL DO CENTRO
	JPanel painelCentro = new JPanel();
		
	//INFORMANDO O NUMERO DE LINHAS E COLUNAS (6 LINHAS POR 2 COLUNAS) CENTRO
	//painelCentro.setLayout(new FlowLayout(FlowLayout.CENTER));
	//painelCentro.setBackground(Color.yellow);
		
	//painelCentro.add(l2);
	//CRIANDO O PAINEL DO SUL
	JPanel painelSul = new JPanel();
		
	//INFORMANDO O NUMERO DE LINHAS E COLUNAS (1 LINHAS POR 5 COLUNAS)
	painelSul.setLayout(new GridLayout(4,2));
	//painelSul.setBackground(Color.green);
		
	//ADICIONANDO OS BOTOES
        
        painelSul.add(l2);
	painelSul.add(inTxt2);
	painelSul.add(l3);
	painelSul.add(inTxt3);
	painelSul.add(l4);
	painelSul.add(inTxt4);
	//painelSul.add(b1);
	painelSul.add(b2);
	painelSul.add(b3);
		
	//this.setLayout(new BorderLayout());
	this.add("Center", painelNorte);
	//this.add("Center", painelCentro);
	this.add("South", painelSul);
    }//CONSTRUTUR DA CLASSE
    static int contador = 0;
    //CONTADOR
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()==b1) 
	{
            boolean a = false;
            
            try
            {
                String nome = inTxt1.getText();
                String url = "jdbc:sqlserver://localhost;databaseName=AulaJava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con;
                con = DriverManager.getConnection(url);
                Statement st = con.createStatement();
                ResultSet rs;
                rs =  st.executeQuery("SELECT * FROM tbfuncs");
                while (rs.next())
                {
                    if(rs.getString("nome_func").equals(nome))
                    {
                        a = true;
                        inTxt2.setText(rs.getString("nome_func"));
                        inTxt3.setText(rs.getString("sal_func"));
                        //inTxt4.setText("Ale");
                        int cargo = Integer.parseInt(rs.getString("cod_cargo"));
                        int numeroAtual = Integer.parseInt(rs.getString("cod_func"));
                        contador = numeroAtual;
                        
                        if(cargo == 1)
                        {
                            inTxt4.setText("Administrador");
                        }
                        else if(cargo == 2)
                        {
                            inTxt4.setText("Presidente");
                        }
                        else if(cargo == 3)
                        {
                            inTxt4.setText("Diretor");
                        }
                        else if(cargo == 4)
                        {
                            inTxt4.setText("Supervisor");
                        }
                        else if(cargo == 5)
                        {
                            inTxt4.setText("Encarregado");
                        }
                        else if(cargo == 6)
                        {
                            inTxt4.setText("Operador");
                        }
                    }
                }//WHILE
                existe(a);
                a = false;
                //inTxt1.setText(rs.getString("nome_func"));
            }//TRY
            catch(Exception f)
            {
                JOptionPane.showMessageDialog(null,"Erro: " + f.toString());
            }//CATCH
	}//IF BOTAO 1
	else if (e.getSource()==b2) 
	{
            inTxt1.setText("");
            inTxt2.setText("");
            inTxt3.setText("");
            inTxt4.setText("");
            try
            {
                contador --;
                
                String nome = inTxt1.getText();
                String url = "jdbc:sqlserver://localhost;databaseName=AulaJava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con;
                con = DriverManager.getConnection(url);
                Statement st = con.createStatement();
                ResultSet rs;
                rs =  st.executeQuery("SELECT * FROM tbfuncs where cod_func = "+contador+"");
                rs.next();
                
                inTxt2.setText(rs.getString("nome_func"));
                inTxt3.setText(rs.getString("sal_func"));
                //inTxt4.setText("Ale");
                int cargo = Integer.parseInt(rs.getString("cod_cargo"));
                        
                        
                if(cargo == 1)
                {
                    inTxt4.setText("Administrador");
                }
                else if(cargo == 2)
                {
                    inTxt4.setText("Presidente");
                }
                else if(cargo == 3)
                {
                    inTxt4.setText("Diretor");
                }
                else if(cargo == 4)
                {
                    inTxt4.setText("Supervisor");
                }
                else if(cargo == 5)
                {
                    inTxt4.setText("Encarregado");
                }
                else if(cargo == 6)
                {
                    inTxt4.setText("Operador");
                }
                //inTxt1.setText(rs.getString("nome_func"));
            }//TRY
            catch(Exception f)
            {
                JOptionPane.showMessageDialog(null,"Erro: " + f.toString());
            }//CATCH
	}//ELSEIF BOTAO 2
        else if (e.getSource()==b3) 
	{
            inTxt1.setText("");
            inTxt2.setText("");
            inTxt3.setText("");
            inTxt4.setText("");
            try
            {
                contador ++;
                
                String nome = inTxt1.getText();
                String url = "jdbc:sqlserver://localhost;databaseName=AulaJava;integratedSecurity=true";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con;
                con = DriverManager.getConnection(url);
                Statement st = con.createStatement();
                ResultSet rs;
                rs =  st.executeQuery("SELECT * FROM tbfuncs where cod_func = "+contador+"");
                rs.next();
                
                inTxt2.setText(rs.getString("nome_func"));
                inTxt3.setText(rs.getString("sal_func"));
                //inTxt4.setText("Ale");
                int cargo = Integer.parseInt(rs.getString("cod_cargo"));
                        
                        
                if(cargo == 1)
                {
                    inTxt4.setText("Administrador");
                }
                else if(cargo == 2)
                {
                    inTxt4.setText("Presidente");
                }
                else if(cargo == 3)
                {
                    inTxt4.setText("Diretor");
                }
                else if(cargo == 4)
                {
                    inTxt4.setText("Supervisor");
                }
                else if(cargo == 5)
                {
                    inTxt4.setText("Encarregado");
                }
                else if(cargo == 6)
                {
                    inTxt4.setText("Operador");
                }
                //inTxt1.setText(rs.getString("nome_func"));
            }//TRY
            catch(Exception f)
            {
                JOptionPane.showMessageDialog(null,"Erro: " + f.toString());
            }//CATCH
        }//B3
    }//ACTIONPERFORMED
    public boolean existe(boolean b)
    {
        boolean a = false;
        if(b == false)
        {
            JOptionPane.showMessageDialog(null,"Erro: O usu·rio n„o existe na base de dados.");
        }
        b = a;
        return a;
    }
}//class