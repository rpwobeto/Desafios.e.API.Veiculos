package e.com.api.veiculos.api.veiculos.repository;

import e.com.api.veiculos.api.veiculos.domain.VeiculoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VeiculosRepository extends JpaRepository<VeiculoDomain, Long> {
    // JPQL do JPA
    // Busca veículos não vendidos
    @Query("SELECT obj "
            + "FROM Car obj "
            + "WHERE obj.sold = false "
            + "ORDER BY obj.vehicle ASC "
    )
    List<VeiculoDomain> findByUnsold();

    // Busca somente veículos vendidos
    @Query("SELECT obj "
            + "FROM Car obj "
            + "WHERE obj.sold = true "
            + "ORDER BY obj.vehicle ASC "
    )
    List<VeiculoDomain> findBySold();

    // Busca veículos por fabricante
    @Query("SELECT obj "
            + "FROM Car obj "
            + "WHERE obj.brand = :brand "
            + "ORDER BY obj.vehicle ASC "
    )
    List<VeiculoDomain> findByBrand(String brand);
}
