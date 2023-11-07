package crud;

import java.util.Scanner;
import dao.AeroportoDAO;
import models.Aeroportos;

public class AeroportosCRUD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		AeroportoDAO aeroportoDAO = new AeroportoDAO();
		
		int opcao = 0, id = 0; 
		
		String nome = "", cidade = "", pais = "";
		
		
		do {
			
			System.out.println("\n============================== Aeroportos =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a cidade:");
				cidade = s.nextLine();
				System.out.println("Digite o pais:");
				pais = s.nextLine();
				
				Aeroportos aeroporto1 = new Aeroportos(nome, cidade, pais);
				
				aeroportoDAO.create(aeroporto1);
				break;
			case 2:
				
				for (Aeroportos u : aeroportoDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a cidade:");
				cidade = s.nextLine();
				System.out.println("Digite o pais:");
				pais = s.nextLine();
				
				
				Aeroportos aeroporto2 = new Aeroportos(id, nome, cidade, pais);
				
				aeroportoDAO.update(aeroporto2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				aeroportoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Aeroportos aeroporto3 = aeroportoDAO.readById(id);
				
				System.out.println(aeroporto3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("volte sempre!");
		s.close();

	}
}
