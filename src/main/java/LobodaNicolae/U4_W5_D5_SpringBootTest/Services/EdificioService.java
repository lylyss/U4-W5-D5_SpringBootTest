package LobodaNicolae.U4_W5_D5_SpringBootTest.Services;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Edificio;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Exceptions.NotFoundException;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired // Inietta automaticamente l'istanza di EdificioRepository
    private EdificioRepository edificioRepository;

    // Salva un nuovo edificio o aggiorna uno esistente
    public Edificio save(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    // Restituisce la lista di tutti gli edifici
    public List<Edificio> findAll() {
        return edificioRepository.findAll();
    }

    // Cerca un edificio per ID, lancia un'eccezione se non trovato
    public Edificio findById(Long id) {
        return edificioRepository.findById(id).orElseThrow(() -> new NotFoundException("Edificio non trovato"));
    }

    // Elimina un edificio tramite ID
    public void delete(Long id) {
        edificioRepository.deleteById(id);
    }
}

