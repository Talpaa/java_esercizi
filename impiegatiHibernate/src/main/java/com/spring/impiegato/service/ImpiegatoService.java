package com.spring.impiegato.service;

import java.util.List;

import com.spring.impiegato.dto.ImpiegatoDTO;
import com.spring.impiegato.dto.ImpiegatoNomeCognomeDTO;

public interface ImpiegatoService {

	//Assumi nuovo impiegato
	public boolean assumi(ImpiegatoDTO dto);

	//Assumi nuovi impiegati
	public List<ImpiegatoDTO> assumiInBlocco(List<ImpiegatoDTO> impiegatiDTO);

	//Cerca impiegato per matricola
	public ImpiegatoDTO cerca(int matricola);

	//Visualizza tutti gli impiegati
	public List<ImpiegatoDTO> visualizza();

	//Cancella un impiegato tramite la matricola e ritornalo
	public ImpiegatoDTO licenzia(int matricola);

	//Modifica il salario di un impiegato esistente (passando la matricola e il nuovo salario) e ritorna l’impiegato aggiornato
	public ImpiegatoDTO modificaSalario(int matricola, Double newSalario);

	
	  ////////////////
	 ////AVANZATE////
	////////////////
	
	//Cancella un impiegato tramite la matricola e torna solo nome e cognome
	public ImpiegatoNomeCognomeDTO licenziaNomeCognome(int matricola);
	
	//Visualizza la lista dei nominativi (nome e cognome) degli impiegati
	public List<ImpiegatoNomeCognomeDTO> visualizzaNomeCognome();
	
	//Visualizza tutti gli impiegati col salario maggiore di un valore specificato
	public List<ImpiegatoDTO> visualizzaSalari(Double salario);

	//Visualizza tutti gli impiegati ordinati per cognome
	public List<ImpiegatoDTO> ordinaCognomi();
	
	//Visualizza tutti gli impiegati ordinati per salario
	public List<ImpiegatoDTO> ordinaSalari();
}
