package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class arquivos {
	
	public static void main(String[] args) throws IOException   {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(45);
		pessoa1.setNome("João");
		
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(47);
		pessoa2.setNome("Joaquim");
		
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(49);
		pessoa3.setNome("José");
		
		//*essa lista pode vir do banco de dados ou qlq fonte de dados*//
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
				
				
		File arquivo = new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo.csv");
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
				
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		

		
		
		for (Pessoa p : pessoas) {
			
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
			
		}
			
			
		
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
