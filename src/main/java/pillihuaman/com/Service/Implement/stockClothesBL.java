package pillihuaman.com.Service.Implement;
import pillihuaman.com.BusinessEntity.ViewStockBE;
import pillihuaman.com.BusinessEntity.Base.Clothing;
import pillihuaman.com.BusinessEntity.Base.Clothingline;
import pillihuaman.com.BusinessEntity.Base.Imagen;
import pillihuaman.com.dao.Impl.*;

import java.util.List;
public class stockClothesBL {
    
    public static  List<ViewStockBE>getStock( ViewStockBE objs) 
    { 
    	stockClothesDA.list();
        return null;
    }
    public static  List<Clothingline>ListClothesLine() 
    { 
        return stockClothesDA.ListClothesLine();
    }
    public static  List<Imagen> ListClothes() 
    { 
        return stockClothesDA.ListClothes();
    }
    
}
