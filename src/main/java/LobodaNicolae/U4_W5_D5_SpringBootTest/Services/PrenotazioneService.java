package LobodaNicolae.U4_W5_D5_SpringBootTest.Services;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Postazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Prenotazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Exceptions.NotFoundException;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById(Long id) {
        return prenotazioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prenotazione non trovata"));
    }

    public void delete(Long id) {
        prenotazioneRepository.deleteById(id);
    }

    public boolean existsByPostazioneAndData(Postazione postazione, LocalDate data) {
        return prenotazioneRepository.existsByPostazioneAndData(postazione, data);
    }

    public boolean existsByUtenteAndData(Utente utente, LocalDate data) {
        return prenotazioneRepository.existsByUtenteAndData(utente, data);
    }

    public List<Prenotazione> findByUtente(Utente utente) {
        return prenotazioneRepository.findByUtente(utente);
    }

    /*
     * Controlla se la prenotazione è valida:
     * la postazione è libera per la data richiesta
     * l'utente non ha già una prenotazione per quella data
     */
    public boolean isPrenotazioneValida(Utente utente, Postazione postazione, LocalDate data) {
        boolean postazioneLibera = !prenotazioneRepository.existsByPostazioneAndData(postazione, data);
        boolean utenteLibero = !prenotazioneRepository.existsByUtenteAndData(utente, data);
        return postazioneLibera && utenteLibero;
    }
}
