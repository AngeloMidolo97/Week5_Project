package it.epicode.week4.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import it.epicode.week4.demo.config.PrenotazioneConfig;
import it.epicode.week4.demo.dao.PrenotazioneSrv;
import it.epicode.week4.demo.entity.Postazione;
import it.epicode.week4.demo.entity.Prenotazione;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}
	
	@Autowired
	PrenotazioneSrv ps;
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(PrenotazioneConfig.class);

	@Override
	public void run(String... args) throws Exception {
		
		//updateAll();
		getByType("OPENSPACE");
		//getBycity("roma");
		//insertPrenotazione();
		//getPrenotazioneById(1);
		
		((AnnotationConfigApplicationContext)ctx).close();
		
	}
	
	public void insertPrenotazione() {
		Prenotazione p = (Prenotazione)ctx.getBean("p1");
		ps.insert(p);
	}
	
	public void getPrenotazioneById(int id) {
		Optional<Prenotazione> pren = ps.getById(id);
		if(pren.isPresent()) {	
			Prenotazione prenotazione = pren.get(); 
			System.out.println(prenotazione);
		} else {
			System.out.println("Questo id non esiste");
		}
	}
	
	public void updateAll() {
//		ps.getAll().forEach(prenotazione -> {
//			int id = prenotazione.getId();
//			ps.update(id);
//		});
		for(int i = 0; i < ps.getAll().size(); i++) {
			ps.update(i);
			System.out.println("update");
		}
	}
	
	public void getByType(String tipo) {
		List<Postazione> post = ps.getByType(tipo);
		post.stream().forEach(p -> {
			System.out.println(p);
		});
	}
	
	public void getBycity(String city) {
		List<Postazione> post = ps.getByCity(city);
		post.stream().forEach(p -> {
			System.out.println(p);
		});
	}

}
