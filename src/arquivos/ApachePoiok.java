package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiok {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo_excel.xsl");
		
		if (!file.exists()) {
			file.createNewFile();
			
		}
		
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
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();/*vai ser usado p escrever a planilha*/
		HSSFSheet linhaPessoas = hssfWorkbook.createSheet("Planilha de pessoas Treinamento"); /*cria a planilha*/
		
		int numeroLinha = 0; 
		
		for (pessoa p : pessoas) {
			
			Row linha = linhaPessoas.createRow(numeroLinha ++);/*criando a linha na planilha*/
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++); /*celula 1*/
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++); /*celula 2*/
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++); /*celula 3*/
			celIdade.setCellValue(p.getIdade());
			
		} /*termino da planilha*/
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		
		System.out.println("planilha foi criada");
		
	
	}


}
