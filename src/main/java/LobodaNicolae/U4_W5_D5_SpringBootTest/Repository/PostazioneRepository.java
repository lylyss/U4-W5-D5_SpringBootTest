package LobodaNicolae.U4_W5_D5_SpringBootTest.Repository;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Postazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    //  le postazioni in base al tipo e alla città dell'edificio associato
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

    Optional<Postazione> findByCodice(String codice);
}
