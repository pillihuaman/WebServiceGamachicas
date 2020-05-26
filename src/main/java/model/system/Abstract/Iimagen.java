package model.system.Abstract;


import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ImagenResponse;
import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Product;
import repository.System.DataAccess.MySql.ImagenDa;

public interface Iimagen {

	BigInteger registerImagen (CrudImagenBE CrudImagenBE);
	int tesinsert (CrudImagenBE CrudImagenBE);
	List<Imagen> listaImagen ();
	List<Detailimagen>  ListaDetalleImagenXID(int idimagen); 
	List<Detailimagen>  lstIDdetalle(int iddetalleimagen);
	int insertDetailImagen (ViewStockBE ViewStockBE);
	int   InsertImagen( CrudImagenBE CrudImagenBE) throws SQLException, IOException;
	int   InsertDetalleImagen( ViewStockBE ViewStockBE) throws SQLException, IOException; 
	HomeViewModelResponse ListImagenByIdProduct(Product pro);
	HomeViewModelResponse ListImagenByTop(int count);
	ImagenResponse ImagenIns( Imagen  Imagen);
	ImagenResponse ImagenInss( Imagen  Imagen);
	ImagenResponse ImagenSel(Imagen img);
}
