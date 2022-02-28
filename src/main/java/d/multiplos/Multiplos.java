package d.multiplos;

import lombok.Data;

@Data
public class Multiplos {
    public Integer getSomaDosMultiplos(Integer valor) {
        int soma = 0;
        for (int i = 1; i <= valor; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                soma += i;
            }
        }
        return soma;
    }
}
