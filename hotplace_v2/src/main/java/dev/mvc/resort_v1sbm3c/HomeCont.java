package dev.mvc.resort_v1sbm3c;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.mvc.hotplace.HotplaceProcInter;
import dev.mvc.hotplace.HotplaceVO;
import dev.mvc.hotplace.HotplaceVOMenu;

@Controller
public class HomeCont {
  @Autowired
  @Qualifier("dev.mvc.hotplace.HotplaceProc")
  private HotplaceProcInter hotplaceProc;
  
  public HomeCont() {
    System.out.println("-> HomeCont created.");
  }
  
  @GetMapping(value="/") // http://localhost:9093
  public String home(Model model) { // 파일명 return
    ArrayList<HotplaceVOMenu> menu = this.hotplaceProc.menu();
    model.addAttribute("menu", menu);
    
    return "index"; // /templates/index.html  
  }
  
}






