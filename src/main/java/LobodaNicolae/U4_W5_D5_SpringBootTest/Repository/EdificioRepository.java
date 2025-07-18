package LobodaNicolae.U4_W5_D5_SpringBootTest.Repository;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    boolean existsByNome(String nome);

    List<Edificio> findByNomeContainingIgnoreCase(String nome);
}
