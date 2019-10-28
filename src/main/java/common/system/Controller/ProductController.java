package common.system.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import common.system.ViewModel.ListProductViewModel;
import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewProductBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothing;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Price;
import domain.System.BusinessEntity.Base.Producto;
import model.system.repository.ImagenRepository;
import model.system.repository.stockClothes;
@RestController
public class ProductController {

    @RequestMapping(value = "/registerProduct", method = RequestMethod.GET)
	  public ModelAndView registerProduct( ModelMap mod) {
          stockClothes stockClothes= new stockClothes();
		   mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
		   //mod.addAttribute("Mensaje", "Registra informacion basica");
		   //ViewStockBE mdod = new ViewStockBE();
		   //Clothingline ob = new Clothingline();
		   //Imagen img = new Imagen();
		   //mdod.setClothingline(ob);
		   //mdod.setImagen(img);
    	 return new ModelAndView("registerProduct", "command", new ViewProductBE());
    }
    
 		@RequestMapping(value = "/registerProductpost", method = RequestMethod.POST)
 	 public String registerProductpost(@ModelAttribute("command")ViewProductBE ViewProductBE,@RequestParam("files") MultipartFile[]  files,
                    RedirectAttributes redirectAttributes) throws IOException {
 			int  idiamgen=0;
			int idiamgendetail=0;
			  for (int i = 0; i < files.length; i++) {
		            MultipartFile file = files[0];
		           // String description = descriptions[i];
		      
		                byte[] bytes = file.getBytes();
		                
		                if (file.isEmpty()) {
				            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
				            return "redirect:uploadStatus";
				        }

			   if (file.isEmpty()) {
		            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
		            return "redirect:uploadStatus";
		        }

		        try {

		        	if(i==0)
		        	{
		            // Get the file and save it somewhere
		           // byte[] bytes = file.getBytes();
		            //Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		            //Files.write(path, bytes);
		            
		            //zph
		        		ViewProductBE objs= new ViewProductBE();
		    		ImagenRepository insert= new ImagenRepository();
		        	stockClothes stockClothes= new stockClothes();
		        	Imagen img = new Imagen();
		         	Price pr = new Price();
		         	Clothingline cl = new Clothingline();
		        	img.setImagendata(bytes);
		        
		           	img.setCountViews(ViewProductBE.getImagen().getCountViews());
		           	img.setDescription(ViewProductBE.getImagen().getDescription());
		           	img.setIdposition(ViewProductBE.getImagen().getIdposition());
		           	img.setPositionweb(ViewProductBE.getImagen().getPositionweb());
		        	img.setName(ViewProductBE.getImagen().getName());
		        	pr.setPreciomayor(ViewProductBE.getPrice().getPreciomayor());
		        	pr.setPreciomenor(ViewProductBE.getPrice().getPreciomenor());
		        	cl.setIdclothingline(ViewProductBE.getClothingline().getIdclothingline());
		        
		        	ViewProductBE crud= new ViewProductBE();
		        	crud.setImagen(img);
		        	crud.setPrice(pr);
		        	crud.setClothingline(cl);
		        	//crud.setTest(ViewStockBE.getTest());
		        	//int test=insert.tesinsert(crud);
		        	 //idiamgen=insert.registerImagen(crud);
		        	 try {
						idiamgen=insert.InsertProduct(crud);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
		        	}
		        	 if(idiamgen != 0)
		        		 {
		        		 if(i>0)
		        		 { 
		        			 //if( file.isEmpty())
		        			 //{
		        			ViewStockBE detalleimagen = new ViewStockBE();
		        		    Detailimagen  det = new Detailimagen();
		        		    ImagenRepository insertdet= new ImagenRepository();
		        		    MultipartFile filees = files[i];
	        			    byte[] bytess = filees.getBytes();
		        		    det.setIdimagen(idiamgen);
		        		    det.setVista(i);
		        		    det.setDescripcion("Imagen numero "+i);
		        		    det.setImagendata(bytess);
		        		    detalleimagen.setDetailimagen(det);
		        		    try {
								idiamgendetail=insertdet.InsertDetalleImagen(detalleimagen);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        			 //Insertamos detalle de la imagen  
		        		 //}
		        		 }
		        		 
		        		 }		 
		        	 
		        	//zph

		            redirectAttributes.addFlashAttribute("message",
		                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

			  }
		        return "uploadStatus";

 		   }

}


 		  