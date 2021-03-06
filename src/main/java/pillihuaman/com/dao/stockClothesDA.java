 package pillihuaman.com.dao;
import pillihuaman.com.Adapters.EntityDBConnection;
import pillihuaman.com.Adapters.MySqlAdapter;
import pillihuaman.com.BusinessEntity.ViewStockBE;
import pillihuaman.com.BusinessEntity.Base.Clothing;
import pillihuaman.com.BusinessEntity.Base.Clothingline;
import pillihuaman.com.BusinessEntity.Base.Imagen;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sql2o.Sql2o;


public class stockClothesDA {
    public  static List<Clothingline> ListClothesLine() 
    {
    	 List<Clothingline> result=null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="select idclothingline,NAME,DESCRIPTION from Gamachicas.clothingline where STATUS !=0;";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	              result = con
	        	            .createQuery(sql)
	        	            //.addParameter("idclothing", 1)
	        	            .executeAndFetch(Clothingline.class);
	          }
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    } 
    public  static List<Imagen> ListClothes() 
    {
    	 List<Imagen> result=null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="select idimagen,name from Gamachicas.imagen where STATUS !=0;";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	              result = con
	        	            .createQuery(sql)
	        	            //.addParameter("idclothing", 1)
	        	            .executeAndFetch(Imagen.class);
	          }
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    } 
    public  static List<Imagen> list() 
    {
    	 List<Imagen> result= null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="select * from Gamachicas.imagen  where  idclothing=:idclothing";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	     result = con
	        	            .createQuery(sql)
	        	            .addParameter("idclothing", 1)
	        	            .executeAndFetch(Imagen.class);
	        	   // result.forEach(Systems.out::println);
	          }
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    } 
    public static   List<ViewStockBE>  getViewStock( ViewStockBE objs)
				throws SQLException, IOException {
			Connection dbConnection = null;
			CallableStatement callableStatement = null;
			ResultSet rs = null;
	            List<ViewStockBE> lst =new ArrayList<ViewStockBE>();
			String getDBUSERCursorSql = "{CALL SelectMenuParent()}";

			try {
				dbConnection = MySqlAdapter.connectDatabase();
			 	callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			  callableStatement.execute();
					   ResultSet resultSet = callableStatement.getResultSet();
	                while (resultSet.next()) {
	                	  String name = resultSet.getString("name");
		                    String path = resultSet.getString("path");
	                    System.out.println(
	                            "| " + name + " | " + path );
	                }
	                resultSet.close();
	 

			} catch (SQLException e) {

				System.out.println(e.getMessage());

			} finally {

				if (rs != null) {
					rs.close();
				}

				if (callableStatement != null) {
					callableStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}

			}
	 return lst;
		}
}
