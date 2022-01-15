package sample.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;

import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;
import java.io.IOException;

@Controller
@EnableAutoConfiguration
public class FileDownloadApplication {
    
    @GetMapping("/download")
    String download(HttpServletResponse response) {
        try(OutputStream outputStream = response.getOutputStream()) {
            byte[] data = "hogehogeあああ".getBytes("UTF-8");
            
            response.setContentType("application/octet-stream");
            response.setHeader("content-Disposition", "attachment; filename=file-download-sample.txt");
            response.setContentLength(data.length);
            
            outputStream.write(data);
            outputStream.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;        
    }
    public static void main( String[] args ) {
        SpringApplication.run(FileDownloadApplication.class, args);
    }
}
