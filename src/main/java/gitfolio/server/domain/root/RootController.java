package gitfolio.server.domain.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String index() {
        return "index"; // resources/templates/index.html 파일을 반환하도록 설정
    }
}
