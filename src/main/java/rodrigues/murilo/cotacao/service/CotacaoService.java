package rodrigues.murilo.cotacao.service;

import org.springframework.web.client.RestTemplate;
import rodrigues.murilo.cotacao.model.Cotacao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CotacaoService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    public static Cotacao getCotacao() throws IOException {
        String url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)?@dataInicial='%s'&@dataFinalCotacao='%s'&$orderby=%s&$format=%s";
        String dataInicial = FORMATTER.format(LocalDate.now().minusDays(6));
        String dataFinalCotacao = FORMATTER.format(LocalDate.now());

        String orderBy = "dataHoraCotacao desc";
        String format = "json";

        // Buscamos a cotação do dolar PTAX dos ultimos sete dias ordenando pela cotação mais recente
        url = String.format(url, dataInicial, dataFinalCotacao, orderBy, format);
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, Cotacao.class);
    }
}
