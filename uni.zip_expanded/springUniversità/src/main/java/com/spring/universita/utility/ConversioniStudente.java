package com.spring.universita.utility;

import com.spring.universita.dto.studente.CognomeAnnoIscrizioneDTO;
import com.spring.universita.dto.studente.CognomeAnnoNascitaDTO;
import com.spring.universita.dto.studente.StudenteDTO;
import com.spring.universita.entity.Studente;

public class ConversioniStudente {

	public static Studente daStudenteDTOAStudente(StudenteDTO dto) {
		
		int matricola = dto.getMatricola();
		String nome = dto.getNome();
		String cognome = dto.getCognome();
		String indirizzo = dto.getIndirizzo();
		int annoNascita = dto.getAnnoNascita();
		int annoImmatricolazione = dto.getAnnoImmatricolazione();
		
		return new Studente(matricola, nome, cognome, indirizzo, annoNascita, annoImmatricolazione);
	}

	public static StudenteDTO daStudenteAStudenteDTO(Studente studente) {

		int matricola = studente.getMatricola();
		String nome = studente.getNome();
		String cognome = studente.getCognome();
		String indirizzo = studente.getIndirizzo();
		int annoNascita = studente.getAnnoNascita();
		int annoImmatricolazione = studente.getAnnoImmatricolazione();
		
		return new StudenteDTO(matricola, nome, cognome, indirizzo, annoNascita, annoImmatricolazione);
	}

	public static CognomeAnnoNascitaDTO daStudenteACognomeAnnoNascitaDTO(Studente stud) {
		
		String cognome = stud.getCognome();
		int annoNascita = stud.getAnnoNascita();
		
		return new CognomeAnnoNascitaDTO(cognome, annoNascita);
	}

	public static CognomeAnnoIscrizioneDTO daStudenteACognomeAnnoIscrizioneDTO(Studente stud) {
		
		String cognome = stud.getCognome();
		int annoImmatricolazione = stud.getAnnoImmatricolazione();
		
		return new CognomeAnnoIscrizioneDTO(cognome, annoImmatricolazione);
	}

}
