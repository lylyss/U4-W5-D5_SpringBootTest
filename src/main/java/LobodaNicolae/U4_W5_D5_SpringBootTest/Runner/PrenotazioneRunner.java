package LobodaNicolae.U4_W5_D5_SpringBootTest.Runner;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Edificio;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Postazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Enums.TipoPostazione;
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

        Edificio edificio2 = edificioService.save(Edificio.builder()
                .nome("Tech Hub")
                .indirizzo("Via Innovazione 55")
                .citta("Milano")
                .build());

        // Crea utente
        Utente utente = utenteService.save(Utente.builder()
                .username("mario001")
                .nome_completo("Mario Balotelli")
                .email("mario.balotelli@gmail.com")
                .build());

        Utente utente2 = utenteService.save(Utente.builder()
                .username("luigi002")
                .nome_completo("Luigi Valentini")
                .email("luiggi.valentini@gmail.com")
                .build());

        Utente utente3 = utenteService.save(Utente.builder()
                .username("anna003")
                .nome_completo("Anna Marini")
                .email("annamarini@gmail.com")
                .build());

        Utente utente4 = utenteService.save(Utente.builder()
                .username("carlo004")
                .nome_completo("Carlo Cipolle")
                .email("carlocipolle@gmail.com")
                .build());

        // Crea postazione
        Postazione postazione = postazioneService.save(Postazione.builder()
                .codice("POST01")
                .descrizione("Open space con vista parco")
                .tipo(TipoPostazione.OPENSPACE)
                .max_occupanti(8)
                .edificio(edificio)
                .build());

        Postazione postazione2 = postazioneService.save(Postazione.builder()
                .codice("POST02")
                .descrizione("Ufficio privato con scrivania")
                .tipo(TipoPostazione.PRIVATO)
                .max_occupanti(1)
                .edificio(edificio2)
                .build());

        Postazione postazione3 = postazioneService.save(Postazione.builder()
                .codice("POST03")
                .descrizione("Sala riunioni con proiettore")
                .tipo(TipoPostazione.SALA_RIUNIONI)
                .max_occupanti(10)
                .edificio(edificio2)
                .build());

    }
}
