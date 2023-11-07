package crud;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.UsuariosDAO;
import dao.ComentariosDAO;
import models.Usuarios;
import models.Comentarios;


public class ComentariosCRUD {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ComentariosDAO comentarioDAO = new ComentariosDAO();
		UsuariosDAO usuarioDAO = new UsuariosDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		int opcao, id, id_usuario; 
		Date data_de_publicacao = new Date();
		
		String comentario, datapublicada;
		
		
		do {
			
			System.out.println("\n============================== Comentarios  =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o comentario:");
				comentario = s.nextLine();
				System.out.println("Digite a data publicada:");
				datapublicada = s.nextLine();
				System.out.println("Digite o id do Usuario:");
				id_usuario = s.nextInt();
				Usuarios usuario = usuarioDAO.readById(id_usuario);
				try {
					data_de_publicacao = sdf.parse(datapublicada);

				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				comentarioDAO.create(new Comentarios( comentario,data_de_publicacao, usuario));
				break;
			case 2:
				
				for (Comentarios u : comentarioDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o comentario:");
				comentario = s.nextLine();
				System.out.println("Digite a data de publicacao:");
				datapublicada = s.nextLine();
				System.out.println("Digite o id do Usuario:");
				id_usuario = s.nextInt();
				Usuarios usuario1 = usuarioDAO.readById(id_usuario);
				try {
					data_de_publicacao = sdf.parse(datapublicada);
					
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				comentarioDAO.update(new Comentarios( id,comentario, data_de_publicacao, usuario1));				
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				comentarioDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				Comentarios comentado = comentarioDAO.readById(id);
				System.out.println(comentado.toString());
				break;
			default:
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("volte sempre!");
		s.close();

	}
}
