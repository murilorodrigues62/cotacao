package rodrigues.murilo.cotacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dolar {

    private BigDecimal cotacaoVenda;
    private String dataHoraCotacao;

    public String getDataHoraCotacao() { return dataHoraCotacao;  }
    public void setDataHoraCotacao(String dataHoraCotacao) {
        this.dataHoraCotacao = dataHoraCotacao;
    }
    public BigDecimal getCotacaoVenda() {
        return cotacaoVenda;
    }
    public void setCotacaoVenda(BigDecimal cotacaoVenda) {
        this.cotacaoVenda = cotacaoVenda;
    }

}
