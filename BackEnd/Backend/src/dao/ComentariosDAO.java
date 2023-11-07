package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.Usuarios;
import models.Comentarios;



public class ComentariosDAO {


	public void create(Comentarios comentado) {
		String sql = "insert into Comentarios(id_usuario, comentario,data_de_publicacao)" + "VALUES(?,?,?)";
	    Connection conn = null;
	    PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, comentado.getUsuarios().getId());
			pstm.setString(2, comentado.getComentario());
			pstm.setDate(3, new Date(comentado.getData_de_publicacao().getTime()));
			pstm.execute();
			System.out.println("Obrigado seu comentario foi cadastrado");

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

	public List<Comentarios> read() {
		UsuariosDAO usuarioDAO = new UsuariosDAO();
		String sql = "select * from Comentarios";
		List<Comentarios> Comentarios = new ArrayList<Comentarios>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {

		conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Comentarios comentado = new Comentarios();
				int id = rset.getInt("id_comentario");
				comentado.setId(id);
				int id_usuario = rset.getInt("id_usuario");
				Usuarios usuario = usuarioDAO.readById(id_usuario);
				comentado.setUsuarios(usuario);
				comentado.setComentario(rset.getString("comentario"));
				Date data_de_publicacao = rset.getDate("data_de_publicacao");
				comentado.setData_de_publicacao(data_de_publicacao);

				Comentarios.add(comentado);
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

		return Comentarios;
	}
	 public void update(Comentarios comentado) {
	        String sql = "UPDATE Comentarios SET id_usuario = ?, comentario = ?, data_de_publicacao = ?" + "WHERE id_comentario = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, comentado.getUsuarios().getId());
				pstm.setString(2, comentado.getComentario());
				pstm.setDate(3, new Date(comentado.getData_de_publicacao().getTime()));
				pstm.setInt(4, comentado.getId());

	            pstm.execute();
	            
	            System.out.println("O comentario foi atualizado !");

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
	        String sql = "DELETE FROM Comentarios WHERE id_comentario = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, id);

	            pstm.execute();
	            
	            System.out.println("O comentario foi deletado!");

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
	  public Comentarios readById(int id) {
	        Comentarios comentado = new Comentarios();
	        String sql = "select * from Comentarios WHERE id_comentario = ?";
	        UsuariosDAO usuarioDAO = new UsuariosDAO();

	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {
	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, id);

	            rset = pstm.executeQuery();

	            rset.next();
	            comentado.setId(id);
				int id_usuario = rset.getInt("id_usuario");
				Usuarios usuario = usuarioDAO.readById(id_usuario);
				comentado.setUsuarios(usuario);
				comentado.setComentario(rset.getString("comentario"));
				Date data_de_publicacao = rset.getDate("data_de_publicacao");
				comentado.setData_de_publicacao(data_de_publicacao);

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
	        return comentado;
	    }
	 
}
