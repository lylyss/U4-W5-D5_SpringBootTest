package LobodaNicolae.U4_W5_D5_SpringBootTest.Runner;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Edificio;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Services.EdificioService;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Services.PostazioneService;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Services.PrenotazioneService;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        // Crea edificio
        Edificio edificio = edificioService.save(Edificio.builder()
                .nome("Business Center")
                .indirizzo("Viale del lavoro 123")
                .citta("Verona")
                .build());

        // Crea utente
        Utente utente = utenteService.save(Utente.builder()
                .username("mario001")
                .nome_completo("Mario Balotelli")
                .email("mario.balotelli@gmail.com")
                .build());


    }
}

