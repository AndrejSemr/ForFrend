import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.Shape; 
import java.util.List; 
import javax.swing.JPanel; 
import oracle.spatial.geometry.JGeometry; 
import java.awt.geom.AffineTransform;

public class GraphWindow extends JPanel {

	private dbc dbcon; 
	private static final long serialVersionUID = 1L;
	
	public GraphWindow(dbc dbcon) { 
		this.dbcon = dbcon; 
	} 

	public void paintComponent(Graphics g) { 
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform tform = AffineTransform.getTranslateInstance( 0, 300);
		tform.scale(3, -3); List<JGeometry> lst = dbcon.getJList();
		
		for(int i=0; i<=lst.size()-1; i++){
			if(lst.get(i) != null){
				Shape a = lst.get(i).createShape(tform);
				g2.draw(a); 
				} 
			} 
		} 
}
