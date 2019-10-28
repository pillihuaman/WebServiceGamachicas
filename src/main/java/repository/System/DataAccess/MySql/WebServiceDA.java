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
//import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;
import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewProductBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Producto;
import infrastructure.System.Adapters.EntityDBConnection;
import infrastructure.System.Adapters.MySqlAdapter;

public class WebServiceDA {

    public  static List<Producto> listaProductos()  
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
	          String sql ="select  pro.IdProducto,pro.Nombre,pro.Descripcion from  gamachicas.producto pro;";
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
}
   