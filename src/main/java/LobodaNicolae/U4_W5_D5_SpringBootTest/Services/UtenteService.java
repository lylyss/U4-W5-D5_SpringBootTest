package LobodaNicolae.U4_W5_D5_SpringBootTest.Services;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }


}

