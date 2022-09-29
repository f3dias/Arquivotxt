package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiok2 {
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream entrada = new FileInputStream(new File("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\arquivo_excel.xsl"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /*para entrada do excel para ler*/		
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /*pega a primeira planilha do excel*/
		
		Iterator<Row> linhaiterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (linhaiterator.hasNext()) { /*enquanto tiver linha no arquivo do excel*/
			
			Row linha = linhaiterator.next(); /*dados da pessoa na linha*/
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while (celulas.hasNext()) { /*pecorrer as celulas*/
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}				
				
			} /*fim da celula da linha*/
			
			pessoas.add(pessoa);
						
		}
		
		entrada.close(); /*terminou de ler o arquivo excel*/
		
		for (Pessoa pessoa : pessoas) { /*poderia gravar no banco de dados*/
			
			System.out.println(pessoa);
			
		}
	
	}


}
