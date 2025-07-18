package LobodaNicolae.U4_W5_D5_SpringBootTest.Services;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Postazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Enums.TipoPostazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Exceptions.NotFoundException;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    // Salva una nuova entità Postazione nel database
    public Postazione save(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    // Restituisce tutte le entità Postazione presenti nel database
    public List<Postazione> findAll() {
        return postazioneRepository.findAll();
    }

    // Cerca una Postazione per id
    public Postazione findById(Long id) {
        return postazioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Postazione non trovata"));
    }

    // Elimina una Postazione dal database tramite id
    public void delete(Long id) {
        postazioneRepository.deleteById(id);
    }

    // Restituisce una lista di Postazione filtrate per tipo e città dell'edificio
    public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

    public Postazione findByCodice(String post03) {
        return postazioneRepository.findByCodice(post03)
                .orElseThrow(() -> new NotFoundException("Postazione con codice " + post03 + " non trovata"));
    }
}

