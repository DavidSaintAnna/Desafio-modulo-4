package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.Aeroportos;
import models.Passagens;

public class PassagensDao {
	public void create(Passagens passagem) {
		String sql = "insert into Passagens(id_aeroporto, nome, preco, data_de_saida, data_de_chegada, data_de_retorno)" + "VALUES(?,?,?,?,?,?)";
	    Connection conn = null;
	    PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, passagem.getAeroportos().getId());
			pstm.setString(2, passagem.getNome());
			pstm.setFloat(3, passagem.getPreco());
			pstm.setDate(4, new Date(passagem.getDataDeSaida().getTime()));
			pstm.setDate(5, new Date(passagem.getDataDeChegada().getTime()));
			pstm.setDate(6, new Date(passagem.getDataDeRetorno().getTime()));
			pstm.execute();
			System.out.println("Obrigado sua passagem foi cadastrada");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Passagens> read() {
		AeroportoDAO aeroportodao = new AeroportoDAO();
		String sql = "select * from Passagens";
		List<Passagens> Passagens = new ArrayList<Passagens>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {

		conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Passagens passagem = new Passagens();
				int id = rset.getInt("id_passagem");
				passagem.setId(id);
				int id_aeroporto = rset.getInt("id_aeroporto");
				Aeroportos aeroporto = aeroportodao.readById(id_aeroporto);
				passagem.setAeroportos(aeroporto);
				passagem.setNome(rset.getString("nome"));
				float preco = rset.getFloat("preco");
				Date data_de_saida = rset.getDate("data_de_saida");
				Date data_de_chegada = rset.getDate("data_de_chegada");
				Date data_de_retorno = rset.getDate("data_de_retorno");
				passagem.setPreco(preco);
				passagem.setDataDeSaida(data_de_saida);
				passagem.setDataDeChegada(data_de_chegada);
				passagem.setDataDeRetorno(data_de_retorno);

				Passagens.add(passagem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Passagens;
	}
	
	 public void update(Passagens passagem) {
	        String sql = "UPDATE Passagens SET id_aeroporto = ?, nome = ? , preco = ?, data_de_saida = ?, data_de_chegada = ?, data_de_retorno = ?" + "WHERE id_passagem = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, passagem.getAeroportos().getId());
				pstm.setString(2, passagem.getNome());
				pstm.setFloat(3, passagem.getPreco());
				pstm.setDate(4, new Date(passagem.getDataDeSaida().getTime()));
				pstm.setDate(5, new Date(passagem.getDataDeChegada().getTime()));
				pstm.setDate(6, new Date(passagem.getDataDeRetorno().getTime()));
				pstm.setInt(7, passagem.getId());

	            pstm.execute();
	            
	            System.out.println("A Passagem foi atualizada !");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pstm != null) {
	                    pstm.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	    }
	 
	  public void delete(int id) {
	        String sql = "DELETE FROM Passagens WHERE id_passagem = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, id);

	            pstm.execute();
	            
	            System.out.println("A passagem foi deletada!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pstm != null) {
	                    pstm.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	    }
	  
	  public Passagens readById(int id) {
	        Passagens passagem = new Passagens();
	        String sql = "select * from Passagens WHERE id_passagem = ?";
	        AeroportoDAO aeroportodao = new AeroportoDAO();

	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {
	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, id);

	            rset = pstm.executeQuery();

	            rset.next();
	            passagem.setId(id);
				int id_aeroporto = rset.getInt("id_aeroporto");
				Aeroportos aeroporto = aeroportodao.readById(id_aeroporto);
				passagem.setAeroportos(aeroporto);
				passagem.setNome(rset.getString("nome"));
				float preco = rset.getFloat("preco");
				Date data_de_saida = rset.getDate("data_de_saida");
				Date data_de_chegada = rset.getDate("data_de_chegada");
				Date data_de_retorno = rset.getDate("data_de_retorno");
				passagem.setPreco(preco);
				passagem.setDataDeSaida(data_de_saida);
				passagem.setDataDeChegada(data_de_chegada);
				passagem.setDataDeRetorno(data_de_retorno);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pstm != null) {
	                    pstm.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return passagem;
	    }
		
	}


