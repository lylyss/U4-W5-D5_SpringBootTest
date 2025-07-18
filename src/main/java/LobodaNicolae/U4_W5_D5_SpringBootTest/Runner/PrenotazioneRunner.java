package LobodaNicolae.U4_W5_D5_SpringBootTest.Runner;

import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Edificio;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Postazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Prenotazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Entities.Utente;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Enums.TipoPostazione;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Services.EdificioService;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Services.PostazioneService;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Services.PrenotazioneService;
import LobodaNicolae.U4_W5_D5_SpringBootTest.Services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        System.out.println("Edificio creato: " + edificio);

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

        System.out.println("Utente creato: " + utente);

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
        System.out.println("Postazione creata: " + postazione);

        //Data della prenotazione
        LocalDate dataPrenotazione = LocalDate.now();

        // Verifica se la prenotazione è valida
        if (prenotazioneService.isPrenotazioneValida(utente, postazione, dataPrenotazione)) {
            Prenotazione prenotazione = prenotazioneService.save(Prenotazione.builder()
                    .utente(utente)
                    .postazione(postazione)
                    .data(dataPrenotazione)
                    .build());
            System.out.println("Prenotazione effettuata: " + prenotazione);
        } else {
            System.out.println("Prenotazione non valida: postazione occupata o utente già prenotato per questa data.");
        }
        //funzionante
        // Prova a fare una seconda prenotazione per lo stesso utente e data (deve fallire)
        if (prenotazioneService.existsByUtenteAndData(utente, dataPrenotazione)) {
            System.out.println("L'utente ha già una prenotazione per questa data.");
        } else if (prenotazioneService.existsByPostazioneAndData(postazione, dataPrenotazione)) {
            System.out.println("La postazione è già prenotata per questa data.");
        } else if (prenotazioneService.isPrenotazioneValida(utente, postazione, dataPrenotazione)) {
            Prenotazione prenotazione2 = prenotazioneService.save(Prenotazione.builder()
                    .utente(utente)
                    .postazione(postazione)
                    .data(dataPrenotazione)
                    .build());
            System.out.println("Prenotazione effettuata: " + prenotazione2);
        } else {
            System.out.println("Seconda prenotazione non valida: regola rispettata.");
        }
    }

}

