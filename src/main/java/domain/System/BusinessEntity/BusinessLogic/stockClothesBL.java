package domain.System.BusinessEntity.BusinessLogic;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothing;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Imagen;
import repository.System.DataAccess.MySql.*;
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
