package LobodaNicolae.U4_W5_D5_SpringBootTest.Services;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Postazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Prenotazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    /*
      Controlla se la prenotazione è valida:
      la postazione è libera per la data richiesta
      l'utente non ha già una prenotazione per quella data
     */
    //(naming convention)
    public boolean isPrenotazioneValida(Utente utente, Postazione postazione, LocalDate data) {
        boolean postazioneLibera = !prenotazioneRepository.existsByPostazioneAndData(postazione, data);
        boolean utenteLibero = !prenotazioneRepository.existsByUtenteAndData(utente, data);
        return postazioneLibera && utenteLibero;
    }
}
