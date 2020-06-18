package br.com.WebBroker.domain;

public class Usuario {
	private long iduser;
	private String username;
	private String userpwd;
	private String tb_function;

	public String getTb_function() {
		return tb_function;
	}

	public void setTb_function(String tb_function) {
		this.tb_function = tb_function;
	}

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return "Usuario [iduser=" + iduser + ", username=" + username
				+ ", userpwd=" + userpwd + ", tb_function=" + tb_function + "]";
	}


	
}
