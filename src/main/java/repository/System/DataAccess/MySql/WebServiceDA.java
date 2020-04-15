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
import java.util.stream.Collectors;

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
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Price;
import domain.System.BusinessEntity.Base.Producto;
import domain.System.BusinessEntity.Base.Stock;
import infrastructure.System.Adapters.EntityDBConnection;
import infrastructure.System.Adapters.MySqlAdapter;

public class WebServiceDA {

	public static ModelEntities listaProductos() {
		ModelEntities lstProducto = new ModelEntities();
		List<Producto> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "select  pro.IdProducto,pro.Nombre,pro.Descripcion from  gamachicas.producto pro;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql)
						// .addParameter("idimagen", 1)
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

	public static ModelEntities GetStokByIDImagen(int IdImagen) {
		ModelEntities lstProducto = new ModelEntities();
		List<Producto> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "select  pro.IdProducto,pro.Nombre,pro.Descripcion from  gamachicas.producto pro;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql)
						// .addParameter("idimagen", 1)
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

	public List<ViewStockBE> listGeneralProductForm(int IdImagen) throws IOException, SQLException {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		List<ViewStockBE> lst = new ArrayList<ViewStockBE>();
		String getDBUSERCursorSql = "{CALL sp_GetAllStockByIdImgen(?)}";

		try {
			dbConnection = MySqlAdapter.connectDatabase();
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setInt(1, IdImagen);
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Imagen imagen = new Imagen();
				Producto product = new Producto();
				Stock stock = new Stock();
				Price price = new Price();
				ViewStockBE ViewStockBE = new ViewStockBE();
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

	public static List<Stock> InsertStock(Stock stock) {
		int idStock = 0;
		List<Stock> result = new ArrayList<Stock>();
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
			callableStatement.setInt(3, stock.getIdProducto());
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
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT idstock,\r\n" + "    count,\r\n" + "    description,\r\n" + "    createdate,\r\n"
					+ "    updatedate,\r\n" + "    status,\r\n" + "    IdProducto,\r\n" + "    IdPedido,\r\n"
					+ "    idprecio\r\n" + "FROM gamachicas.stock where idstock=:idStock";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("idStock", idStock).executeAndFetch(Stock.class);
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static List<Producto> ListProduct() {
		List<Producto> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT IdProducto,\r\n" + "    Nombre,\r\n" + "    Descripcion,\r\n" + "    idclothing,\r\n"
					+ "    idstock\r\n" + "FROM gamachicas.producto;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql)
						// .addParameter("idimagen", 1)
						.executeAndFetch(Producto.class);
			}

			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static List<HomeViewModel> ListImagenByIdProduct(Producto pro) {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		List<HomeViewModel> lsthome = new ArrayList<HomeViewModel>();
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
				Imagen Imagen = new Imagen();
				Producto Producto = new Producto();
				Price Price = new Price();
				HomeViewModel home = new HomeViewModel();
				Producto.setNombre(resultSet.getString("NombreProducto"));
				Producto.setIdProducto(resultSet.getInt("IdProducto"));
				Price.setPreciomayor(resultSet.getDouble("preciomayor"));
				Price.setPreciomenor(resultSet.getDouble("preciomenor"));
				Imagen.setDescription(resultSet.getString("DESCRIPTION"));
				Imagen.setCountViews(resultSet.getInt("countViews"));
				Imagen.setIdimagen(resultSet.getInt("idimagen"));
				home.setImagen(Imagen);
				home.setPrice(Price);
				home.setProducto(Producto);
				lsthome.add(home);
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
		return lsthome;
	}

	public static List<HomeViewModel> ListDetImagenByIdProduct(Producto pro) {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		List<HomeViewModel> lsthome = new ArrayList<HomeViewModel>();
		String getDBUSERCursorSql = "{CALL sp_ListDetImagenByIdProduct(?)}";

		try {
			try {
				dbConnection = MySqlAdapter.connectDatabase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setInt(1, pro.getIdProducto());
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Imagen Imagen = new Imagen();
				Producto Producto = new Producto();
				Price Price = new Price();
				Detailimagen Detailimagen = new Detailimagen();
				HomeViewModel home = new HomeViewModel();
				Producto.setNombre(resultSet.getString("NombreProducto"));
				Producto.setIdProducto(resultSet.getInt("IdProducto"));
				Price.setPreciomayor(resultSet.getDouble("preciomayor"));
				Price.setPreciomenor(resultSet.getDouble("preciomenor"));
				Imagen.setDescription(resultSet.getString("DESCRIPTION"));
				Imagen.setCountViews(resultSet.getInt("countViews"));
				Imagen.setIdimagen(resultSet.getInt("idimagen"));
				Detailimagen.setIdDetailImagen(resultSet.getInt("IdDetailImagen"));
				home.setDetailimagen(Detailimagen);
				home.setImagen(Imagen);
				home.setPrice(Price);
				home.setProducto(Producto);

				lsthome.add(home);
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
		return lsthome;
	}

	public static Imagen ImagenSel(Imagen img) {

		List<Imagen> result = null;
		Imagen imgc = new Imagen();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT \r\n" + "	 idimagen,\r\n" + "    name,\r\n" + "    idclothing,\r\n"
					+ "    idposition,\r\n" + "    positionweb,\r\n" + "    countViews,\r\n" + "    imagendata,\r\n"
					+ "    url,\r\n" + "    DESCRIPTION,\r\n" + "    STATUS,\r\n" + "    createdate,\r\n"
					+ "    updatedate,\r\n" + "    idclothingline\r\n" + "FROM imagen  where  idimagen  = :idimagen;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("idimagen", img.getIdimagen()).executeAndFetch(Imagen.class);
			}

			if (result.size() > 0) {
				imgc = result.iterator().next();
			}

			return imgc;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgc;
	}

	public static Producto ProductoSel(Producto pro) {

		List<Producto> result = null;
		Producto pr = new Producto();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "\r\n" + " SELECT producto.IdProducto,\r\n" + "    producto.Nombre,\r\n"
					+ "    producto.Descripcion,\r\n" + "    producto.Idimagen,\r\n" + "    producto.idclothing,\r\n"
					+ "    producto.idstock\r\n" + "FROM gamachicas.producto where  IdProducto  = :IdProducto;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("IdProducto", pro.getIdProducto())
						.executeAndFetch(Producto.class);
			}
			if (result.size() > 0) {
				pr = result.iterator().next();
			}

			return pr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}

	public static List<HomeViewModel> ListDetImagenByIdImagen(Imagen img) {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		List<HomeViewModel> lsthome = new ArrayList<HomeViewModel>();
		String getDBUSERCursorSql = "{CALL sp_ListDetImagenByIdImagen(?)}";

		try {
			try {
				dbConnection = MySqlAdapter.connectDatabase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setInt(1, img.getIdimagen());
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Imagen Imagen = new Imagen();
				Producto Producto = new Producto();
				Price Price = new Price();
				Detailimagen Detailimagen = new Detailimagen();

				HomeViewModel home = new HomeViewModel();

				Producto.setNombre(resultSet.getString("NombreProducto"));
				Producto.setIdProducto(resultSet.getInt("IdProducto"));
				Price.setPreciomayor(resultSet.getDouble("preciomayor"));
				Price.setPreciomenor(resultSet.getDouble("preciomenor"));
				Imagen.setDescription(resultSet.getString("DESCRIPTION"));
				Imagen.setCountViews(resultSet.getInt("countViews"));
				Imagen.setIdimagen(resultSet.getInt("idimagen"));
				Detailimagen.setIdDetailImagen(resultSet.getInt("IdDetailImagen"));
				home.setDetailimagen(Detailimagen);
				home.setImagen(Imagen);
				home.setPrice(Price);
				home.setProducto(Producto);

				lsthome.add(home);
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
		return lsthome;
	}

	public static HomeViewModel HomeViewModelSelByIdDroducto(Producto pro) {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		HomeViewModel home = new HomeViewModel();
		String getDBUSERCursorSql = "{CALL sp_HomeViewModelSelByIdDroducto(?)}";

		try {
			try {
				dbConnection = MySqlAdapter.connectDatabase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setInt(1, pro.getIdProducto());
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Producto Producto = new Producto();
				Price Price = new Price();
				Imagen Imgen = new Imagen();
				Producto.setNombre(resultSet.getString("Nombre"));
				Producto.setIdProducto(resultSet.getInt("IdProducto"));
				Producto.setDescripcion(resultSet.getString("Descripcion"));
				Price.setPreciomayor(resultSet.getDouble("preciomayor"));
				Price.setPreciomenor(resultSet.getDouble("preciomenor"));
				Imgen.setIdimagen(resultSet.getInt("idimagen"));
				Imgen.setUrl(resultSet.getString("url"));
				home.setPrice(Price);
				home.setProducto(Producto);

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
		return home;
	}

	public static boolean DetailProductIns(Detailproduct pro) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.detailproduct\r\n" + "(IdDetailProduct,\r\n" + "IdProducto,\r\n"
					+ "TIPO,\r\n" + "Description,\r\n" + "updatedate,\r\n" + "createdate)\r\n" + "VALUES\r\n" + "(\r\n"
					+ ":IdDetailProduct ,\r\n" + ":IdProducto ,\r\n" + ":TIPO ,\r\n" + ":Description ,\r\n"
					+ ":updatedate ,\r\n" + ":createdate);";
			try (org.sql2o.Connection con = sql2o.open()) {
				con.createQuery(sql, true).addParameter("IdDetailProduct", pro.getIdDetailProduct())
						.addParameter("IdProducto", pro.getIdProducto()).addParameter("TIPO", pro.getTipo())
						.addParameter("Description", pro.getDescription())
						.addParameter("createdate", LocalDateTime.now()).addParameter("updatedate", LocalDateTime.now())
						.executeUpdate().getKey();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static List<Detailproduct> ListDetailProductByIdProduct(Detailproduct pro) {
		List<Detailproduct> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "\r\n" + "SELECT detailproduct.IdDetailProduct,\r\n" + ""
					+ "detailproduct.IdProducto,\r\n"
					+ "detailproduct.TIPO,\r\n" 
					+ "detailproduct.Description,\r\n"
					+ "detailproduct.updatedate,\r\n" 
					+ "detailproduct.createdate\r\n"
					+ "FROM gamachicas.detailproduct where IdProducto=:IdProducto;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("IdProducto", pro.getIdProducto())
						.executeAndFetch(Detailproduct.class);
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
