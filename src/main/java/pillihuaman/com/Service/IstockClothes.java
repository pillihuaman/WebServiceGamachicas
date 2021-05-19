package pillihuaman.com.Service;

import java.util.List;

import pillihuaman.com.BusinessEntity.ViewStockBE;
import pillihuaman.com.BusinessEntity.Base.*;

/**
 *
 * @author zarmir
 */
public  interface IstockClothes {
    
     List<ViewStockBE>  getViewStock(ViewStockBE objs);
     List<Clothingline>  ListClothesLine();
}