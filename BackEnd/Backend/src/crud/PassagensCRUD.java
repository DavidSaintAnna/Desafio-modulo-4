package crud;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.AeroportoDAO;
import dao.PassagensDao;
import models.Aeroportos;
import models.Passagens;
public class PassagensCRUD {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		PassagensDao passagemDao = new PassagensDao();
		AeroportoDAO aeroportoDAO = new AeroportoDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		int opcao, id, id_aeroporto; 
		Date data_de_saida = new Date();
		Date data_de_chegada = new Date();
		Date data_de_retorno = new Date();
		
		String nome, datasaida, datachegada,dataretorno;
		float preco;
		
		
		do {
			
			System.out.println("\n============================== Passagens  =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o preco:");
				preco = s.nextFloat();
				s.nextLine();
				System.out.println("Digite a data de saida:");
				datasaida = s.nextLine();
				System.out.println("Digite a data de chegada:");
				datachegada = s.nextLine();
				System.out.println("Digite a data de retorno:");
				dataretorno = s.nextLine();
				System.out.println("Digite o id do aeroporto:");
				id_aeroporto = s.nextInt();
				Aeroportos aeroporto = aeroportoDAO.readById(id_aeroporto);
				try {
					data_de_saida = sdf.parse(datasaida);
					data_de_chegada = sdf.parse(datachegada);
					data_de_retorno = sdf.parse(dataretorno);
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				passagemDao.create(new Passagens( nome, data_de_chegada, data_de_saida, data_de_retorno,aeroporto, preco));
				break;
			case 2:
				
				for (Passagens u : passagemDao.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite o preco:");
				preco = s.nextFloat();
				s.nextLine();
				System.out.println("Digite a data de saida:");
				datasaida = s.nextLine();
				System.out.println("Digite a data de chegada:");
				datachegada = s.nextLine();
				System.out.println("Digite a data de retorno:");
				dataretorno = s.nextLine();
				System.out.println("Digite o id do aeroporto:");
				id_aeroporto = s.nextInt();
				Aeroportos aeroporto1 = aeroportoDAO.readById(id_aeroporto);
				try {
					data_de_saida = sdf.parse(datasaida);
					data_de_chegada = sdf.parse(datachegada);
					data_de_retorno = sdf.parse(dataretorno);
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				passagemDao.update(new Passagens( id,nome, data_de_chegada, data_de_saida, data_de_retorno,aeroporto1, preco));				
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				passagemDao.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Passagens passagem = passagemDao.readById(id);
				System.out.println(passagem.toString());
				break;
			default:
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("volte sempre!");
		s.close();

	}
}
