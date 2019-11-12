package rodrigues.murilo.cotacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cotacao {

    @JsonProperty("value")
    private List<Dolar> dolar;

    public List<Dolar> getDolar() {
        return dolar;
    }
    public void setDolar(List<Dolar> dolar) {
        this.dolar = dolar;
    }

    public Dolar getUltimaCotacao(){
        return getDolar().get(0);
    }
}
