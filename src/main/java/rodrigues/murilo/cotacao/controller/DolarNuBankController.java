package rodrigues.murilo.cotacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rodrigues.murilo.cotacao.model.Dolar;
import rodrigues.murilo.cotacao.model.DolarNuBank;
import rodrigues.murilo.cotacao.service.CotacaoService;

import java.io.IOException;

@RestController
@RequestMapping("/nubank")
public class DolarNuBankController {

    @GetMapping
    public DolarNuBank getValorAtual() throws IOException {

        // Pegamos a ultima cotação do dolar PTAX de venda
        Dolar dolar = CotacaoService.getCotacao().getUltimaCotacao();

        DolarNuBank nuBank = new DolarNuBank(dolar.getCotacaoVenda(), dolar.getDataHoraCotacao());

        return nuBank;
    }
}
