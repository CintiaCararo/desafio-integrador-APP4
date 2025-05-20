package campo.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    //para fazer login
    @GetMapping("/login")
    public String carregaPaginaLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String carregaPaginaLogout(){
        return "logout";
    }
}