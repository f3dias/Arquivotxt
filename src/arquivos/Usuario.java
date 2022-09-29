package arquivos;

import java.io.Serializable;

public class Usuario implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	private String cpf;
	private String nome;
	
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", nome=" + nome + "]";
	}
	
	
}
