package rodrigues.murilo.cotacao.model;

import java.math.BigDecimal;
import java.util.Objects;

public class DolarNuBank {

    private final BigDecimal spread = new BigDecimal("0.04");
    private BigDecimal ptax;
    private String ptaxData;
    private BigDecimal valor;

    public DolarNuBank(BigDecimal ptax, String ptaxData) {
        this.ptax = ptax;
        this.ptaxData = ptaxData;
    }

    public BigDecimal getSpread() { return spread;    }
    public BigDecimal getPtax() {   return ptax;    }
    public String getPtaxData() {    return ptaxData;    }
    public BigDecimal getValor() {
        // Adicionado % de Spread sobre o dolar PTAX
       return getPtax().multiply(getSpread()).add(getPtax());
    }

    public void setPtax(BigDecimal ptax) {     this.ptax = ptax;     }
    public void setPtaxData(String ptaxData) {   this.ptaxData = ptaxData;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DolarNuBank that = (DolarNuBank) o;
        return Objects.equals(spread, that.spread) &&
                Objects.equals(ptax, that.ptax) &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(ptaxData, that.ptaxData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spread, ptax, ptaxData, valor);
    }
}
