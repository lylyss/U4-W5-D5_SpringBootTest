package LobodaNicolae.U4_W5_D5_SpringBootTest.Repository;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    // Ricerca utente per username
    Optional<Utente> findByUsername(String username);

    // Ricerca utente per email
    Optional<Utente> findByEmail(String email);
}
