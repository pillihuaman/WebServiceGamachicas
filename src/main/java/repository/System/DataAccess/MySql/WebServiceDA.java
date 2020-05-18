package repository.System.DataAccess.MySql;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import common.system.model.response.*;
import common.system.ViewModel.ModelEntities;
//import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.*;
import infrastructure.System.Adapters.EntityDBConnection;
import infrastructure.System.Adapters.MySqlAdapter;;

public class WebServiceDA {

	public static ModelEntities listaProductos() {
		ModelEntities lstProducto = new ModelEntities();
		List<Product> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT product.idProduct,\r\n" + " product.IdDetailProduct,\r\n" + " product.Name,\r\n"
					+ " product.IdType,\r\n" + " product.IdPrice,\r\n" + " product.IdSystem,\r\n"
					+ " product.IdUser,\r\n" + " product.IdImagen,\r\n" + " product.ExpirationDate,\r\n"
					+ " product.Status,\r\n" + " product.Description,\r\n" + " product.createDate,\r\n"
					+ " product.updatedate,\r\n" + " product.Stok_idStok\r\n" + "FROM gamachicas.product;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql)
						// .addParameter("idimagen", 1)
						.executeAndFetch(Product.class);
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
		List<Product> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT product.idProduct,\r\n" + " product.IdDetailProduct,\r\n" + " product.Name,\r\n"
					+ " product.IdType,\r\n" + " product.IdPrice,\r\n" + " product.IdSystem,\r\n"
					+ " product.IdUser,\r\n" + " product.IdImagen,\r\n" + " product.ExpirationDate,\r\n"
					+ " product.Status,\r\n" + " product.Description,\r\n" + " product.createDate,\r\n"
					+ " product.updatedate,\r\n" + " product.Stok_idStok\r\n" + "FROM gamachicas.product;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql)
						// .addParameter("idimagen", 1)
						.executeAndFetch(Product.class);
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
				Product product = new Product();
				Stock stock = new Stock();
				Price price = new Price();
				ViewStockBE ViewStockBE = new ViewStockBE();
				imagen.setIdImagen(resultSet.getInt("idimagen"));
				imagen.setDescription(resultSet.getString("DESCRIPTION"));
				imagen.setName(resultSet.getString("name"));
				product.setIdProduct(resultSet.getInt("IdProduct"));
				product.setName(resultSet.getString("Name"));
				// stock.setIdstock(resultSet.getInt("idstock"));
				price.setHigherPrice(resultSet.getBigDecimal("HigherPrice"));
				price.setSmallerPrice(resultSet.getBigDecimal("smallerPrice"));
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

	public static List<Product> ListProduct() {
		List<Product> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT product.idProduct,\r\n" + "product.Name,\r\n" + "product.IdType,\r\n"
					+ "product.IdPrice,\r\n" + "product.IdSystem,\r\n" + "product.IdUser,\r\n" + "product.IdImagen,\r\n"
					+ "product.ExpirationDate,\r\n" + "product.Status,\r\n" + "product.Description,\r\n"
					+ "product.createDate,\r\n" + "product.updatedate\r\n" + "FROM gamachicas.product;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql)
						// .addParameter("idimagen", 1)
						.executeAndFetch(Product.class);
			}

			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static HomeViewModelResponse ListImagenByIdProduct(Product pro) {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

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
				home.setProduct(Producto);
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

	public static List<HomeViewModel> ListDetImagenByIdProduct(Product pro) {
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
			callableStatement.setInt(1, pro.getIdProduct());
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Imagen Imagen = new Imagen();
				Product Producto = new Product();
				Price Price = new Price();
				Detailimagen Detailimagen = new Detailimagen();
				HomeViewModel home = new HomeViewModel();
				Producto.setName(resultSet.getString("NombreProducto"));
				Producto.setIdProduct(resultSet.getInt("IdProduct"));
				Price.setHigherPrice(resultSet.getBigDecimal("HigherPrice"));
				Price.setSmallerPrice(resultSet.getBigDecimal("smallerPrice"));
				Imagen.setDescription(resultSet.getString("DESCRIPTION"));
				Imagen.setCountViews(resultSet.getInt("countViews"));
				Imagen.setIdImagen(resultSet.getInt("idimagen"));
				Detailimagen.setIdDetailImagen(resultSet.getInt("IdDetailImagen"));
				home.setDetailimagen(Detailimagen);
				home.setImagen(Imagen);
				home.setPrice(Price);
				home.setProduct(Producto);

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

	public static ImagenResponse ImagenSel(Imagen img) {

		ImagenResponse responseimg = new ImagenResponse();
		List<Imagen> imgc = new ArrayList<Imagen>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT imagen.idImagen,\r\n" + "imagen.IdProduct,\r\n" + "imagen.IdSystem,\r\n"
					+ "imagen.IdUser,\r\n" + "imagen.Name,\r\n" + "imagen.PositionWeb,\r\n" + "imagen.CountViews,\r\n"
					+ "imagen.imagendata,\r\n" + "imagen.url,\r\n" + "imagen.Description,\r\n" + "imagen.Status,\r\n"
					+ "imagen.ImagenCode,\r\n" + "imagen.createdate,\r\n" + "imagen.updatedate\r\n"
					+ "FROM gamachicas.imagen where  idimagen  = :idimagen;";
			responseimg.setFullpath("/WebServiceDA/ImagenSel");
			try (org.sql2o.Connection con = sql2o.open()) {
				imgc = con.createQuery(sql).addParameter("idimagen", img.getIdImagen()).executeAndFetch(Imagen.class);
				responseimg.setCode(200);
				responseimg.setDescription("Response OK");
				responseimg.setMessage("OK");
				responseimg.setListImagen(imgc);
			}

//			if (imgc.size() > 0) {
//				imgc = imgc.iterator().next();
//			}

			return responseimg;
		} catch (Exception e) {
			responseimg.setCode(500);
			responseimg.setDescription(e.getMessage());
			responseimg.setMessage("Error");
			responseimg.setListImagen(imgc);
		}
		return responseimg;
	}

	public static ProductoResponse ProductoSel(Product pro) {
		ProductoResponse result = new ProductoResponse();
		List<Product> prod = new ArrayList<Product>();
		Product products = new Product();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT product.idProduct,\r\n" + "product.Name,\r\n" + "product.IdType,\r\n"
					+ "product.IdPrice,\r\n" + "product.IdSystem,\r\n" + "product.IdUser,\r\n" + "product.IdImagen,\r\n"
					+ "product.ExpirationDate,\r\n" + "product.Status,\r\n" + "product.Description,\r\n"
					+ "product.createDate,\r\n" + "product.updatedate\r\n"
					+ "FROM  gamachicas.product where idProduct = :idProduct;";
			result.setFullpath("/WebServiceDA/ProductoSel");
			try (org.sql2o.Connection con = sql2o.open()) {
				prod = con.createQuery(sql).addParameter("idProduct", pro.getIdProduct())
						.executeAndFetch(Product.class);
				result.setCode(200);
				result.setDescription("Response OK");
				result.setMessage("OK");
				result.setListProduct(prod);
				if (prod.size() > 0) {
					products = prod.iterator().next();
				}
				result.setProduct(products);
				return result;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result.setCode(500);
			result.setDescription(e.getMessage());
			result.setMessage("Error Inesperado");
			result.setProduct(pro);
			return result;
		}
	}

	public static List<HomeViewModel> ListDetImagenByIdImagen(Imagen img) {
		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		List<HomeViewModel> lsthome = new ArrayList<HomeViewModel>();
		String getDBUSERCursorSql = "{CALL sp_ListDetImagenByIdImagen(?)}";
		HomeViewModel homes = new HomeViewModel();
		try {
			try {
				dbConnection = MySqlAdapter.connectDatabase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
			callableStatement.setInt(1, img.getIdImagen());
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Imagen Imagen = new Imagen();
				Product Producto = new Product();
				Price Price = new Price();
				Detailimagen Detailimagen = new Detailimagen();
				HomeViewModel home = new HomeViewModel();
				Producto.setName(resultSet.getString("Name"));
				Producto.setIdProduct(resultSet.getInt("IdProducto"));
				Producto.setDescription(resultSet.getString("Description"));
				Price.setHigherPrice(resultSet.getBigDecimal("HigherPrice"));
				Price.setSmallerPrice(resultSet.getBigDecimal("SmallerPrice"));
				Imagen.setCountViews(resultSet.getInt("countViews"));
				Imagen.setCountViews(resultSet.getInt("PositionWeb"));
				Imagen.setIdImagen(resultSet.getInt("idimagen"));
				Detailimagen.setIdDetailImagen(resultSet.getInt("IdDetailImagen"));
				home.setDetailimagen(Detailimagen);
				home.setImagen(Imagen);
				home.setPrice(Price);
				home.setProduct(Producto);
				home.setCode(200);
				home.setDescription("Response OK");
				home.setMessage("OK");
				lsthome.add(home);

			}
			homes.setCode(200);
			homes.setDescription("Response OK");
			homes.setMessage("OK");
			lsthome.add(homes);
			resultSet.close();

		} catch (SQLException e) {
			HomeViewModel home = new HomeViewModel();
			home.setCode(200);
			home.setDescription(e.getMessage());
			home.setMessage("Error");
			lsthome.add(home);
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
		return lsthome;
	}

	public static HomeViewModel HomeViewModelSelByIdDroducto(Product pro) {
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
			callableStatement.setInt(1, pro.getIdProduct());
			callableStatement.execute();
			ResultSet resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				Product Producto = new Product();
				Price Price = new Price();
				Imagen Imgen = new Imagen();
				Producto.setName(resultSet.getString("Nombre"));
				Producto.setIdProduct(resultSet.getInt("IdProducto"));
				Producto.setDescription(resultSet.getString("Descripcion"));
				Price.setHigherPrice(resultSet.getBigDecimal("HigherPrice"));
				Price.setSmallerPrice(resultSet.getBigDecimal("smallerPrice"));
				Imgen.setIdImagen(resultSet.getInt("idimagen"));
				Imgen.setUrl(resultSet.getString("url"));
				home.setPrice(Price);
				home.setProduct(Producto);

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
			String sql = "\r\n" + "SELECT detailproduct.IdDetailProduct,\r\n" + "" + "detailproduct.IdProducto,\r\n"
					+ "detailproduct.TIPO,\r\n" + "detailproduct.Description,\r\n" + "detailproduct.updatedate,\r\n"
					+ "detailproduct.createdate\r\n" + "FROM gamachicas.detailproduct where IdProducto=:IdProducto;";
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

	public static List<Menu> MenuList(Groupparameter Groupparameter) {
		List<Menu> result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT menu.idmenu,\r\n" + "menu.idparentMenu,\r\n" + "menu.name,\r\n" + "menu.path,\r\n"
					+ "menu.createdate,\r\n" + "menu.updatedate,\r\n" + "menu.status\r\n" + "FROM gamachicas.menu";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("idmenu", Groupparameter.getIdGroupparameter())
						.executeAndFetch(Menu.class);
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static List<ParentMenu> ParentMenuList(ParentMenu ParentMenu) {
		List<ParentMenu> result = null;

		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT parentmenu.idparentMenu,\r\n" + "parentmenu.name,\r\n" + "parentmenu.path,\r\n"
					+ "parentmenu.createdate,\r\n" + "parentmenu.updatedate,\r\n" + "parentmenu.status\r\n"
					+ "FROM gamachicas.parentmenu;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("idparentMenu", ParentMenu.getIdparentMenu())
						.executeAndFetch(ParentMenu.class);
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static List<ParentMenu> parentmenuList(ParentMenu ParentMenu) {
		List<ParentMenu> result = null;

		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT parentmenu.idparentMenu,\r\n" + "parentmenu.name,\r\n" + "parentmenu.path,\r\n"
					+ "parentmenu.createdate,\r\n" + "parentmenu.updatedate,\r\n" + "parentmenu.status\r\n"
					+ "FROM gamachicas.parentmenu;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql)
//						.addParameter("idparentMenu",ParentMenu.getIdparentMenu())
						.executeAndFetch(ParentMenu.class);
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static List<Parameter> Parametersel(Parameter Parameter) {
		List<Parameter> result = null;

		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT idparameter,\r\n" + "NAME,\r\n" + "value,\r\n" + "STATUS,\r\n" + "createdate,\r\n"
					+ "updatedate,\r\n" + "idGroupparameter,\r\n" + "Description\r\n"
					+ "FROM gamachicas.parameter where   name = :name;";
			try (org.sql2o.Connection con = sql2o.open()) {
				result = con.createQuery(sql).addParameter("name", Parameter.getName())
						.executeAndFetch(Parameter.class);
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("null")
	public static ProductoResponse SaveProduct(Product pro) {
		ProductoResponse prores = new ProductoResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.product\r\n" + "(Name,\r\n" +
//					"IdType,\r\n" + 
//					"IdPrice,\r\n" + 
//					"IdSystem,\r\n" + 
//					"IdUser,\r\n" + 
//					"IdImagen,\r\n" + 
					"ExpirationDate,\r\n" + "Status,\r\n" + "Description,\r\n" + "createDate,\r\n" + "updatedate)\r\n"
					+ "VALUES\r\n" + "(:Name ,\r\n" +
//					":IdType ,\r\n" + 
//					":IdPrice ,\r\n" + 
//					":IdSystem ,\r\n" + 
//					":IdUser ,\r\n" + 
//					":IdImagen ,\r\n" + 
					":ExpirationDate ,\r\n" + ":Status ,\r\n" + ":Description ,\r\n" + ":createDate ,\r\n"
					+ ":updatedate );";
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true)
//	                    .addParameter("idProduct", 1)
						.addParameter("Name", pro.getName())
//						.addParameter("IdType", 0)
//						.addParameter("IdPrice", 0)
//						.addParameter("IdSystem", 0)
//						.addParameter("IdUser",0)
//						.addParameter("IdImagen", 0)
						.addParameter("ExpirationDate", pro.getExpirationDate()).addParameter("Status", 0)
						.addParameter("Description", pro.getDescription())
						.addParameter("createDate", LocalDateTime.now()).addParameter("updatedate", LocalDateTime.now())
						.executeUpdate().getKey(int.class);
				pro.setIdProduct(key);
				if (key == 0) {
					con.rollback();
				}
			}

			prores.setCode(200);
			prores.setDescription("Response OK");
			prores.setMessage("OK");
			prores.setProduct(pro);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			prores.setCode(500);
			prores.setDescription(e.getMessage());
			prores.setMessage("Error Inesperado");
			pro.setIdProduct((Integer) null);
			return prores;
		}
		return prores;
	}

	@SuppressWarnings("null")
	public static ProductoResponse ProductUpd(Product pro) {
		ProductoResponse prores = new ProductoResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "UPDATE gamachicas.product\r\n" + "SET\r\n" + "Name = :Name ,\r\n" + "IdType = :IdType ,\r\n"
					+ "IdPrice = :IdPrice ,\r\n" + "IdSystem = :IdSystem ,\r\n" + "IdUser = :IdUser ,\r\n"
					+ "IdImagen = :IdImagen ,\r\n" + "ExpirationDate = :ExpirationDate ,\r\n" + "Status = :Status ,\r\n"
					+ "Description = :Description ,\r\n" + "updatedate = :updatedate \r\n"
					+ "WHERE idProduct = :idProduct;";
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("idProduct", pro.getIdProduct())
						.addParameter("Name", pro.getName()).addParameter("IdType", pro.getIdType())
						.addParameter("IdPrice", pro.getIdPrice()).addParameter("IdSystem", pro.getIdSystem())
						.addParameter("IdUser", pro.getIdUser()).addParameter("IdImagen", pro.getIdImagen())
						.addParameter("ExpirationDate", pro.getExpirationDate()).addParameter("Status", pro.getStatus())
						.addParameter("Description", pro.getDescription())
						.addParameter("updatedate", LocalDateTime.now()).executeUpdate().getKey(int.class);
			}
			prores.setCode(200);
			prores.setDescription("Update OK");
			prores.setMessage("OK");
			prores.setProduct(pro);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			prores.setCode(500);
			prores.setDescription(e.getMessage());
			prores.setMessage("Error");
			pro.setIdProduct((Integer) null);
			return prores;
		}
		return prores;
	}

	@SuppressWarnings("null")
	public static ProductoResponse ProductDel(Product pro) throws SQLException {
		ProductoResponse prores = new ProductoResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "DELETE FROM gamachicas.product\r\n" + "WHERE idProduct= :idProduct";
			try (org.sql2o.Connection con = sql2o.open()) {
				con.createQuery(sql, true).addParameter("idProduct", pro.getIdProduct()).executeUpdate().getKey();
			}

			prores.setCode(200);
			prores.setDescription("Response OK");
			prores.setMessage("OK");
			prores.setProduct(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			prores.setCode(500);
			prores.setDescription(e.getMessage());
			prores.setMessage("Error Inesperado");
			pro.setIdProduct((Integer) null);
			return prores;
		}
		return prores;
	}

	public static boolean Stockins(Stock stock) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.stock\r\n" + "(Amount,\r\n" + "IdProduct,\r\n" + "IdSystem,\r\n"
					+ "IdUser,\r\n" + "IdUnit,\r\n" + "IDPlace,\r\n" + "Status,\r\n" + "CreateDate,\r\n"
					+ "UpdateDate)\r\n" + "VALUES\r\n" + "(:Amount ,\r\n" + ":IdProduct ,\r\n" + ":IdSystem ,\r\n"
					+ ":IdUser ,\r\n" + ":IdUnit ,\r\n" + ":IDPlace ,\r\n" + ":Status ,\r\n" + ":CreateDate ,\r\n"
					+ ":UpdateDate );";
			try (org.sql2o.Connection con = sql2o.open()) {
				con.createQuery(sql, true)
//	                    .addParameter("idProduct", 1)
						.addParameter("Amount", stock.getAmount()).addParameter("IdProduct", stock.getIdProduct())
						.addParameter("IdSystem", stock.getIdSystem()).addParameter("IdUser", stock.getIdUser())
						.addParameter("IdUnit", stock.getIdUnit()).addParameter("IDPlace", stock.getIDPlace())
						.addParameter("Status", 1).addParameter("CreateDate", LocalDateTime.now())
						.addParameter("UpdateDate", LocalDateTime.now()).executeUpdate().getKey();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
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

	public static DetailImagenResponse DetailImagenIns(Detailimagen detailImagen) {
		DetailImagenResponse detail = new DetailImagenResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.detailimagen\r\n" + "(IdImagen,\r\n" + "Vista,\r\n" + "url,\r\n"
					+ "Status,\r\n" + "CreateDate,\r\n" + "UpdateDate)\r\n" + "VALUES\r\n" + "(:IdImagen,\r\n"
					+ ":Vista,\r\n" + ":url,\r\n" + ":Status,\r\n" + ":CreateDate,\r\n" + ":UpdateDate);";
			detail.setFullpath("/WebServiceDA/DetailImagenIns");
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("IdImagen", detailImagen.getIdImagen())
						.addParameter("Vista", detailImagen.getVista()).addParameter("url", detailImagen.getUrl())
						.addParameter("Status", detailImagen.getStatus())
						.addParameter("UpdateDate", LocalDateTime.now()).addParameter("CreateDate", LocalDateTime.now())
						.executeUpdate().getKey(int.class);
				detailImagen.setIdDetailImagen(key);
				if (key == 0) {
					con.rollback();
				}
			}
			detail.setCode(200);
			detail.setDescription("Response OK");
			detail.setMessage("OK");
			detail.setDetailImagen(detailImagen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setDetailImagen(detailImagen);
			return detail;
		}
		return detail;
	}

	public static CustomersResponse CustomerIns(Customers customers) {
		CustomersResponse detail = new CustomersResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.customer\r\n" + "(Name,\r\n" + "FirstName,\r\n" + "SecondName,\r\n"
					+ "IdPosition,\r\n" + "address,\r\n" + "Ubigeo,\r\n" + "UrlSocialMedia,\r\n" + "MobilPhone,\r\n"
					+ "Email,\r\n" + "Status,\r\n" + "CreateDate,\r\n" + "UpdateDate)\r\n" + "VALUES\r\n"
					+ "(:Name ,\r\n" + ":FirstName ,\r\n" + ":SecondName ,\r\n" + ":IdPosition ,\r\n" + ":address ,\r\n"
					+ ":Ubigeo ,\r\n" + ":UrlSocialMedia ,\r\n" + ":MobilPhone ,\r\n" + ":Email ,\r\n" + ":Status ,\r\n"
					+ ":CreateDate ,\r\n" + "UpdateDate);\r\n" + "";
			detail.setFullpath("/WebServiceDA/CustomerIns");
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("Name", customers.getName())
						.addParameter("FirstName", customers.getFirstName())
						.addParameter("SecondName", customers.getSecondName())
						.addParameter("IdPosition", customers.getIdPosition())
						.addParameter("address", customers.getAddress()).addParameter("Ubigeo", customers.getUbigeo())
						.addParameter("UrlSocialMedia", customers.getUrlSocialMedia())
						.addParameter("MobilPhone", customers.getMobilPhone()).addParameter("Email", customers.getEmail())
						.addParameter("Status", customers.getStatus()).addParameter("CreateDate", LocalDateTime.now())
						.addParameter("UpdateDate", LocalDateTime.now()).executeUpdate().getKey(int.class);
				customers.setIdCustomer(key);
				if (key == 0) {
					con.rollback();
				}
			}
			detail.setCode(200);
			detail.setDescription("Response OK");
			detail.setMessage("OK");
			detail.setCustomers(customers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setCustomers(customers);
			return detail;
		}
		return detail;
	}

	public static UsersResponse SystemIns(Users users) {
		UsersResponse detail = new UsersResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.systems\r\n" + "(Name,\r\n" + "URL,\r\n" + "Status,\r\n"
					+ "IdCompany,\r\n" + "Idmenu,\r\n" + "CreateDate,\r\n" + "UpdateDate)\r\n" + "VALUES\r\n"
					+ "(:Name ,\r\n" + ":URL ,\r\n" + ":Status ,\r\n" + ":IdCompany ,\r\n" + ":Idmenu ,\r\n"
					+ ":CreateDate ,\r\n" + ":UpdateDate );\r\n" + "";
			detail.setFullpath("/WebServiceDA/SystemIns");
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true)
//						.addParameter("FullName", users.getFullName())
						.addParameter("Alias", users.getAlias()).addParameter("IdRol", users.getIdRol())
						.addParameter("Mail", users.getMail()).addParameter("MobilPhone", users.getMobilPhone())
						.addParameter("Mail", users.getMail()).addParameter("Status", users.getStatus())
						.addParameter("CreateDate", LocalDateTime.now()).addParameter("UpdateDate", LocalDateTime.now())
						.executeUpdate().getKey(int.class);
				users.setIdUser(key);
				if (key == 0) {
					con.rollback();
				}
			}
			detail.setCode(200);
			detail.setDescription("Response OK");
			detail.setMessage("OK");
			detail.setUsers(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setUsers(users);
			return detail;
		}
		return detail;
	}

	public static UsersResponse SystemUpd(Users users) {
		UsersResponse detail = new UsersResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "UPDATE gamachicas.systems\r\n" + "SET\r\n" + "Name = :Name,\r\n" + "URL = :URL,\r\n"
					+ "Status = :Status,\r\n" + "IdCompany = :IdCompany,\r\n" + "Idmenu = :Idmenu,\r\n"
					+ "UpdateDate = :UpdateDate\r\n" + "WHERE idSystem = :idSystem ;\r\n";
			detail.setFullpath("/WebServiceDA/SystemUpd");
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("IdSystem", users.getIdSystem())
//						.addParameter("FullName", users.getFullName())
						.addParameter("Alias", users.getAlias())
						.addParameter("IdRol", users.getIdRol()).addParameter("Mail", users.getMail())
						.addParameter("MobilPhone", users.getMobilPhone()).addParameter("Mail", users.getMail())
						.addParameter("Status", users.getStatus()).addParameter("UpdateDate", LocalDateTime.now())
						.executeUpdate().getKey(int.class);
				users.setIdUser(key);
				if (key == 0) {
					con.rollback();
				}
			}
			detail.setCode(200);
			detail.setDescription("Response OK");
			detail.setMessage("OK");
			detail.setUsers(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setUsers(users);
			return detail;
		}
		return detail;
	}

	public static UsersResponse SystemDel(Users users) {
		UsersResponse detail = new UsersResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "DELETE FROM gamachicas.systems\r\n" + "WHERE idSystem =:idSystem\r\n";
			try (org.sql2o.Connection con = sql2o.open()) {
				con.createQuery(sql, true).addParameter("IdSystem", users.getIdSystem()).executeUpdate()
						.getKey(int.class);

			}
			detail.setCode(200);
			detail.setDescription("Delete OK");
			detail.setMessage("OK");
			detail.setUsers(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setUsers(users);
			return detail;
		}
		return detail;
	}

	public static CustomersResponse CustomerUpd(Customers customers) {
		CustomersResponse detail = new CustomersResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "UPDATE gamachicas.customer\r\n" + "SET\r\n" + "Name = :Name,\r\n"
					+ "FirstName = :FirstName,\r\n" + "SecondName = :SecondName,\r\n" + "IdPosition = :IdPosition,\r\n"
					+ "address = :address,\r\n" + "Ubigeo = :Ubigeo,\r\n" + "UrlSocialMedia = :UrlSocialMedia,\r\n"
					+ "MobilPhone = :MobilPhone,\r\n" + "Email = :Email,\r\n" + "Status = :Status,\r\n"
					+ "UpdateDate = :UpdateDate\r\n" + "WHERE idCustomer = idCustomer;";

			detail.setFullpath("/WebServiceDA/CustomerUpd");
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("idCustomer", customers.getIdCustomer())
						.addParameter("Name", customers.getName()).addParameter("FirstName", customers.getFirstName())
						.addParameter("SecondName", customers.getSecondName())
						.addParameter("IdPosition", customers.getIdPosition())
						.addParameter("address", customers.getAddress()).addParameter("Ubigeo", customers.getUbigeo())
						.addParameter("UrlSocialMedia", customers.getUrlSocialMedia())
						.addParameter("MobilPhone", customers.getMobilPhone()).addParameter("Email", customers.getEmail())
						.addParameter("Status", customers.getStatus()).addParameter("UpdateDate", LocalDateTime.now())
						.executeUpdate().getKey(int.class);
				customers.setIdCustomer(key);
				if (key == 0) {
					con.rollback();
				}
			}
			detail.setCode(200);
			detail.setDescription("Response OK");
			detail.setMessage("OK");
			detail.setCustomers(customers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setCustomers(customers);
			return detail;
		}
		return detail;
	}

	public static CustomersResponse CustomerDel(Customers customers) {
		CustomersResponse detail = new CustomersResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "DELETE FROM gamachicas.customer\r\n" + "WHERE idCustomer =:idCustomer";

			detail.setFullpath("/WebServiceDA/CustomerDel");
			try (org.sql2o.Connection con = sql2o.open()) {
				con.createQuery(sql, true).addParameter("idCustomer", customers.getIdCustomer())

						.executeUpdate().getKey(int.class);
			}
			detail.setCode(200);
			detail.setDescription("Delete OK");
			detail.setMessage("OK");
			detail.setCustomers(customers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setCustomers(customers);
			return detail;
		}
		return detail;
	}

	public static DetailImagenResponse DetailImagenUpd(Detailimagen detailImagen) {
		DetailImagenResponse detail = new DetailImagenResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "UPDATE gamachicas.detailimagen\r\n" + "SET\r\n" + "IdImagen = :IdImagen,\r\n"
					+ "Vista = :Vista,\r\n" + "url = :url,\r\n" + "Status = :Status,\r\n"
					+ "UpdateDate = :UpdateDate\r\n" + "WHERE idDetailImagen = :idDetailImagen;";
			detail.setFullpath("/WebServiceDA/DetailImagenUpd");
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("idDetailImagen", detailImagen.getIdDetailImagen())
						.addParameter("Vista", detailImagen.getVista()).addParameter("url", detailImagen.getUrl())
						.addParameter("Status", detailImagen.getStatus())
						.addParameter("UpdateDate", LocalDateTime.now()).executeUpdate().getKey(int.class);
				detailImagen.setIdDetailImagen(key);
				if (key == 0) {
					con.rollback();
				}
			}
			detail.setCode(200);
			detail.setDescription("Response OK");
			detail.setMessage("OK");
			detail.setDetailImagen(detailImagen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			detail.setCode(500);
			detail.setDescription(e.getMessage());
			detail.setMessage("Error Inesperado");
			detail.setDetailImagen(detailImagen);
			return detail;
		}
		return detail;
	}

	public static ImagenResponse ImagenDel(Imagen Imagen) {
		ImagenResponse imgResponse = new ImagenResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "DELETE FROM gamachicas.imagen\r\n" + "WHERE  idImagen =:idImagen";
			imgResponse.setFullpath("/WebServiceDA/ImagenDel");
			try (org.sql2o.Connection con = sql2o.open()) {
				con.createQuery(sql, true).addParameter("idImagen", Imagen.getIdImagen()).executeUpdate().getKey();
			}
			imgResponse.setCode(200);
			imgResponse.setDescription("Delete OK");
			imgResponse.setMessage("OK");
			imgResponse.setImagen(Imagen);
		} catch (Sql2oException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			imgResponse.setCode(500);
			imgResponse.setDescription(e.getMessage());
			imgResponse.setMessage("Error Inesperado");
			imgResponse.setImagen(Imagen);
			return imgResponse;
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

	public static PriceResponse PriceIns(Price price) {
		PriceResponse priceres = new PriceResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.price\r\n" + "(IdProduct,\r\n" + "Status,\r\n" + "CreateDate,\r\n"
					+ "UpdateDate,\r\n" + "SmallerPrice,\r\n" + "HigherPrice)\r\n" + "VALUES\r\n" + "(:IdProduct ,\r\n"
					+ ":Status ,\r\n" + ":CreateDate ,\r\n" + ":UpdateDate ,\r\n" + ":SmallerPrice ,\r\n"
					+ ":HigherPrice );\r\n";
			priceres.setFullpath("/WebServiceDA/PriceIns");
			try (org.sql2o.Connection con = sql2o.open()) {

				int key = con.createQuery(sql, true).addParameter("IdProduct", price.getIdProduct())
						.addParameter("Status", 1).addParameter("SmallerPrice", price.getSmallerPrice())
						.addParameter("HigherPrice", price.getHigherPrice())
						.addParameter("CreateDate", LocalDateTime.now()).addParameter("UpdateDate", LocalDateTime.now())
						.executeUpdate().getKey(int.class);
				price.setIdPrice(key);
				if (key == 0) {
					con.rollback();
				}
			}

			price = PriceSel(price);
			// Long key = sql2o.createQuery(insertSql,
			// true).executeUpdate().getKey(Long.class);

			priceres.setCode(200);
			priceres.setDescription("Response OK");
			priceres.setMessage("OK");
			priceres.setPrice(price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			priceres.setCode(500);
			priceres.setDescription(e.getMessage());
			priceres.setMessage("Error Inesperado");
			priceres.setPrice(price);
			return priceres;
		}
		return priceres;
	}

	public static Price PriceSel(Price price) {
		Price result = new Price();
		List<Price> lstPrice = new ArrayList<Price>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT price.idPrice,\r\n" + "price.IdProduct,\r\n" + "price.Status,\r\n"
					+ "price.CreateDate,\r\n" + "price.UpdateDate,\r\n" + "price.SmallerPrice,\r\n"
					+ "price.HigherPrice\r\n" + "FROM gamachicas.price where IdPrice= :IdPrice;";
			// result.setFullpath("/WebServiceDA/PriceSel");
			try (org.sql2o.Connection con = sql2o.open()) {
				lstPrice = con.createQuery(sql).addParameter("IdPrice", price.getIdPrice())
						.executeAndFetch(Price.class);

				if (lstPrice.size() > 0) {
					result = lstPrice.iterator().next();
				}
			}
			return result;
		} catch (Exception e) {
			return result;
		}

	}

	public static PriceResponse PriceDel(Price price) {
		PriceResponse priceres = new PriceResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "DELETE FROM gamachicas.price\r\n" + "WHERE idPrice= :idPrice;";
			priceres.setFullpath("/WebServiceDA/PriceDel");
			try (org.sql2o.Connection con = sql2o.open()) {

				con.createQuery(sql, true).addParameter("idPrice", price.getIdPrice()).executeUpdate().getKey();
			}
			price = PriceSel(price);
			priceres.setCode(200);
			priceres.setDescription("Response OK");
			priceres.setMessage("OK");
			priceres.setPrice(price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			priceres.setCode(500);
			priceres.setDescription(e.getMessage());
			priceres.setMessage("Error Inesperado");
			priceres.setPrice(price);
			return priceres;
		}
		return priceres;
	}

	public static HomeViewModelResponse HomeProductIns(HomeViewModel homeViewModel) {
		HomeViewModelResponse home = new HomeViewModelResponse();
		ProductoResponse Pro = new ProductoResponse();
		ImagenResponse imgr = new ImagenResponse();
		PriceResponse prire = new PriceResponse();
		Product producto = new Product();

		Price Pri = new Price();
		Imagen img = new Imagen();
		int IdProduct;
		int IdImagen;
		int IdPrice;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "";
			;
			home.setFullpath("/WebServiceDA/HomeProductIns");
			try (org.sql2o.Connection con = sql2o.beginTransaction()) {
				con.commit(false);
				Pro = SaveProduct(homeViewModel.getProduct());
				if (Pro.getCode() == 200) {
					IdProduct = Pro.getProduct().getIdProduct();
					homeViewModel.getProduct().setIdProduct(IdProduct);
					Pri = homeViewModel.getPrice();
					Pri.setIdProduct(IdProduct);
					img = homeViewModel.getImagen();
					img.setIdProduct(IdProduct);

					// homeViewModel.setImagen(img);
					imgr = ImagenIns(img);
					if (imgr.getCode() != 200) {
						home.setCode(500);
						home.setDescription(ImagenIns(img).getDescription());
						home.setMessage("Error Inesperado");
						home.setHomeViewModel(homeViewModel);
						ProductDel(homeViewModel.getProduct());
						con.rollback();
						return home;
					} else {
						prire = PriceIns(Pri);
						producto = ProductoSel(homeViewModel.getProduct()).getProduct();
						producto.setIdImagen(imgr.getImagen().getIdImagen());
						producto.setIdPrice(prire.getPrice().getIdPrice());
						ProductUpd(producto);
					}

				} else {
					con.rollback();
				}

			}
			home.setCode(200);
			home.setDescription("Response OK");
			home.setMessage("OK");
			home.setHomeViewModel(homeViewModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			home.setCode(500);
			home.setDescription(e.getMessage());
			home.setMessage("Error Inesperado");
			home.setHomeViewModel(homeViewModel);
			return home;
		}
		return home;
	}

}
