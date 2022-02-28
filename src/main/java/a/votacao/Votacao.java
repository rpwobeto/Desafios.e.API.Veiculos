package a.votacao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Votacao {

    Double votosValidos;
    Double votosBrancos;
    Double votosNulos;
    Double totalEleitores;

    public Votacao() {
        this.setTotalEleitores(Double.parseDouble("5000"));
        this.setVotosValidos(Double.valueOf(4000));
        this.setVotosBrancos(600d);
        this.setVotosNulos(Double.valueOf("400"));
    }

    public Double getPercentualVotosValidos () {
        return this.getVotosValidos() / this.getTotalEleitores();
    }

    public Double getPercentualVotosBrancos () {
        return this.getVotosBrancos() / this.getTotalEleitores();
    }

    public Double getPercentualVotosNulos () {
        return this.getVotosNulos() / this.getTotalEleitores();
    }


}
