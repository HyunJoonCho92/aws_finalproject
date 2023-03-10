package upload0118_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.MyWebConfig;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	
	//c:/upload 파일리스트 출력
	@RequestMapping("/filelist")
	public ModelAndView downloadlist() {
		ModelAndView mv = new ModelAndView();
		
		//for window
		//File f = new File("c:/upload");
		
		//for linux
		File f = new File(MyWebConfig.savePath);
		String[] filelist = f.list();
		mv.addObject("filelist", filelist);
		mv.setViewName("upload/filelist");
		return mv;
	}
	
	@RequestMapping("/filedownload")
	public void filedownload(String onefile, HttpServletResponse response) throws IOException{
		//onefile 이라는 이름의 파일을 C:/UPLOAD 찾는다.
		
		//for window
		//File f = new File("c:/upload/" + onefile);
		
		//for linux
		File f = new File(MyWebConfig.savePath + onefile);
		
		
		int f_length = (int)f.length(); //byte단위
		
		//응답할 컨텐츠 다운로드 파일
		response.setContentType("application/download;charset=utf-8"); //"text/html;charset=utf-8");
		response.setContentLength(f_length);
		response.setHeader("Content-Disposition",  "attachment;filename=\"" + onefile + "\"");
		
		OutputStream out = response.getOutputStream();
		FileInputStream f_in = new FileInputStream(f);
		FileCopyUtils.copy(f_in,  out);
		f_in.close();
		out.close();
	}
}