package rodrigues.murilo.cotacao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private BigDecimal cotacaoVenda;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime dataHoraCotacao;

    public LocalDateTime getDataHoraCotacao() { return dataHoraCotacao;  }
    public void setDataHoraCotacao(LocalDateTime dataHoraCotacao) {
        this.dataHoraCotacao = dataHoraCotacao;
    }
    public BigDecimal getCotacaoVenda() {
        return cotacaoVenda;
    }
    public void setCotacaoVenda(BigDecimal cotacaoVenda) {
        this.cotacaoVenda = cotacaoVenda;
    }

}
