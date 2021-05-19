package pillihuaman.com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pillihuaman.com.BusinessEntity.Base.Detailimagen;
import pillihuaman.com.BusinessEntity.Base.Imagen;
import pillihuaman.com.BusinessEntity.Base.Product;
import pillihuaman.com.model.response.DetailImagenResponse;
import pillihuaman.com.model.response.HomeViewModelResponse;
import pillihuaman.com.model.response.ImagenResponse;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("WebServiceImagen")
public class WebServiceImagenController {
/*	@SuppressWarnings("static-access")
	@PostMapping(path = "/ListImagenByIdProduct", consumes = "application/json", produces = "application/json")
	public HomeViewModelResponse ListImagenByIdProduct(@RequestBody Product pro) {
		ImagenRepository WebService = new ImagenRepository();
		return WebService.ListImagenByIdProduct(pro);
	}

	@PostMapping(path = "/ListImagenByTop", consumes = "application/json", produces = "application/json")
	public HomeViewModelResponse ListImagenTop(@RequestBody int count) {
		ImagenRepository WebService = new ImagenRepository();
		return WebService.ListImagenByTop(20);
	}

	@PostMapping(value = "/ImagenIns", consumes = "application/json", produces = "application/json")
	public ImagenResponse ImagenIns(@RequestBody Imagen Imagen) {
		ImagenRepository WebService = new ImagenRepository();
		return WebService.ImagenInss(Imagen);
	}

	@PostMapping(path = "/ImagenSel", consumes = "application/json", produces = "application/json")
	public ImagenResponse ImagenSel(@RequestBody Imagen img) {
		ImagenRepository WebService = new ImagenRepository();
		return WebService.ImagenSel(img);
	}
	@PostMapping(path = "/DetailimagenIns", consumes = "application/json", produces = "application/json")
	public DetailImagenResponse DetailimagenIns(@RequestBody Detailimagen img) {
		ImagenRepository WebService = new ImagenRepository();
		return WebService.DetailImagenIns(img);
	}

	   @RequestMapping(path ="/savefile", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
	   public ResponseEntity handleFileUpload(@RequestPart("id") String id,  @RequestPart("file") MultipartFile file)
	   {
		   List<String> files = new ArrayList<String>();
		   //private final Path rootLocation = Paths.get("_Path_To_Save_The_File");
		   String message;
	      try {
	      
	         files.add(file.getOriginalFilename());

	         message = "Successfully uploaded!";
	         return ResponseEntity.status(HttpStatus.OK).body(message);
	      }
	      catch (Exception e) {
	         message = "Failed to upload!";
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	      }
	   }
	  
	@RequestMapping(value = "/GetPicture", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> GetImagen(@RequestParam("id") int idimagen) throws IOException {
		Imagen img = new Imagen();
		ImagenResponse respon = new ImagenResponse();
		ImagenRepository rep = new ImagenRepository();
		img.setIdImagen(idimagen);
		respon = rep.ImagenSel(img);
		byte[] bytes = null;
		if (respon.getCode() == 200 && respon.getImagen() != null) {
			if (respon.getImagen().getImagendata() != null) {
				bytes = respon.getImagen().getImagendata();
			} else {
				bytes=NullPicture();
			}

		} else {
			bytes=NullPicture();
		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}

	public byte[] NullPicture() {
		ClassPathResource imgFile = new ClassPathResource("image/broken.png");
		byte[] bytes = null;
		try {
			bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}*/
}
