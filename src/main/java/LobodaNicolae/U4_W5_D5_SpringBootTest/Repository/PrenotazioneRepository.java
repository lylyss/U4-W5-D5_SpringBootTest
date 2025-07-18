package LobodaNicolae.U4_W5_D5_SpringBootTest.Repository;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Postazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Prenotazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

// Interfaccia repository per l'entità Prenotazione, estende Jpa Repository per  operazioni CRUD di base
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    // Questo metodo verifica se esiste già una prenotazione per una determinata postazione in una data specifica.
    // Restituisce true se almeno una prenotazione con la postazione e la data fornite e presente nel database, altrimenti falso.
    // in caso per evitare prenotazioni doppie sulla stessa postazione nello stesso giorno.
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);

    // la verifica se esiste una prenotazione per un utente e una data specifica
    boolean existsByUtenteAndData(Utente utente, LocalDate data);

    // Recupera tutte le prenotazioni asociate a un determinato utente
    List<Prenotazione> findByUtente(Utente utente);
}
