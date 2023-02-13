package it.epicode.week4.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Prenotazione {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private LocalDate dataPrenotazione;
	
	@Enumerated(EnumType.STRING)
	private StatoPrenotazione statoPrenotazione = StatoPrenotazione.INCORSO;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="id_postazione", referencedColumnName = "id")
	private Postazione postazione;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="id_utente", referencedColumnName = "id")
	private Utente utente;
}
