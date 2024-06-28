package banco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("================ MENU ================" +
				"\n[1] Depositar" +
				"\n[2] Sacar" +
				"\n[3] Extrato" +
				"\n[4] Nova conta" +
				"\n[5] Listar contas" +
				"\n[6] Novo cliente" +
				"\n[7] Sair" );
		
		 int opcao = scanner.nextInt();
		
		//System.out.println("Opção: " + opcao);
		
		while(opcao != 7) {
			ArrayList<Integer> contas = new ArrayList<>();  
			
			if(opcao == 1) {
				
			}
			else if(opcao == 2) {
				
			}
			else if(opcao == 3) {
				
			}
			else if(opcao == 4) {
							
			}
			else if(opcao == 5) {	
				
			}
			else if(opcao == 6) {
				
			}
			else if(opcao == 7) {
				
			} else {
				System.out.println("Opção inválida!");
				break; 
			}
			
		}
		 scanner.close();
		 
	}
	
}
