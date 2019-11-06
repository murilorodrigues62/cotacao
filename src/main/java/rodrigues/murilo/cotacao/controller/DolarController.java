package rodrigues.murilo.cotacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rodrigues.murilo.cotacao.model.Dolar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/dolar")
public class DolarController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    @GetMapping
    public Dolar ultimoPtax() {

        String data = FORMATTER.format(LocalDate.now());
        String url = String.format("https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='%s'", data);

        RestTemplate restTemplate = new RestTemplate();
        Dolar dolar = restTemplate.getForObject(url, Dolar.class);

        return dolar;
    }
}
