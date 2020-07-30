package model.system.repository;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import common.system.model.response.DetailImagenResponse;
import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ImagenResponse;
import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Product;
import domain.System.BusinessEntity.BusinessLogic.ImagenBL;
import domain.System.BusinessEntity.BusinessLogic.WebServiceBL;
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


	@Override
	public HomeViewModelResponse  ListImagenByIdProduct(Product pro) {
		// TODO Auto-generated method stub
		return ImagenBL.ListImagenByIdProduct(pro);
	}


	@Override
	public HomeViewModelResponse ListImagenByTop(int count) {
		// TODO Auto-generated method stub
		return ImagenBL.ListImagenByTop(count);
	}
	@Override
	public ImagenResponse ImagenIns(Imagen Imagen) {
		// TODO Auto-generated method stub
		return ImagenBL.ImagenIns(Imagen);
	}

	@Override
	public ImagenResponse ImagenInss(Imagen Imagen) {
		// TODO Auto-generated method stub
		return ImagenBL.ImagenInss(Imagen);
	}
	@Override
	public ImagenResponse ImagenSel(Imagen img) {
		// TODO Auto-generated method stub
		return WebServiceBL.ImagenSel(img);
	}


	@Override
	public DetailImagenResponse DetailImagenIns(Detailimagen detimg) {
		// TODO Auto-generated method stub
		return WebServiceBL.DetailImagenIns(detimg);
	}





}
