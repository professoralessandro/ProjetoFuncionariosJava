import java.awt.*;
import java.awt.Container;


public class Tp03b{
    public static void main(String args[])
    {

	FormTp03b f = new FormTp03b("TP03 B", 500, 250, 20, 20);
	
	f.setVisible(true);
	f.addWindowListener(new FechaJanela());
    }
}