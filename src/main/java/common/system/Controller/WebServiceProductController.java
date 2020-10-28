package common.system.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.sql2o.converters.Convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import common.system.Help.ConvertClass;
import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ProductoResponse;
import domain.System.BusinessEntity.Base.Detailimagen;
import domain.System.BusinessEntity.Base.Detailproduct;
import domain.System.BusinessEntity.Base.HomeViewModel;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Product;
import model.system.repository.ProductRepository;
import model.system.repository.WebService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("WebServiceProduct")
public class WebServiceProductController {

	@PostMapping("/SaveProduct")
	public ProductoResponse SaveProduct(@RequestBody Product pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.SaveProduct(pro);
	}

	@PostMapping("/ListProduct")
	public ProductoResponse ListProduct(@RequestBody String keySearch) {
		ProductRepository WebService = new ProductRepository();
		return WebService.ListProduct();
	}

	@RequestMapping(path = "/savefile", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public ResponseEntity handleFileUpload(@RequestPart("id") String id, @RequestPart("file") MultipartFile file) {
		List<String> files = new ArrayList<String>();
		// private final Path rootLocation = Paths.get("_Path_To_Save_The_File");
		String message;
		try {

			files.add(file.getOriginalFilename());

			message = "Successfully uploaded!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		} 
	}
	@RequestMapping(path = "/HomeProductIns", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_OCTET_STREAM_VALUE })
	//@PostMapping(path = "/HomeProductIns", consumes = "application/json", produces = "application/json")
	public HomeViewModelResponse HomeProductIns(@RequestPart("id") String id, @RequestPart("file") MultipartFile file) {
		ProductRepository WebService = new ProductRepository();
		HomeViewModel homeview= new  HomeViewModel();
		Imagen img= new Imagen();
		HomeViewModel convertedObject = new Gson().fromJson(id, HomeViewModel.class);
		img=convertedObject.getImagen();
		img.setImagendata(ConvertClass.ConverMultipartFileToByteArray(file));
		convertedObject.setImagen(img);
		// HomeViewModel homeViewModel = fromJsonString(companyJsonStr,
		// HomeViewModel.class);
		return WebService.HomeProductIns(convertedObject);
	}
	@RequestMapping(path = "/RegisterDetailImagen", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_OCTET_STREAM_VALUE })
	//@PostMapping(path = "/HomeProductIns", consumes = "application/json", produces = "application/json")
	public HomeViewModelResponse RegisterDetailImagen(@RequestPart("id") String id,
			@RequestPart("filep") MultipartFile filep,@RequestPart("fileE") MultipartFile fileE,
			@RequestPart("fileD") MultipartFile fileD) {
		ProductRepository WebService = new ProductRepository();
		Detailimagen detailImagen= new  Detailimagen();
		 if (id != null &&  ! id.isEmpty())
		 {
			detailImagen.setIdImagen(Integer.parseInt(id));
			 if(filep!= null)
			 {
				 detailImagen.setImagendata( ConvertClass.ConverMultipartFileToByteArray(filep));
				 WebService.RegisterDetailImagen(detailImagen);
			 }
			 if(fileE!= null)
			 {
				 detailImagen.setImagendata( ConvertClass.ConverMultipartFileToByteArray(fileE));
				 WebService.RegisterDetailImagen(detailImagen);
			 }
			 if(fileD!= null)
			 {
				 detailImagen.setImagendata( ConvertClass.ConverMultipartFileToByteArray(fileD));
				 WebService.RegisterDetailImagen(detailImagen);
			 } 
		 }
		return WebService.HomeProductIns(null);
	}

	@PostMapping(path = "/ListDetImagenByIdProduct", consumes = "application/json", produces = "application/json")
	public List<HomeViewModel> ListDetImagenByIdProduct(@RequestBody Product pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.ListDetImagenByIdProduct(pro);
	}

	@PostMapping(path = "/ProductoSel", consumes = "application/json", produces = "application/json")
	public ProductoResponse ProductoSel(@RequestBody Product pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.ProductoSel(pro);
	}

	@PostMapping(path = "/HomeViewModelSelByIdDroducto", consumes = "application/json", produces = "application/json")
	public HomeViewModel HomeViewModelSelByIdDroducto(@RequestBody Product pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.HomeViewModelSelByIdDroducto(pro);
	}

	@PostMapping(path = "/DetailProductIns", consumes = "application/json", produces = "application/json")
	public boolean DetailProductIns(@RequestBody Detailproduct pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.DetailProductIns(pro);
	}

	@PostMapping(path = "/ListDetailProductByIdProduct", consumes = "application/json", produces = "application/json")
	public List<Detailproduct> ListDetailProductByIdProduct(@RequestBody Detailproduct pro) {
		ProductRepository WebService = new ProductRepository();
		return WebService.ListDetailProductByIdProduct(pro);
	}

}
