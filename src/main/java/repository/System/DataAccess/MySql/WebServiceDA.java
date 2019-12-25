package repository.System.DataAccess.MySql;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.codegen.TypeAnnotationCodeStream;
import org.sql2o.Sql2o;

import common.system.ViewModel.ListImagenByIdProductModelAndView;
import common.system.ViewModel.ModelEntities;
//import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;
import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewProductBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Price;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
import infrastructure.System.Adapters.EntityDBConnection;
import infrastructure.System.Adapters.MySqlAdapter;

public class WebServiceDA {

    public  static ModelEntities listaProductos()  
    {
    	ModelEntities lstProducto=  new ModelEntities();
    	List<Producto> result= null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="select  pro.IdProducto,pro.Nombre,pro.Descripcion from  gamachicas.producto pro;";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	     result =  con
	        	            .createQuery(sql)
	        	            //.addParameter("idimagen", 1)
	        	            .executeAndFetch(Producto.class);  
	          }
	          lstProducto.setListaProducto(result);
			return lstProducto;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return lstProducto;
    }
    
    public  static ModelEntities GetStokByIDImagen(int IdImagen )  
    {
    	ModelEntities lstProducto=  new ModelEntities();
    	List<Producto> result= null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
    	try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="select  pro.IdProducto,pro.Nombre,pro.Descripcion from  gamachicas.producto pro;";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	     result =  con
	        	            .createQuery(sql)
	        	            //.addParameter("idimagen", 1)
	        	            .executeAndFetch(Producto.class);  
	          }
	          lstProducto.setListaProducto(result);
			return lstProducto;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return lstProducto;
    }
	public  List<ViewStockBE> listGeneralProductForm(int IdImagen) throws IOException, SQLException {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
            List<ViewStockBE> lst =new ArrayList<ViewStockBE>();
		String getDBUSERCursorSql = "{CALL sp_GetAllStockByIdImgen(?)}";

		try {
			dbConnection = MySqlAdapter.connectDatabase();
		 	callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
		 	callableStatement.setInt(1, IdImagen); 
		  callableStatement.execute();
				   ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                	Imagen imagen = new Imagen();
                	Producto product= new Producto();
                	Stock stock = new Stock();
                	Price price= new Price();
                	ViewStockBE ViewStockBE= new ViewStockBE();
                	 imagen.setIdimagen(resultSet.getInt("idimagen"));
                	 imagen.setDescription(resultSet.getString("DESCRIPTION"));
                	 imagen.setName(resultSet.getString("name"));
                	 product.setIdProducto(resultSet.getInt("IdProducto"));
                	 product.setNombre(resultSet.getString("Nombre"));
                	 stock.setIdstock(resultSet.getInt("idstock"));
                	 price.setPreciomayor(resultSet.getDouble("preciomayor"));
                	 price.setPreciomenor(resultSet.getDouble("preciomenor"));
                	 ViewStockBE.setImagen(imagen);
                	 ViewStockBE.setProducto(product);
                	 ViewStockBE.setStock(stock);
                	 ViewStockBE.setPrice(price);
                	 lst.add(ViewStockBE);
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
	public static List<Stock> InsertStock(Stock stock)  {
		int idStock = 0;
		List<Stock> result= new ArrayList<Stock>();
		Connection dbConnection = null;
		CallableStatement callableStatement = null;


		String getDBUSERCursorSql = "{call sp_InsertStock (?,?,?,?,?)}";

		try {
			try {
				dbConnection = MySqlAdapter.connectDatabase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setBigDecimal(1, stock.getCount());
			callableStatement.setString(2, stock.getDescription());
			callableStatement.setInt(3,stock.getIdProducto());
			callableStatement.setInt(4, stock.getIdprecio());
			callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
			// callableStatement.executeUpdate();
			boolean hasresult = callableStatement.execute();
			 ResultSet rs = callableStatement.getGeneratedKeys();
			if (hasresult) {
			try (ResultSet myRs = callableStatement.getResultSet()) {
				while (myRs.next()) {
					idStock = myRs.getInt("idStock");

					System.out.print(idStock);
					} // end of while

				} // end of resultset
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		try {
			EntityDBConnection conne= MySqlAdapter.getConnectionString();
			 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
	          String sql ="SELECT idstock,\r\n" + 
	          		"    count,\r\n" + 
	          		"    description,\r\n" + 
	          		"    createdate,\r\n" + 
	          		"    updatedate,\r\n" + 
	          		"    status,\r\n" + 
	          		"    IdProducto,\r\n" + 
	          		"    IdPedido,\r\n" + 
	          		"    idprecio\r\n" + 
	          		"FROM gamachicas.stock where idstock=:idStock";
	          try (org.sql2o.Connection con =  sql2o.open()){
	        	     result =   con
	        	            .createQuery(sql)
	        	            .addParameter("idStock", idStock )
	        	            .executeAndFetch(Stock.class);  
	          }
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

    public  static List<Producto> ListProduct()  
	    {
	    	List<Producto> result= null;
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} 
	    	try {
				EntityDBConnection conne= MySqlAdapter.getConnectionString();
				 Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
		          String sql ="SELECT IdProducto,\r\n" + 
		          		"    Nombre,\r\n" + 
		          		"    Descripcion,\r\n" + 
		          		"    idclothing,\r\n" + 
		          		"    idstock\r\n" + 
		          		"FROM gamachicas.producto;";
		          try (org.sql2o.Connection con =  sql2o.open()){
		        	     result =  con
		        	            .createQuery(sql)
		        	            //.addParameter("idimagen", 1)
		        	            .executeAndFetch(Producto.class);  
		          }

				return result;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return result;
	    }
    public  static ListImagenByIdProductModelAndView ListImagenByIdProduct(Producto pro)   
    {
    	Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
          ListImagenByIdProductModelAndView lst =new ListImagenByIdProductModelAndView();
          List<HomeViewModel> lsthome =new ArrayList<HomeViewModel>();
		String getDBUSERCursorSql = "{CALL sp_ListImagenByIdProduct(?)}";

		try {
			try {
				dbConnection = MySqlAdapter.connectDatabase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
		 	callableStatement.setInt(1, pro.getIdimagen()); 
		  callableStatement.execute();
				   ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                	HomeViewModel home = new HomeViewModel();
                	home.setIdimagen(resultSet.getInt("idimagen"));
                	home.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                	home.setName(resultSet.getString("name"));
                	home.setIdProducto(resultSet.getInt("IdProducto"));
                	home.setNombreProducto(resultSet.getString("NombreProducto"));
                	home.setPreciomayor(resultSet.getDouble("preciomayor"));
                	home.setPreciomenor(resultSet.getDouble("preciomenor"));
                	home.setCountViews(resultSet.getInt("countViews"));
                	lsthome.add(home);
                	 lst.setListImagenByIdProduct(lsthome);
}
                resultSet.close();
 
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
 return lst;
    }
}
   