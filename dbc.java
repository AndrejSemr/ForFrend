import java.sql.*; 
import java.util.ArrayList; 
import java.util.List; 
import oracle.core.lmx.CoreException; 
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT; 

public class dbc {
	
	public dbc() { }
	
	public void connect() { 
		String URL = "jdbc:oracle:thin:@localhost:1521:orcl"; 
		String USER = "admins"; 
		String PASS = "admins"; 
		try 
		{ 
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
	
	@SuppressWarnings("deprecation") 
	public void getData() {
		for (int i = 0; i < tblArray.length; i++) {
			try { 
				Statement stmt = conn.createStatement();
				String sql = "SELECT "+ tblArrayIn[i] +" geom FROM "+ tblArray[i] + " a"; 
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					oracle.sql.STRUCT st = (STRUCT) rs.getObject("geom");
					JGeometry geom = JGeometry.load(st); 
					result.add(geom); 
				} 
			} catch (SQLException e) {
				e.printStackTrace(); 
			} 
		} 
	}
	
	public List<JGeometry> getJList(){
		return result; 
	}
	
	private Connection conn; 
	
	private List<JGeometry> result = new ArrayList<JGeometry>(0); 
	private String[] tblArray = {
			"trees",
			"roads",
			"houses"
	};
	private String[] tblArrayIn = {
			"tree_geo",
			"road_geo",
			"house_geo"
	};
	
	
}