package rodrigues.murilo.cotacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dolar {

    @JsonProperty("value")
    private List<Value> value;

    public List<Value> getValue() {
        return value;
    }
    public void setValue(List<Value> value) {
        this.value = value;
    }

}
