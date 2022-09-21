package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTxt {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		FileInputStream entradaArquivo = new FileInputStream
				(new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo.txt"));
		Scanner LerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		while (LerArquivo.hasNext()) {
			
			String linha = LerArquivo.nextLine();
			
			if (linha !=null && !linha.isEmpty()) {
			
			System.out.println(linha);
			
			}
		}
	}

}
