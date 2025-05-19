package campo.projeto.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import campo.projeto.domain.leituraSensor.LeituraSensor;
import campo.projeto.domain.leituraSensor.LeituraSensorRepository;

@Controller
@RequestMapping("/historico")
public class HistoricoController {
     private final LeituraSensorRepository leituraSensorRepository;

    public HistoricoController(LeituraSensorRepository l) {
        this.leituraSensorRepository = l;
    }

    @GetMapping
     public String buscarHistorico(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
        Model model
    ) {
        List<LeituraSensor> leituras;

        if (dataInicio != null) {
            if(dataFim == null) {
                dataFim = LocalDate.now();
            }
            LocalDateTime inicio = dataInicio.atStartOfDay();
            LocalDateTime fim = dataFim.atTime(23, 59, 59);
            leituras = leituraSensorRepository.findByDataHoraBetween(inicio, fim);
        } else {
            leituras = leituraSensorRepository.findAll();
        }

        model.addAttribute("lista", leituras);
        return "pag_historico";
    }

}
