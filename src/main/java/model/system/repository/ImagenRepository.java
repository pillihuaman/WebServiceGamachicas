package model.system.repository;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.BusinessLogic.ImagenBL;
import model.system.Abstract.Iimagen;

public class ImagenRepository implements Iimagen{


	public   BigInteger registerImagen(CrudImagenBE CrudImagenBE) {
		// TODO Auto-generated method stub
		return ImagenBL.registerImagen(CrudImagenBE);
	}


	//public int tesinsert(CrudImagenBE CrudImagenBE) {
		// TODO Auto-generated method stub
	//	return  ImagenBL.tesinsert(CrudImagenBE);
	//}

	
	public List<Imagen> listaImagen() {
		// TODO Auto-generated method stub
		return ImagenBL.listImagen();
	}





	@Override
	public int insertDetailImagen(ViewStockBE ViewStockBE) {
		// TODO Auto-generated method stub
		return ImagenBL.RegisterDetailImagen(ViewStockBE);
	}


	@Override
	public int tesinsert(CrudImagenBE CrudImagenBE) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Detailimagen> ListaDetalleImagenXID(int idimagen) {
		// TODO Auto-generated method stub
		 return ImagenBL.ListaDetalleImagenXID(idimagen);
	}


	@Override
	public int InsertImagen(CrudImagenBE CrudImagenBE) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return ImagenBL.InsertImagen(CrudImagenBE);
	}


	@Override
	public int InsertDetalleImagen(ViewStockBE ViewStockBE) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return ImagenBL.InsertDetalleImagen(ViewStockBE);
	}


	@Override
	public List<Detailimagen> lstIDdetalle(int iddetalleimagen) {
		// TODO Auto-generated method stub
		return ImagenBL.lstIDdetalle(iddetalleimagen);
	}


//	@Override
//	public int InsertProduct(ViewProductBE ViewProductBE) throws SQLException, IOException {
//		// TODO Auto-generated method stub
//		return ImagenBL.InsertProduct(ViewProductBE);
//	}


}
