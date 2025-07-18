package LobodaNicolae.U4_W5_D5_SpringBootTest.Services;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Exceptions.NotFoundException;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    // Salva un nuovo utente o aggiorna uno esistente
    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }

    // Restituisce la lista di tutti gli utenti
    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    // Cerca un utente per ID, lancia eccezione se non trovato
    public Utente findById(Long id) {
        return utenteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Utente non trovato"));
    }

    // Elimina un utente tramite ID
    public void delete(Long id) {
        utenteRepository.deleteById(id);
    }
}


