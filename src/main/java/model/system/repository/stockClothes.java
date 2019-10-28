package model.system.repository;
import domain.System.BusinessEntity.BusinessLogic.stockClothesBL;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothing;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Imagen;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.system.Abstract.IstockClothes;
import org.springframework.stereotype.Service;
public class stockClothes implements IstockClothes{

    public    List<ViewStockBE> getViewStock(ViewStockBE objs) {
        stockClothesBL obl= new stockClothesBL();
        return  obl.getStock(objs);
    }


	public  List<Clothingline> ListClothesLine() {
		return stockClothesBL.ListClothesLine();
	}
	public  List<Imagen> ListClothes() {
		return stockClothesBL.ListClothes();
	}


    
}
