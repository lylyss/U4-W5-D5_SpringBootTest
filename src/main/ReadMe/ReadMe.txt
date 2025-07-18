^^^^^^^^^^^^^^^ READ ME ^^^^^^^^^^^^^^^^^

Ho realizzato un'applicazione Spring Boot per la gestione delle prenotazioni delle postazioni aziendali.
Il progetto gestisce edifici, postazioni, utenti e prenotazioni, con vincoli di unicità e regole di business (ad esempio, un utente non può prenotare più di una postazione per la stessa data).

Ho implementato il modello dati tramite le entity JPA (Edificio, Postazione, Utente, Prenotazione) e la persistenza con Spring Data JPA, creando le repository
e i service necessari. Ho aggiunto un runner per popolare il database e testare le funzionalità principali.

Durante lo sviluppo ho incontrato alcune difficoltà, come errori di mapping JPA dovuti a import sbagliati, problemi di compilazione per mancata ricompilazione
dopo modifiche ai service, e la gestione delle eccezioni quando si cercano entità non presenti nel database. Ho risolto questi problemi ricompilando il progetto,
correggendo gli import e migliorando la gestione degli errori nei service e nel runner.

L'applicazione ora funziona correttamente: le prenotazioni vengono create solo se rispettano i vincoli richiesti e i dati vengono gestiti in modo robusto.
Sono soddisfatto del risultato .
