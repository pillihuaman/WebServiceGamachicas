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

import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ImagenResponse;
import common.system.model.response.PriceResponse;
import common.system.model.response.ProductoResponse;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Price;
import domain.System.BusinessEntity.Base.Product;
import domain.System.BusinessEntity.BusinessLogic.ImagenBL;
import domain.System.BusinessEntity.BusinessLogic.ProductBL;
import infrastructure.System.Adapters.EntityDBConnection;
import infrastructure.System.Adapters.MySqlAdapter;

public class ProductDA {
//RegisterDetailImagen
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
				home.setDetailImagen(Detailimagen);
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
				home.setDetailImagen(Detailimagen);
				home.setImagen(Imagen);
				home.setPrice(Price);
				home.setProducto(Producto);
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
	public static ProductoResponse ListProduct() {
		ProductoResponse pro= new ProductoResponse();
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
				pro.setListProduct( con.createQuery(sql)
						// .addParameter("idimagen", 1)
						.executeAndFetch(Product.class));
			}

			return pro;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  pro;
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
				Pro = SaveProduct(homeViewModel.getProducto());
				if (Pro.getCode() == 200) {
					IdProduct = Pro.getProduct().getIdProduct();
					homeViewModel.getProducto().setIdProduct(IdProduct);
					Pri = homeViewModel.getPrice();
					Pri.setIdProduct(IdProduct);
					img = homeViewModel.getImagen();
					img.setIdProduct(IdProduct);

					// homeViewModel.setImagen(img);
					imgr =ImagenBL.ImagenIns(img);
					if (imgr.getCode() != 200) {
						home.setCode(500);
						home.setDescription(ImagenBL.ImagenIns(img).getDescription());
						home.setMessage("Error Inesperado");
						home.setHomeViewModel(homeViewModel);
						ProductDel(homeViewModel.getProducto());
						con.rollback();
						return home;
					} else {
						prire = PriceDA.PriceIns(Pri);
						producto = ProductoSel(homeViewModel.getProducto()).getProduct();
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

	public static boolean RegisterDetailImagen(Detailimagen pro) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.detailimagen\r\n" + 
					"(\r\n" + 
					"idImagen,\r\n" + 
					"imagendata,\r\n" + 
					"Vista,\r\n" + 
					"url,\r\n" + 
					"Status,\r\n" + 
					"CreateDate,\r\n" + 
					"UpdateDate)\r\n" + 
					"VALUES\r\n" + 
					"(:idImagen ,\r\n" + 
					":imagendata ,\r\n" + 
					":Vista ,\r\n" + 
					":url ,\r\n" + 
					":Status ,\r\n" + 
					":CreateDate ,\r\n" + 
					":UpdateDate);";
			try (org.sql2o.Connection con = sql2o.open()) {
				con.createQuery(sql, true).addParameter("idImagen", pro.getIdImagen())
						.addParameter("imagendata", pro.getImagendata())
						.addParameter("Vista", pro.getVista())
						.addParameter("url", pro.getUrl())
						.addParameter("Status", pro.getStatus())
						.addParameter("CreateDate", LocalDateTime.now())
						.addParameter("UpdateDate", LocalDateTime.now())
						.executeUpdate().getKey();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
