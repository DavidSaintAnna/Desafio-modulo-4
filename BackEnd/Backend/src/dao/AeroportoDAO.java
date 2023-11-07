package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.Aeroportos;

public class AeroportoDAO {
	
		public void create(Aeroportos aeroporto) {

			String sql = "insert into Aeroportos (nome, cidade, pais) values (?, ?, ?)";
	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {
	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setString(1, aeroporto.getNome());
	            pstm.setString(2, aeroporto.getCidade());
	            pstm.setString(3, aeroporto.getPais());

	            pstm.execute();
	            
	            System.out.println("O Aeroporto foi cadastrado!");

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

	    // read
	    public List<Aeroportos> read() {
	        List<Aeroportos> aeroportos = new ArrayList<Aeroportos>();
	        String sql = "select * from Aeroportos";

	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            rset = pstm.executeQuery();

	            while (rset.next()) {
	                Aeroportos aeroporto = new Aeroportos();

	                aeroporto.setId(rset.getInt("id_aeroporto"));
	                aeroporto.setNome(rset.getString("nome"));
	                aeroporto.setCidade(rset.getString("cidade"));
	                aeroporto.setPais(rset.getString("pais"));

	                aeroportos.add(aeroporto);
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

	        return aeroportos;
	    }

	    // update
	    public void update(Aeroportos aeroporto) {
	        String sql = "UPDATE Aeroportos SET nome = ?, cidade = ?, pais = ?" + "WHERE id_aeroporto = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setString(1, aeroporto.getNome());
	            pstm.setString(2, aeroporto.getCidade());
	            pstm.setString(3, aeroporto.getPais());
	            pstm.setInt(4, aeroporto.getId());

	            pstm.execute();
	            
	            System.out.println("O Aeroporto foi atualizado!");

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

	    // delete
	    public void delete(int id) {
	        String sql = "DELETE FROM Aeroportos WHERE id_aeroporto = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;

	        try {

	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, id);

	            pstm.execute();
	            
	            System.out.println("O Aeroporto foi deletado!");

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

	    // readById
	    public Aeroportos readById(int id) {
	        Aeroportos aeroporto = new Aeroportos();
	        String sql = "select * from Aeroportos WHERE id_aeroporto = ?";

	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;

	        try {
	            conn = ConnectionFactory.createConnectionToMySQL();

	            pstm = conn.prepareStatement(sql);

	            pstm.setInt(1, id);

	            rset = pstm.executeQuery();

	            rset.next();

	            aeroporto.setId(rset.getInt("id_aeroporto"));
	            aeroporto.setNome(rset.getString("nome"));
	            aeroporto.setCidade(rset.getString("cidade"));
	            aeroporto.setPais(rset.getString("pais"));

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
	        return aeroporto;
	    }
	
}
