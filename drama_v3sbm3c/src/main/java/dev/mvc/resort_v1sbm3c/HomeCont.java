package dev.mvc.resort_v1sbm3c;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.mvc.drama.DramaProcInter;
import dev.mvc.drama.DramaVO;
import dev.mvc.drama.DramaVOMenu;

@Controller
public class HomeCont {
  @Autowired
  @Qualifier("dev.mvc.drama.DramaProc")
  private DramaProcInter dramaProc;
  
  public HomeCont() {
    System.out.println("-> HomeCont created.");
  }
  
  @GetMapping(value="/") // http://localhost:9091
  public String home(Model model) { // 파일명 return
    ArrayList<DramaVOMenu> menu = this.dramaProc.menu();
    model.addAttribute("menu", menu);
    
    return "index"; // /templates/index.html  
  }
  
}






