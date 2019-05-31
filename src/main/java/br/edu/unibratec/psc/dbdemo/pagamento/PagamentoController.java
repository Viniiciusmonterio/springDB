package br.edu.unibratec.psc.dbdemo.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(path = "/pagamento")
// http://localhost:8080/pagamento
public class PagamentoController {
    
    @Autowired
    private PagamentoRepository PagamentoRepository;
    
    @GetMapping(path = "/")
    public @ResponseBody Iterable<Pagamento> getpagamento(){
        return PagamentoRepository.findAll();
    }

}