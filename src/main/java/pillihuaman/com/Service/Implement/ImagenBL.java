package pillihuaman.com.Service.Implement;

import java.awt.Image;
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
import pillihuaman.com.dao.Impl.WebServiceDA;
import pillihuaman.com.model.response.HomeViewModelResponse;
import pillihuaman.com.model.response.ImagenResponse;

public class ImagenBL {
	public static BigInteger registerImagen(CrudImagenBE CrudImagenBE) {
		return ImagenDa.registerImagen(CrudImagenBE);
	}

	public static BigInteger tesinsert(CrudImagenBE CrudImagenBE) {
		return ImagenDa.registerImagen(CrudImagenBE);
	}

	public static List<Imagen> listImagen() {
		return ImagenDa.list();
	}

	public static List<Detailimagen> ListaDetalleImagenXID(int idimagen) {
		return ImagenDa.ListaDetalleImagenXID(idimagen);
	}

	public static List<Detailimagen> lstIDdetalle(int iddetalleimagen) {
		return ImagenDa.lstIDdetalle(iddetalleimagen);
	}

	public static List<Imagen> listImagenXID(int idimagen) {
		return ImagenDa.list();
	}

	public static int RegisterDetailImagen(ViewStockBE ViewStockBE) {
		return ImagenDa.RegisterDetailImagen(ViewStockBE);
	}

	public static int InsertImagen(CrudImagenBE CrudImagenBE) throws SQLException, IOException {
		return ImagenDa.InsertImagen(CrudImagenBE);
	}

	public static int InsertDetalleImagen(ViewStockBE ViewStockBE) throws SQLException, IOException {
		return ImagenDa.InsertDetalleImagen(ViewStockBE);
	}

	public static HomeViewModelResponse ListImagenByIdProduct(Product pro) {
		return ImagenDa.ListImagenByIdProduct(pro);
	}
	public static HomeViewModelResponse ListImagenByTop(int count) {
		return ImagenDa.ListImagenByTop(count);
	}
	public static ImagenResponse ImagenIns(Imagen Imagen) {
		return ImagenDa.ImagenIns(Imagen);
	}
	public static ImagenResponse ImagenInss(Imagen Imagen) {
		return ImagenDa.ImagenInss(Imagen);
				//WebServiceDA.ImagenIns(Imagen);
	}

}
