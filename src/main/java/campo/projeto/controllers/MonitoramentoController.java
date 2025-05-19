package campo.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import campo.projeto.domain.leituraSensor.LeituraSensorRepository;

@Controller
@RequestMapping("/monitoramento")
public class MonitoramentoController {

    private final LeituraSensorRepository leituraSensorRepository;

    public MonitoramentoController(LeituraSensorRepository l) {
        this.leituraSensorRepository = l;
    }

    @GetMapping
    public String carregarMonitoramento(Model model) {
        var l = leituraSensorRepository.findTopByOrderByDataHoraDesc();
        model.addAttribute("item", l);
        return "pag_monitoramento";
    }

    
}
