package springmvcsearch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping("/fileform")
	public String showfileform() {
		String s=null;
		s.charAt(0);
		return "fileform";
	}
	@RequestMapping(path="uploadfile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("image") CommonsMultipartFile file, HttpSession s, Model m) {
		System.out.println("File uploaded");
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());
		byte[] data = file.getBytes();
		
		String path = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator + "image" + File.separator + file.getOriginalFilename();
		System.out.println(path);
		try {
		
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
		m.addAttribute("msg", "successfull");
		m.addAttribute("name", file.getOriginalFilename());
		System.out.println("File has been uploaded succesfully");
		}
		catch(IOException e) {
			System.out.println(e);
			m.addAttribute("msg", "failed");
			System.out.println("File couldn't be uploaded");
		}
		
		return "filesuccess";
	}
}
