package common.system.Help;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ConvertClass {
	private static byte[] byteArray;
	private File file;
	private MultipartFile mutiparfile;

	public static byte[] ConverMultipartFileToByteArray(MultipartFile multipart) {
		try {
			byteArray = multipart.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteArray;
	}
}
