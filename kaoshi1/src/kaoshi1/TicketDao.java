package kaoshi1;

import java.sql.*;
import java.util.*;

public class TicketDao {
	public static void main(String[] args) {
		TicketDao tdao=new TicketDao();
		Map<String,Object>map=new HashMap<>();
		tdao.insert(map);
		
	}
	
	public void insert(Map<String,Object>map){
		
	String url="jdbc:mysql://localhost:3306/test";
	String user="root";
	String pwd="a";
	Connection conn=null;
	try{ 
	conn =DriverManager.getConnection(url,user,pwd);
	String sql="insert into ticket values(null,?,?,?,?,?,?)";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setObject(1,map.get("TRAINNO"));
	ps.setObject(2,map.get("LEAVECITY"));
	ps.setObject(3,map.get("ARRIVECITY"));
	ps.setObject(4,map.get("LEAVETIME"));
	ps.setObject(5,map.get("SEATPRICE"));
	ps.setObject(6,map.get("BENDPRICE"));
	ps.executeUpdate();
	
	}catch(Exception e){
		throw new RuntimeException(e);
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
 }
public List<Map<String,Object>>query(String lcity,String acity,String ltime,String sprice,String bprice){
	String sql="select * from ticket where 1=1";
	List<Object> params=new ArrayList<Object>();
	if(lcity!=null && lcity.trim().isEmpty()==false){
		sql +=" and LEAVECITY = ?";
		params.add(lcity.trim());
	}
	if(acity!=null && acity.trim().isEmpty()==false){
		sql +=" and ARRIVECITY = ?";
		params.add(acity.trim());
	}
	if(ltime!=null && ltime.trim().isEmpty()==false){
		sql +=" and LEAVETIME = ?";
		params.add(ltime.trim());
	}
	if(sprice!=null && sprice.trim().isEmpty()==false){
		sql +=" and SEATPRICE = ?";
		params.add(sprice.trim());
	}
	if(bprice!=null && bprice.trim().isEmpty()==false){
		sql +=" and BENDPRICE = ?";
		params.add(bprice.trim());
	}

	String url="jdbc:mysql://localhost:3306/test";
	String user="root";
	String pwd="a";
	Connection conn=null;
	try{ 
	conn =DriverManager.getConnection(url,user,pwd);
	PreparedStatement ps=conn.prepareStatement(sql);
	for (int i = 0; i < params.size(); i++) {
		ps.setObject(i+1, params.get(i));
	}

	 ResultSet rs=ps.executeQuery();
	 List<Map<String,Object>> ret=new ArrayList<Map<String,Object>>();
	 while(rs.next()){
		 Map<String,Object> map= new HashMap<String,Object>();
		 map.put("TID", rs.getObject("TID"));
		 map.put("TRAINNO", rs.getObject("TRAINNO"));
		 map.put("LEAVECITY", rs.getObject("LEAVECITY"));
		 map.put("ARRIVECITY", rs.getObject("ARRIVECITY"));
		 map.put("LEAVETIME", rs.getObject("LEAVETIME"));
		 map.put("SEATPRICE", rs.getObject("SEATPRICE"));
		 map.put("BENDPRICE", rs.getObject("BENDPRICE"));
		 ret.add(map);
	 }
	return ret;
	}catch(Exception e){
		throw new RuntimeException(e);
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	
}
	
	
	
	
	
}
