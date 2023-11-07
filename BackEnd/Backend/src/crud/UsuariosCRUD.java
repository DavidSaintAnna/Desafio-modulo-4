package crud;


import java.util.Scanner;


import dao.PassagensDao;
import dao.UsuariosDAO;
import models.Passagens;
import models.Usuarios;

public class UsuariosCRUD {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		UsuariosDAO usuarioDAO = new UsuariosDAO();
		PassagensDao passagemDao = new PassagensDao();
		
		int opcao, id, id_passagem; 
		
		String nome, email, senha;
		
		
		do {
			
			System.out.println("\n============================== Usuarios  =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				System.out.println("Digite o id da passagem:");
				id_passagem = s.nextInt();
				Passagens passagem = passagemDao.readById(id_passagem);
				usuarioDAO.create(new Usuarios(nome,email,senha,passagem));
				break;
			case 2:
				
				for (Usuarios u : usuarioDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				System.out.println("Digite o id da passagem:");
				id_passagem = s.nextInt();
				Passagens passagem1 = passagemDao.readById(id_passagem);
				usuarioDAO.update(new Usuarios( id,nome, email, senha, passagem1));				
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				usuarioDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Usuarios usuario = usuarioDAO.readById(id);
				System.out.println(usuario.toString());
				break;
			default:
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("volte sempre!");
		s.close();

	}

}
