package LobodaNicolae.U4_W5_D5_SpringBootTest.Services;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Postazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    // Salva una nuova entità Postazione nel database
    public Postazione save(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }


}

