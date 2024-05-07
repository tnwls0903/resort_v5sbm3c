package dev.mvc.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/file")
@Controller
public class FileCont {

  public FileCont() {
    System.out.println("-> FileCont");
  }

  // create 폼 출력
  @GetMapping(value = "/upload") // http://localhost:9091/file/upload
  public String upload() {
    return "/file/upload_form"; // /templates/file/upload_form.html
  }

  private static String UPLOADED_FOLDER = "C:/kd/temp/"; // 파일을 저장할 폴더

  @PostMapping(value = "/upload")
  public String singleFileUpload(@RequestParam("file") MultipartFile file, 
                                              RedirectAttributes ra) {

    if (file.isEmpty()) {
      ra.addFlashAttribute("message", "파일을 선택해주세요.");
      return "redirect:/file/upload_msg";
    }

    try {
      // 파일 데이터를 저장할 경로를 설정합니다.
      byte[] bytes = file.getBytes();
      Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
      Files.write(path, bytes);

      // 업로드 성공 메시지를 추가합니다.
      ra.addFlashAttribute("fname", file.getOriginalFilename());
      ra.addFlashAttribute("message", "파일 업로드 성공: [" + file.getOriginalFilename() + "]");

    } catch (IOException e) {
      e.printStackTrace();
    }

    return "redirect:/file/upload_msg";
  }

  @RequestMapping("/upload_msg")
  public String uploadStatus() {
    return "file/upload_msg"; // 업로드 상태를 보여주는 뷰의 이름
  }
}


