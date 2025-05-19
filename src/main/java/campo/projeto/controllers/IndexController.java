package campo.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/index"})
public class IndexController {
    
    // sempre que ocorrer get na rota / ou /index
    @GetMapping
    public String carregarIndex() {
        return "index";
    }

}
