package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import factory.ConnectionFactory;
import models.Usuarios;
import models.Passagens;

public class UsuariosDAO {
	public void create(Usuarios usuario) {
		String sql = "insert into Usuarios(id_passagem, email, nome, senha)" + "VALUES(?,?,?,?)";
	    Connection conn = null;
	    PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, usuario.getPassagens().getId());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getNome());
			pstm.setString(4, usuario.getSenha());
			pstm.execute();
			System.out.println("Obrigado o Usuario foi cadastrado");

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
	public List<Usuarios> read() {
		PassagensDao passagemdao = new PassagensDao();
		String sql = "select * from Usuarios";
		List<Usuarios> Usuarios = new ArrayList<Usuarios>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {

		conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuarios usuario = new Usuarios();
				int id = rset.getInt("id_usuario");
				usuario.setId(id);
				int id_passagem = rset.getInt("id_passagem");
				Passagens passagem = passagemdao.readById(id_passagem);
				usuario.setPassagens(passagem);
				usuario.setEmail(rset.getString("email"));
				usuario.setNome(rset.getString("nome"));
				usuario.setSenha(rset.getString("senha"));
				Usuarios.add(usuario);
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

		return Usuarios;
	}
	 public void update(Usuarios usuario) {
	        String sql = "UPDATE Usuarios SET id_passagem = ?, email = ? , nome = ?, senha = ?" + "WHERE id_usuario = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, usuario.getPassagens().getId());
				pstm.setString(2, usuario.getEmail());
				pstm.setString(3, usuario.getNome());
				pstm.setString(4, usuario.getSenha());
				pstm.setInt(5, usuario.getId());

	            pstm.execute();
	            
	            System.out.println("O usuario foi atualizado!");

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
	        String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, id);

	            pstm.execute();
	            
	            System.out.println("O usuario foi deletado!");

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
	  public Usuarios readById(int id) {
	        Usuarios usuario = new Usuarios();
	        String sql = "select * from Usuarios WHERE id_usuario = ?";
	        PassagensDao passagemdao = new PassagensDao();
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {
	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, id);

	            rset = pstm.executeQuery();

	            rset.next();
	            usuario.setId(id);
				int id_passagem = rset.getInt("id_passagem");
				Passagens passagem = passagemdao.readById(id_passagem);
				usuario.setPassagens(passagem);
				usuario.setEmail(rset.getString("email"));
				usuario.setNome(rset.getString("nome"));
				usuario.setSenha(rset.getString("senha"));
				

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
	        return usuario;
	    }
	 
}
