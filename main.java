import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import oracle.spatial.geometry.JGeometry; 

public class main {
	
	public final static void main(String[] args) {
		dbc dbcon = new dbc();
		dbcon.connect(); 
		dbcon.getData(); 
		List<JGeometry> lst = dbcon.getJList();
	
		JPanel panel = new GraphWindow(dbcon);
		JFrame frame = new JFrame("JavaGeometry");
		frame.setContentPane(panel);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}

}