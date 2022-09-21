package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class arquivos {
	
	public static void main(String[] args) throws IOException   {
		
		pessoa pessoa1 = new pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(45);
		pessoa1.setNome("João");
		
		
		pessoa pessoa2 = new pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(47);
		pessoa2.setNome("Joaquim");
		
		
		pessoa pessoa3 = new pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(49);
		pessoa3.setNome("José");
		
		//*essa lista pode vir do banco de dados ou qlq fonte de dados*//
		
		List<pessoa> pessoas = new ArrayList<pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
				
				
		File arquivo = new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo.txt");
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
				
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		

		
		
		for (pessoa p : pessoas) {
			
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
			
		}
			
			
		
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
