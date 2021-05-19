package pillihuaman.com.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.sql2o.Sql2o;

import pillihuaman.com.Adapters.EntityDBConnection;
import pillihuaman.com.Adapters.MySqlAdapter;
import pillihuaman.com.BusinessEntity.Base.Price;
import pillihuaman.com.model.response.PriceResponse;

public class PriceDA {
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
}
