package model.system.Abstract;

import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.*;
import model.system.repository.stockClothes;

import java.util.List;

/**
 *
 * @author zarmir
 */
public  interface IstockClothes {
    
     List<ViewStockBE>  getViewStock(ViewStockBE objs);
     List<Clothingline>  ListClothesLine();
}