package com.spring.apprubrica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.apprubrica.entity.Contatto;
import com.spring.apprubrica.entity.Rubrica;

@Repository
public class DAOAppRubricaMappaImpl implements DAOAppRubrica {

	private Map<Integer, Rubrica> mappa = new HashMap<>();

	public void chiudiConnessione(ResultSet risultato, Statement stm, PreparedStatement prep, Connection conn) {

		try {

			// PUNTO 7 : chiudo la connessione 
			if(risultato != null) {
				risultato.close();
			}
			
			if(stm != null) {
				stm.close();
			}
			
			if(prep != null) {
				prep.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			//return true;
		} catch (Exception e) {
			throw new RuntimeException("Errore di connessione.....");
		}
	}
	
	public Connection avviaConnessione() {

		try {

			// PUNTO 1 : Carico i driver in memoria
			String driver = "org.postgresql.Driver";
			Class.forName(driver);

			// PUNTO 2 : Creo url di connessione
			String url = "jdbc:postgresql://localhost:5432/AppRubrica?user=postgres&password=postgres&ssl=false";

			// PUNTO 3 : Connetto al database
			return DriverManager.getConnection(url);
		} catch (Exception e) {
			throw new RuntimeException("Errore di connessione.....");
		}
	}
	
	 ///////////////
	//DAO RUBRICA//
   ///////////////

	public boolean insert(Rubrica rubrica) {
		Connection conn = avviaConnessione();
		String miaquery = "INSERT INTO rubrica (id, proprietario, anno) VALUES(?,?,?);";
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement(miaquery);
			prep.setInt(1, rubrica.getId());
			prep.setString(2, rubrica.getProprietario());
			prep.setInt(3, rubrica.getAnno());
			// PUNTO 5 : eseguire la QUERY
			prep.execute();
		} catch (SQLException e) {
			throw new RuntimeException("ID già presente");
		} finally {
			chiudiConnessione(null, null, prep, conn);
		}
		return true;
	}

	public List<Rubrica> selectAll() {

		ArrayList<Rubrica> rubriche = new ArrayList<>(mappa.values());

		Connection conn = avviaConnessione();
		String miaQuery1 = "SELECT * from rubrica;";
		String miaQuery2 = "SELECT * FROM contatto WHERE rubrica_id = ?";
		PreparedStatement prep = null;
		ResultSet result = null;
		

		try {
			prep = conn.prepareStatement(miaQuery1);
			result = prep.executeQuery();

			while (result.next()) {
				Integer id = result.getInt("id");
				String proprietario = result.getString("proprietario");
				Integer anno = result.getInt("anno");

				Map<Integer, Contatto> contatti = new HashMap<>();
				ResultSet rs = null;
				PreparedStatement stmt = null;

				try {
					stmt = conn.prepareStatement(miaQuery2);
	
					stmt.setInt(1, id); // Sostituisce il ? con il valore di id
					rs = stmt.executeQuery();
	
					while (rs.next()) {
						// Leggi i dati dal ResultSet
						Integer contattoId = rs.getInt("id");
						String nome = rs.getString("nome");
						String cognome = rs.getString("cognome");
						Integer numero = rs.getInt("numero");
						String gruppo = rs.getString("gruppo_di_appartenenza");
						Date annoCont = new Date(rs.getDate("anno_nascita").getTime());
						Boolean preferito = rs.getBoolean("preferito");
						Contatto contatto = new Contatto(contattoId, nome, cognome, numero, gruppo, annoCont, preferito);
	
						contatti.put(contattoId, contatto);
					}
	
					rubriche.add(new Rubrica(id, proprietario, anno, contatti));
				}catch(Exception e) {
					System.out.println(e);
					throw new RuntimeException("Errore....");
				}finally {
					chiudiConnessione(rs, null, stmt, null);
				}

			}

			return rubriche;

		} catch (Exception e) {
			throw new RuntimeException("Errore.....");
		} finally {
			chiudiConnessione(result, null, prep, conn);
		}
	}

