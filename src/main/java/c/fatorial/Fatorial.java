package c.fatorial;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Fatorial {

    public BigDecimal getFatorial(BigDecimal numero) {
        if (numero.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo");
        } else if (numero.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            return numero.multiply(getFatorial(numero.subtract(BigDecimal.ONE)));
        }
    }
}
