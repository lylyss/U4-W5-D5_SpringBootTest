package LobodaNicolae.U4_W5_D5_SpringBootTest.Repository;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
