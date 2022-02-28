package e.com.api.veiculos.api.veiculos.config;

import java.time.Instant;
import java.util.Arrays;
import e.com.api.veiculos.api.veiculos.domain.VeiculoDomain;
import e.com.api.veiculos.api.veiculos.domain.VeiculoStatus;
import e.com.api.veiculos.api.veiculos.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 	Simula uma interface Front-End, aonde os recursos da classe controladora são aplicados
*/

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {

    @Autowired // Injeção de Dependência do Repository
    private VeiculosRepository veiculosRepository;

    // Será executado tudo o que estiver neste método, assim que a aplicação for iniciada
    @Override
    public void run(String... args) throws Exception {

        // Domain Model
        // ISO 8601 para data e horário
        VeiculoDomain veiculo01 = new VeiculoDomain(null, "cruze", "chevrolet", 2014, "Preço: A partir de R$ 50.000", VeiculoStatus.UNSOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
        VeiculoDomain veiculo02 = new VeiculoDomain(null, "fiesta", "ford", 2004, "Preço: A partir de R$ 20.000", VeiculoStatus.SOLD, Instant.parse("2017-01-24T12:09:35Z"), null);
        VeiculoDomain veiculo03 = new VeiculoDomain(null, "novo uno", "fiat", 2012, "Preço: A partir de R$ 18.000", VeiculoStatus.SOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
        VeiculoDomain veiculo04 = new VeiculoDomain(null, "fusca", "volkswagen", 1972, "Preço: A partir de R$ 50.000", VeiculoStatus.UNSOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
        VeiculoDomain veiculo05 = new VeiculoDomain(null, "onix", "chevrolet", 2019, "Preço: A partir de R$ 60.000", VeiculoStatus.UNSOLD, Instant.parse("2018-03-09T10:04:21Z"), null);
        VeiculoDomain veiculo06 = new VeiculoDomain(null, "onix", "chevrolet", 2010, "Preço: A partir de R$ 20.000", VeiculoStatus.SOLD, Instant.parse("2009-03-09T10:04:21Z"), null);

        // Passando a list de objetos para inserção no banco de dados
        veiculosRepository.saveAll(Arrays.asList(
                veiculo01, veiculo02, veiculo03, veiculo04, veiculo05, veiculo06));
    }


}