	public Rubrica selectById(Integer idRubrica) {

		Connection conn = avviaConnessione();
		String miaQuery1 = "select * from rubrica WHERE id = ?;";
		String miaQuery2 = "SELECT * FROM contatto WHERE rubrica_id = ?";
		PreparedStatement prep = null;
		ResultSet result = null;

		try {

			prep = conn.prepareStatement(miaQuery1);
			prep.setInt(1, idRubrica);
			result = prep.executeQuery();

			if (result.next()) {

				Integer id = result.getInt("id");
				String proprietario = result.getString("proprietario");
				Integer anno = result.getInt("anno");

				Map<Integer, Contatto> contatti = new HashMap<>();
				ResultSet rs = null;
				PreparedStatement stmt = null;
				
				try {
					stmt = conn.prepareStatement(miaQuery2);
	
					stmt.setInt(1, id); // Sostituisce il ? con il valore di id
					rs = stmt.executeQuery();
	
					while (rs.next()) {
						// Leggi i dati dal ResultSet
						Integer contattoId = rs.getInt("id");
						String nome = rs.getString("nome");
						String cognome = rs.getString("cognome");
						Integer numero = rs.getInt("numero");
						String gruppo = rs.getString("gruppo_di_appartenenza");
						
						System.out.println(rs.getDate("anno_nascita"));
						Date annoCont = new Date(rs.getDate("anno_nascita").getTime());
						
						Boolean preferito = rs.getBoolean("preferito");
						Contatto contatto = new Contatto(contattoId, nome, cognome, numero, gruppo, annoCont, preferito);
	
						contatti.put(contattoId, contatto);
					}
				}catch(Exception e) {
					System.out.println(e);
					throw new RuntimeException("Errore....");
				}finally {
					chiudiConnessione(rs, null, stmt, null);
				}

				return new Rubrica(id, proprietario, anno, contatti);
			}else {
				throw new RuntimeException("Nessuna rubrica associata a questo ID.");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException("Nessuna rubrica associata a questo ID.");
		} finally {
			chiudiConnessione(result, null, prep, conn);
		}

	}

	public boolean delete(Integer idRubrica) {
		
		Connection conn = avviaConnessione();
		String miaQuery = "DELETE FROM rubrica WHERE id = ?;";
		PreparedStatement prep = null;
		
		try {

			prep = conn.prepareStatement(miaQuery);
			prep.setInt(1, idRubrica);
			Integer num = prep.executeUpdate();
			
			if(num == 1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println(e);
			throw new RuntimeException("Nessuna rubrica associata a questo ID.");
		} finally {
			chiudiConnessione(null, null, prep, conn);
		}
	}

	public boolean update(Rubrica rubrica) {
		if (rubrica != null) {
			
			Connection conn = avviaConnessione();
			String miaQuery = "UPDATE public.rubrica SET proprietario=?, anno=? WHERE id = ?;";
			PreparedStatement prep = null;
			
			try {

				prep = conn.prepareStatement(miaQuery);
				prep.setString(1, rubrica.getProprietario());
				prep.setInt(2, rubrica.getAnno());
				prep.setInt(3, rubrica.getId());
				Integer num = prep.executeUpdate();
				
				if(num == 1) {
					return true;
				}else {
					return false;
				}
				
			}catch(Exception e) {
				System.out.println(e);
				throw new RuntimeException("Nessuna rubrica associata a questo ID.");
			} finally {
				chiudiConnessione(null, null, prep, conn);
			}
			
		}
		throw new RuntimeException("ID non presente, impossibile modificare la rubrica"); // La rubrica non esiste,
																						 // quindi non può essere
																						// aggiornata
	}
	
	  ////////////////
	 //DAO CONTATTO//
	////////////////
	
	public boolean insert(Integer rubricaId, Contatto contatto) {
		Connection conn = avviaConnessione();
		String miaquery = "INSERT INTO public.contatto(\r\n"
				+ "	id, rubrica_id, nome, cognome, numero, gruppo_di_appartenenza, anno_nascita, preferito)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement(miaquery);
			prep.setInt(1, contatto.getId());
			prep.setInt(2, rubricaId);
			prep.setString(3, contatto.getNome());
			prep.setString(4, contatto.getCognome());
			prep.setInt(5, contatto.getNumero());
			prep.setString(6, contatto.getGruppoDiAppartenenza());
			prep.setDate(7, new java.sql.Date(contatto.getAnnoNascita().getTime()));
			prep.setBoolean(8, contatto.getPreferito());
			// PUNTO 5 : eseguire la QUERY
			prep.execute();
		} catch (SQLException e) {
			throw new RuntimeException("ID già presente");
		} finally {
			chiudiConnessione(null, null, prep, conn);
		}
		return true;
	}
}
