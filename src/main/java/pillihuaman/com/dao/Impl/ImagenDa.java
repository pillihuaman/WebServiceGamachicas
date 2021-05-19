package pillihuaman.com.dao.Impl;

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

import pillihuaman.com.Adapters.EntityDBConnection;
import pillihuaman.com.Adapters.MySqlAdapter;
import pillihuaman.com.BusinessEntity.CrudImagenBE;
import pillihuaman.com.BusinessEntity.ViewStockBE;
import pillihuaman.com.BusinessEntity.Base.Clothingline;
import pillihuaman.com.BusinessEntity.Base.Detailimagen;
import pillihuaman.com.BusinessEntity.Base.HomeViewModel;
import pillihuaman.com.BusinessEntity.Base.Imagen;
import pillihuaman.com.BusinessEntity.Base.Price;
import pillihuaman.com.BusinessEntity.Base.Product;
import pillihuaman.com.model.response.HomeViewModelResponse;
import pillihuaman.com.model.response.ImagenResponse;

public class ImagenDa {

	public static BigInteger registerImagen(CrudImagenBE CrudImagenBE) {
		BigInteger idImagen1 = null;
		int idImagen = 0;
		String valor = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO Gamachicas.imagen(name,idclothing,idposition,positionweb,countViews,imagendata,url,DESCRIPTION,STATUS,createdate,updatedate,idclothingline) "
					+ "VALUES(:name,:idclothing,:idposition,:positionweb,:countViews,:imagendata,:url,:DESCRIPTION,:STATUS,:createdate,:updatedate,:idclothingline)";
			try (org.sql2o.Connection con = sql2o.open()) {
//				idImagen1 = (BigInteger) con.createQuery(sql, true)
//						.addParameter("name", CrudImagenBE.getImagen().getName())
//						//.addParameter("idclothing", CrudImagenBE.getImagen().getIdclothing())
//						.addParameter("idposition", CrudImagenBE.getImagen().getIdposition())
//						.addParameter("positionweb", CrudImagenBE.getImagen().getPositionweb())
//						.addParameter("countViews", CrudImagenBE.getImagen().getCountViews())
//						.addParameter("imagendata", CrudImagenBE.getImagen().getImagendata())
//						.addParameter("url", "fsdfs")
//						.addParameter("DESCRIPTION", CrudImagenBE.getImagen().getDescription())
//						.addParameter("STATUS", true).addParameter("createdate", LocalDateTime.now())
//						.addParameter("updatedate", LocalDateTime.now())
//						.addParameter("idclothingline", CrudImagenBE.getImagen().getIdclothingline()).executeUpdate()
//						.getKey();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idImagen1;
	}

	public static int RegisterDetailImagen(ViewStockBE ViewStockBE) {

		int idImagen1 = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.detailimagen(idimagen,Descripcion,vista,imagendata,url,createdate,updatedate,status) "
					+ "VALUES(:idimagen,:Descripcion,:vista,:imagendata,:url,:createdate,:updatedate,:status);";
			try (org.sql2o.Connection con = sql2o.open()) {
				idImagen1 = (int) con.createQuery(sql, true)
//						.addParameter("idimagen", ViewStockBE.getDetailimagen().getIdimagen())
//						.addParameter("Descripcion", ViewStockBE.getDetailimagen().getDescripcion())
//						.addParameter("vista", ViewStockBE.getDetailimagen().getVista())
//						.addParameter("imagendata", ViewStockBE.getDetailimagen().getImagendata())
						.addParameter("url", "url test").addParameter("createdate", LocalDateTime.now())
						.addParameter("updatedate", LocalDateTime.now()).addParameter("status", true).executeUpdate()
						.getKey();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idImagen1;
	}

	public static int tesinsert(CrudImagenBE CrudImagenBE) {
		Integer idImagen = 0;
		int idImagen1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO Gamachicas.Test(idimagen) " + "VALUES(:idimagen)";
			try (org.sql2o.Connection con = sql2o.open()) {
				idImagen1 = (int) con.createQuery(sql, true)
						.addParameter("idimagen", CrudImagenBE.getTest().getIdimagen()).executeUpdate().getKey();
			}
			return idImagen;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idImagen;
	}

	public static List<Imagen> list() {
		List<Imagen> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "select  * from gamachicas.Imagen  order by positionweb desc limit 10;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql)
						// .addParameter("idimagen", 1)
						.executeAndFetch(Imagen.class);

			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static List<Imagen> getimg(int idimagen) {

		List<Imagen> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "select  * from gamachicas.Imagen  where idimagen= :idimagen;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("idimagen", idimagen).executeAndFetch(Imagen.class);

			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static List<Detailimagen> ListaDetalleImagenXID(int idimagen) {

		List<Detailimagen> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = " select  det.idimagen,det.IdDetailImagen,det.Descripcion  from gamachicas.detailimagen det where det.idimagen= :idimagen;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("idimagen", idimagen).executeAndFetch(Detailimagen.class);

			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static List<Detailimagen> lstIDdetalle(int iddetalleimagen) {

		List<Detailimagen> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "select * from gamachicas.detailimagen det where det.IdDetailImagen= :iddetalleimagen;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("iddetalleimagen", iddetalleimagen)
						.executeAndFetch(Detailimagen.class);

			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static int InsertImagen(CrudImagenBE CrudImagenBE) throws SQLException, IOException {
		int idimagen = 0;
		Connection dbConnection = null;
		CallableStatement callableStatement = null;

		List<CrudImagenBE> lst = new ArrayList<CrudImagenBE>();
		String getDBUSERCursorSql = "{call sp_InsertImagen (?,?,?,?,?,?,?,?,?,?)}";

		try {
			dbConnection = MySqlAdapter.connectDatabase();
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setString(1, CrudImagenBE.getImagen().getName());
//			callableStatement.setInt(2, CrudImagenBE.getImagen().getIdclothing());
//			callableStatement.setInt(3, CrudImagenBE.getImagen().getIdposition());
			callableStatement.setInt(4, CrudImagenBE.getImagen().getPositionWeb());
			callableStatement.setInt(5, CrudImagenBE.getImagen().getCountViews());
			callableStatement.setBytes(6, CrudImagenBE.getImagen().getImagendata());
			callableStatement.setString(7, CrudImagenBE.getImagen().getUrl());
			callableStatement.setString(8, CrudImagenBE.getImagen().getDescription());
//			callableStatement.setInt(9, CrudImagenBE.getImagen().getIdclothingline());
			callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
			// callableStatement.executeUpdate();
			boolean hasresult = callableStatement.execute();
			// ResultSet rs = callableStatement.getGeneratedKeys();
			if (hasresult) {
				try (ResultSet myRs = callableStatement.getResultSet()) {
					while (myRs.next()) {
						idimagen = myRs.getInt("idimagen");

						System.out.print(idimagen);
					} // end of while

				} // end of resultset
			}

			// ResultSet resultSet = callableStatement.getResultSet();
			// while (resultSet.next()) {
			// idimagen = resultSet.ge7tInt("idimagen");
			// String path = resultSet.getString("path");

			// }
			// resultSet.close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return idimagen;
	}

	public static int InsertDetalleImagen(ViewStockBE ViewStockBE) throws SQLException, IOException {
		int idimagen = 0;
		Connection dbConnection = null;
		CallableStatement callableStatement = null;

		List<CrudImagenBE> lst = new ArrayList<CrudImagenBE>();
		String getDBUSERCursorSql = "{call sp_InsertDetalleImagen (?,?,?,?,?)}";

		try {
			dbConnection = MySqlAdapter.connectDatabase();
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
//			callableStatement.setInt(1, ViewStockBE.getDetailimagen().getIdimagen());
//			callableStatement.setString(2, ViewStockBE.getDetailimagen().getDescripcion());
			callableStatement.setInt(3, ViewStockBE.getDetailimagen().getVista());
//			callableStatement.setBytes(4, ViewStockBE.getDetailimagen().getImagendata());
			// callableStatement.setInt(5, " ");
			// callableStatement.setBoolean(5, true);
			callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
			boolean hasresult = callableStatement.execute();
			// ResultSet rs = callableStatement.getGeneratedKeys();
			if (hasresult) {
				try (ResultSet myRs = callableStatement.getResultSet()) {
					while (myRs.next()) {
						idimagen = myRs.getInt("IdDetailImagen");

						System.out.print(idimagen);
					} // end of while

				} // end of resultset
			} // e

			// ResultSet resultSet = callableStatement.getResultSet();
			// while (resultSet.next()) {
			// idimagen = resultSet.ge7tInt("idimagen");
			// String path = resultSet.getString("path");

			// }
			// resultSet.close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return idimagen;
	}

	public static HomeViewModelResponse ListImagenByIdProduct(Product pro) {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		HomeViewModel home = new HomeViewModel();
		List<HomeViewModel> lsthome = new ArrayList<HomeViewModel>(); 
		HomeViewModelResponse lsthomeres = new HomeViewModelResponse();
		String getDBUSERCursorSql = "{CALL sp_ListImagenByIdProduct(?)}";
		try {
			try {
				dbConnection = MySqlAdapter.connectDatabase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setInt(1, pro.getIdProduct());
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Imagen Imagen = new Imagen();
				Product Producto = new Product();
				Producto.setName(resultSet.getString("ProductName"));
				Producto.setIdProduct(resultSet.getInt("idProduct"));
				Producto.setIdPrice(resultSet.getInt("IdPrice"));
//				Price.setHigherPrice(resultSet.getBigDecimal("HigherPrice"));
//				Price.setSmallerPrice(resultSet.getBigDecimal("SmallerPrice"));
				Imagen.setImagenCode(resultSet.getString("ImagenCode"));
				Imagen.setIdImagen(resultSet.getInt("idImagen"));
				home.setImagen(Imagen);
				home.setProducto(Producto);
				lsthome.add(home);
			}
			lsthomeres.setCode(200);
			lsthomeres.setDescription("Response OK");
			lsthomeres.setMessage("OK");
			lsthomeres.setHomeViewModel(home);
			//lsthomeres.setListHomeViewModel(lsthome);
			resultSet.close();

		} catch (SQLException e) {
			lsthomeres.setCode(500);
			lsthomeres.setDescription(e.getMessage());
			lsthomeres.setMessage("Error Inesperado");
			// lsthomeres.setHomeViewModel(lsthome);
			// Systems.out.println(e.getMessage());

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
		return lsthomeres;
	}
	public static HomeViewModelResponse ListImagenByTop(int count) {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		List<HomeViewModel> lsthome = new ArrayList<HomeViewModel>();

		HomeViewModelResponse lsthomeres = new HomeViewModelResponse();
		String getDBUSERCursorSql = "{CALL sp_ListImagenByTop(?)}";
		try {
			try {
				dbConnection = MySqlAdapter.connectDatabase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setInt(1,count );
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Imagen Imagen = new Imagen();
				Product Producto = new Product();
				Price Price = new Price();
				HomeViewModel home = new HomeViewModel();
				Producto.setName(resultSet.getString("name"));
				Producto.setIdProduct(resultSet.getInt("idProduct"));
				Price.setHigherPrice(resultSet.getBigDecimal("HigherPrice"));
				Price.setSmallerPrice(resultSet.getBigDecimal("SmallerPrice"));
				Imagen.setDescription(resultSet.getString("Description"));
				Imagen.setCountViews(resultSet.getInt("CountViews"));
				Imagen.setIdImagen(resultSet.getInt("idImagen"));
				home.setImagen(Imagen);
				home.setPrice(Price);
				home.setProducto(Producto);
				lsthome.add(home);
			}
			lsthomeres.setCode(200);
			lsthomeres.setDescription("Response OK");
			lsthomeres.setMessage("OK");
			lsthomeres.setListHomeViewModel(lsthome);
			resultSet.close();

		} catch (SQLException e) {
			lsthomeres.setCode(500);
			lsthomeres.setDescription(e.getMessage());
			lsthomeres.setMessage("Error Inesperado");
			// lsthomeres.setHomeViewModel(lsthome);
			// Systems.out.println(e.getMessage());

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
		return lsthomeres;
	}
	public static ImagenResponse ImagenIns(Imagen Imagen) {
		ImagenResponse imgResponse = new ImagenResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.imagen\r\n" + "(\r\n" + "IdProduct\r\n" + ",IdSystem\r\n"
					+ ",IdUser\r\n" + ",Name       \r\n" + ",PositionWeb\r\n" + ",CountViews \r\n" + ",imagendata \r\n"
					+ ",url        \r\n" + ",Description\r\n" + ",Status     \r\n" + ",ImagenCode \r\n"
					+ ",createdate \r\n" + ",updatedate)\r\n" + "VALUES(\r\n" + ":IdProduct \r\n" + ",:IdSystem \r\n"
					+ ",:IdUser \r\n" + ",:Name \r\n" + ",:PositionWeb \r\n" + ",:CountViews \r\n" + ",:imagendata \r\n"
					+ ",:url \r\n" + ",:Description \r\n" + ",:Status \r\n" + ",:ImagenCode \r\n" + ",:createdate \r\n"
					+ ",:updatedate);";
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("IdProduct", Imagen.getIdProduct())
						.addParameter("IdSystem", Imagen.getIdSystem()).addParameter("IdUser", Imagen.getIdUser())
						.addParameter("Name", Imagen.getName()).addParameter("PositionWeb", Imagen.getPositionWeb())
						.addParameter("CountViews", Imagen.getCountViews())
						.addParameter("imagendata", Imagen.getImagendata()).addParameter("url", Imagen.getUrl())
						.addParameter("Description", Imagen.getDescription()).addParameter("Status", Imagen.getStatus())
						.addParameter("ImagenCode", Imagen.getImagenCode())
						.addParameter("createdate", LocalDateTime.now()).addParameter("updatedate", LocalDateTime.now())
						.executeUpdate().getKey(int.class);
				Imagen.setIdImagen(key);
				if (key == 0) {
					con.rollback();
				}
			}
			imgResponse.setCode(200);
			imgResponse.setDescription("Response OK");
			imgResponse.setMessage("OK");
			imgResponse.setImagen(Imagen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			imgResponse.setCode(500);
			imgResponse.setDescription(e.getMessage());
			imgResponse.setMessage("Error Inesperado");
			imgResponse.setImagen(Imagen);
			return imgResponse;
		}
		return imgResponse;
	}
	public static ImagenResponse ImagenInss(Imagen Imagen) {
		ImagenResponse responseimg = new ImagenResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.imagen\r\n" + "(\r\n" + "IdProduct\r\n" + ",IdSystem\r\n"
					+ ",IdUser\r\n" + ",Name       \r\n" + ",PositionWeb\r\n" + ",CountViews \r\n" + ",imagendata \r\n"
					+ ",url        \r\n" + ",Description\r\n" + ",Status     \r\n" + ",ImagenCode \r\n"
					+ ",createdate \r\n" + ",updatedate)\r\n" + "VALUES(\r\n" + ":IdProduct \r\n" + ",:IdSystem \r\n"
					+ ",:IdUser \r\n" + ",:Name \r\n" + ",:PositionWeb \r\n" + ",:CountViews \r\n" + ",:imagendata \r\n"
					+ ",:url \r\n" + ",:Description \r\n" + ",:Status \r\n" + ",:ImagenCode \r\n" + ",:createdate \r\n"
					+ ",:updatedate);";
			responseimg.setFullpath("/WebServiceDA/ImagenInss");
			try (org.sql2o.Connection con = sql2o.open()) {
				con.createQuery(sql, true).addParameter("IdProduct", Imagen.getIdProduct())
						.addParameter("IdSystem", Imagen.getIdSystem()).addParameter("IdUser", Imagen.getIdUser())
						.addParameter("Name", Imagen.getName()).addParameter("PositionWeb", Imagen.getPositionWeb())
						.addParameter("CountViews", Imagen.getCountViews())
						.addParameter("imagendata", Imagen.getImagendata()).addParameter("url", Imagen.getUrl())
						.addParameter("Description", Imagen.getDescription()).addParameter("Status", Imagen.getStatus())
						.addParameter("ImagenCode", Imagen.getImagenCode())
						.addParameter("createdate", LocalDateTime.now()).addParameter("updatedate", LocalDateTime.now())
						.executeUpdate().getKey();
			}
			responseimg.setCode(200);
			responseimg.setDescription("Response OK");
			responseimg.setMessage("OK");
			responseimg.setImagen(Imagen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			responseimg.setCode(500);
			responseimg.setDescription(e.getMessage());
			responseimg.setMessage("Error Inesperado");
			responseimg.setImagen(Imagen);
			return responseimg;
		}
		return responseimg;
	}
}
	

