package common.system.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import common.system.model.response.HomeViewModelResponse;
import common.system.model.response.ImagenResponse;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.Base.Product;
import model.system.repository.ImagenRepository;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("WebServiceImagen")
public class WebServiceImagenController {
	@SuppressWarnings("static-access")
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
	}
}
