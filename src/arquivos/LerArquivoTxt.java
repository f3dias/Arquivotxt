package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		FileInputStream entradaArquivo = new FileInputStream
				(new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo.txt"));
		Scanner LerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<pessoa> pessoas = new ArrayList<pessoa>();
		
		while (LerArquivo.hasNext()) {
			
			String linha = LerArquivo.nextLine();
			
			if (linha !=null && !linha.isEmpty()) {
			
			String [] dados = linha.split("\\|");
			
			pessoa Pessoa = new pessoa();
			Pessoa.setNome(dados[0]);
			Pessoa.setEmail(dados[1]);
			Pessoa.setIdade(Integer.parseInt(dados[2]));
			
			pessoas.add(Pessoa);
			
			}
		}
		
		for (pessoa Pessoa : pessoas) { //*poderia gravar no banco de dados, gerar boleto etc...*//
			
			System.out.println(Pessoa);
			
		}
	}

}
