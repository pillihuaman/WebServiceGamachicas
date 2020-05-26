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
			
				//responseimg.setListImagen(imgc);
			}
			if (imgc.size() > 0) {
				responseimg.setImagen(imgc.iterator().next());
			}

			return responseimg;
		} catch (Exception e) {
			responseimg.setCode(500);
			responseimg.setDescription(e.getMessage());
			responseimg.setMessage("Error");
			responseimg.setListImagen(imgc);
		}
		return responseimg;
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

	

	
	



}
