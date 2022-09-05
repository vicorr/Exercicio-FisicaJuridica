package app;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.Empresa;
import entities.Fisica;


public class Programa {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.print("Digite o número de contribuintes : ");
		int n =sc.nextInt();
		
		for (int i=1; i <=n ;i++){
		System.out.println("CONTRIBUINTE # " + i + "Dados: ");
		System.out.print("Pessoa Física ou Juridica (f/j)? ");
		char type = sc.next().charAt(0);
		System.out.print("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Renda Anual : ");
		double renda = sc.nextDouble();
	
		if (type == 'f') {
				System.out.print ("Despesas de Saúde : ");
				double despesasDeSaude = sc.nextDouble();
				list.add(new Fisica(nome,renda,despesasDeSaude));
		}
		else {
				System.out.print("Numero de Empregados: ");
				int numeroDeEmpregados = sc.nextInt();
				list.add(new Empresa(nome,renda,numeroDeEmpregados));
		}
		
	}	
	
	double sum = 0.0;
	System.out.println();
	System.out.println("IMPOSTOS PAGOS :");
	for (Contribuinte c : list) {
			double imposto = c.imposto();
			System.out.println (c.getNome() + ": $" + String.format("%.2f",imposto));
			sum += imposto;
	}
		System.out.println();
		System.out.println ("TOTAL DE IMPOSTOS: $"+ String.format("%.2f",sum));
		
		sc.close();
	}
}
	
