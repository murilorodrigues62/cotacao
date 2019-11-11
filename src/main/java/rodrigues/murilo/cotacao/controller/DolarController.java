package rodrigues.murilo.cotacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rodrigues.murilo.cotacao.model.Dolar;
import rodrigues.murilo.cotacao.model.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/dolar")
public class DolarController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    @GetMapping
    public Value ultimoPtax() {
        String url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)?@dataInicial='%s'&@dataFinalCotacao='%s'&$top=%s&$orderby=%s&$format=%s";
        String dataInicial = FORMATTER.format(LocalDate.now().minusDays(7));
        String dataFinalCotacao = FORMATTER.format(LocalDate.now());
        String top = "7";
        String orderBy = "dataHoraCotacao desc";
        String format = "json";

        // Buscamos a cotação do dolar PTAX dos ultímos sete dias, trazendo no máximo 7 cotações e ordenando pela cotação mais recente
        url = String.format(url, dataInicial, dataFinalCotacao, top, orderBy, format);
        RestTemplate restTemplate = new RestTemplate();
        Dolar dolar = restTemplate.getForObject(url, Dolar.class);

        // Retornamos a ultima cotação encontrada
        return dolar.getValue().get(0);
    }
}
