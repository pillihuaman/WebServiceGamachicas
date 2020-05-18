package repository.System.DataAccess.MySql;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.sql2o.Sql2o;

import common.system.model.response.ProductoResponse;
import common.system.model.response.UsersResponse;
import domain.System.BusinessEntity.Base.Price;
import domain.System.BusinessEntity.Base.Product;
import domain.System.BusinessEntity.Base.Users;
import domain.System.BusinessEntity.BusinessLogic.UserBL;
import infrastructure.System.Adapters.EntityDBConnection;
import infrastructure.System.Adapters.MySqlAdapter;

public class UserDA {
	public static UsersResponse UsersIns(Users users) {
		UsersResponse detail = new UsersResponse();
		 final org.apache.logging.log4j.Logger logger = LogManager.getLogger(UserBL.class);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "INSERT INTO gamachicas.users\r\n" + 
					"(IdSystem,username,password,salPassword,ApiPassword,Alias,IdRol,Mail,MobilPhone,Status,CreateDate,UpdateDate)\r\n" + 
					"VALUES\r\n" + 
					"(:IdSystem,:username,:password,:salPassword,:ApiPassword,:Alias ,:IdRol,:Mail,:MobilPhone,:Status,:CreateDate,:UpdateDate );";
			detail.setFullpath("/WebServiceDA/UsersIns");
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true)
						.addParameter("IdSystem", users.getIdSystem())
						.addParameter("username", users.getUsername())
     					.addParameter("password", users.getPassword())
     					.addParameter("salPassword", users.getSalPassword())
     					.addParameter("ApiPassword", users.getApiPassword())
						.addParameter("Alias", users.getAlias())
						.addParameter("IdRol", users.getIdRol())
						.addParameter("Mail", users.getMail())
						.addParameter("MobilPhone", users.getMobilPhone())
						.addParameter("Status", users.getStatus())
						.addParameter("CreateDate", LocalDateTime.now())
						.addParameter("UpdateDate", LocalDateTime.now())
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
			logger.error(detail.getFullpath()+" "+ detail.getDescription(),users);
			return detail;
		}
		return detail;
	}

	public static UsersResponse UsersUpd(Users users) {
		UsersResponse detail = new UsersResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "UPDATE gamachicas.users\r\n" + "SET\r\n" + "IdSystem = IdSystem ,\r\n"
					+ "FullName = FullName ,\r\n" + "Alias = Alias ,\r\n" + "IdRol = IdRol ,\r\n" + "Mail = Mail ,\r\n"
					+ "MobilPhone = MobilPhone ,\r\n" + "Status = Status ,\r\n" + "UpdateTime = UpdateTime \r\n"
					+ "WHERE idUser = idUser;";
			detail.setFullpath("/WebServiceDA/UsersUpd");
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("idUser", users.getIdUser())
						.addParameter("IdSystem", users.getIdSystem()).addParameter("username", users.getUsername())
						.addParameter("Alias", users.getAlias()).addParameter("IdRol", users.getIdRol())
						.addParameter("Mail", users.getMail()).addParameter("MobilPhone", users.getMobilPhone())
						.addParameter("Mail", users.getMail()).addParameter("Status", users.getStatus())
						.addParameter("UpdateDate", LocalDateTime.now()).executeUpdate().getKey(int.class);
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

	public static UsersResponse usersDel(Users users) {
		UsersResponse detail = new UsersResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "DELETE FROM gamachicas.users\r\n" + "WHERE idUser=idUser";
			try (org.sql2o.Connection con = sql2o.open()) {
				int key = con.createQuery(sql, true).addParameter("idUser", users.getIdUser()).executeUpdate()
						.getKey(int.class);
				users.setIdUser(key);
				if (key == 0) {
					con.rollback();
				}
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

	public static UsersResponse UserSelByMail(Users users) {
		UsersResponse result = new UsersResponse();
		List<Users> prod = new ArrayList<Users>();
		Users userss = new Users();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT users.idUser,\r\n" + "users.IdSystem,\r\n" + "users.username,\r\n"
					+ "users.ApiPassword,\r\n" 	+ "users.password,\r\n" +  "users.salPassword,\r\n" + "users.Alias,\r\n" + "users.IdRol,\r\n" + "users.Mail,\r\n"
					+ "users.MobilPhone,\r\n" + "users.Status,\r\n" + "users.CreateDate,\r\n" + "users.UpdateDate\r\n"
					+ "FROM gamachicas.users  where Mail= :Mail ;";
			try (org.sql2o.Connection con = sql2o.open()) {
				prod = con.createQuery(sql).addParameter("Mail", users.getMail()).executeAndFetch(Users.class);
				result.setCode(200);
				result.setDescription("Response OK");
				result.setMessage("OK"); 
				result.setListUsers(prod);
				if (prod.size() > 0) {
					userss = prod.iterator().next();
					result.setUsers(userss);
				}
				result.setListUsers(prod);
				return result;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result.setCode(500);
			result.setDescription(e.getMessage());
			result.setMessage("Error Inesperado");
			result.setListUsers(prod);
			return result;
		}
	}
	
	public static UsersResponse UserSel(Users users) {
		UsersResponse result = new UsersResponse();
		List<Users> prod = new ArrayList<Users>();
		Users userss = new Users();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			EntityDBConnection conne = MySqlAdapter.getConnectionString();
			Sql2o sql2o = new Sql2o(conne.getUrl(), conne.getUser(), conne.getPassword());
			String sql = "SELECT users.idUser,\r\n" + "users.IdSystem,\r\n" + "users.username,\r\n"
					+ "users.password,\r\n" + "users.Alias,\r\n" + "users.IdRol,\r\n" + "users.Mail,\r\n"
					+ "users.MobilPhone,\r\n" + "users.Status,\r\n" + "users.CreateDate,\r\n" + "users.UpdateTime\r\n"
					+ "FROM gamachicas.users  where idUser= :idUser ;";
			try (org.sql2o.Connection con = sql2o.open()) {
				prod = con.createQuery(sql).addParameter("idUser", users.getIdUser()).executeAndFetch(Users.class);
				result.setCode(200);
				result.setDescription("Response OK");
				result.setMessage("OK");
				result.setListUsers(prod);
				if (prod.size() > 0) {
					userss = prod.iterator().next();
					result.setUsers(userss);
				}
				result.setListUsers(prod);
				return result;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result.setCode(500);
			result.setDescription(e.getMessage());
			result.setMessage("Error Inesperado");
			result.setListUsers(prod);
			return result;
		}
	}


}
