package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("1234567890");
		usuario1.setLogin("Joao");
		usuario1.setSenha("123");
		usuario1.setNome("Jose");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("1234567890");
		usuario2.setLogin("Joaquim");
		usuario2.setSenha("123");
		usuario2.setNome("Joana");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\filejson.json");
        
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		/*lendo arquivo json*/
		
		FileReader fileReader = new FileReader("C:\\workspace-curso-java\\arquivos\\src\\arquivos\\filejson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuario);
			
		}
		
		System.out.println("leitura do arquivo JSON: " + listUsuarios);

	}
 
}
