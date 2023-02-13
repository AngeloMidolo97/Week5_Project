package it.epicode.week4.demo.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.week4.demo.entity.Edificio;
import it.epicode.week4.demo.entity.Postazione;
import it.epicode.week4.demo.entity.Prenotazione;
import it.epicode.week4.demo.entity.StatoPrenotazione;
import it.epicode.week4.demo.entity.TipoPostazione;
import it.epicode.week4.demo.entity.Utente;

@Configuration
public class PrenotazioneConfig {
	
	@Bean
	public Edificio ed1() {
		Edificio ed = Edificio.builder()
				.nome("Epicode Tower")
				.indirizzo("Via del Corso, 30")
				.citta("Roma")
				.build();
		return ed;
	}
	
	@Bean
	public Utente u1() {
		Utente u = Utente.builder()
				.username("gerdiley")
				.fullName("Gerardo Di Letizia")
				.email("gerardo@gmail.com")
				.build();
		return u;
	}
	
	
	@Bean
	public Postazione post1() {
		Postazione post = Postazione.builder().tipoPostazione(TipoPostazione.OPENSPACE)
				.descrizione("Postazione in ambiente openspace")
				.capienza(20)
				.edificio(ed1())
				.libero(false)
				.build();
		return post;
	}
	
	
	@Bean
	@Scope("prototype")
	public Prenotazione p1() {
		Prenotazione p = Prenotazione.builder()
				.statoPrenotazione(StatoPrenotazione.INCORSO)
				.dataPrenotazione(LocalDate.now().minusDays(3))
				.postazione(post1())
				.utente(u1())
				.build();
				return p;
	}
	
}
