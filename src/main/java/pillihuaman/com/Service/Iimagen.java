package pillihuaman.com.Service;


import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import pillihuaman.com.BusinessEntity.CrudImagenBE;
import pillihuaman.com.BusinessEntity.ViewStockBE;
import pillihuaman.com.BusinessEntity.Base.Detailimagen;
import pillihuaman.com.BusinessEntity.Base.Imagen;
import pillihuaman.com.BusinessEntity.Base.Product;
import pillihuaman.com.dao.Impl.ImagenDa;
import pillihuaman.com.model.response.DetailImagenResponse;
import pillihuaman.com.model.response.HomeViewModelResponse;
import pillihuaman.com.model.response.ImagenResponse;

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
	DetailImagenResponse DetailImagenIns(Detailimagen detimg);

}
