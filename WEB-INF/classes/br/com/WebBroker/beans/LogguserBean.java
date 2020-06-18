package br.com.WebBroker.beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.com.WebBroker.domain.Usuario;
import br.com.WebBroker.factory.ConexaoFactory;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class LogguserBean {
	private Usuario usuario = new Usuario();
	FacesContext context = FacesContext.getCurrentInstance();
	
	public String localizar() throws SQLException {
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement pstmLocaliza = null;
		ResultSet resultado = null;
		String sql = "SELECT TB_USER_NAME,TB_USER_PWD,TB_FUNCTION FROM tb_user WHERE TB_USER_NAME = ? AND TB_USER_PWD = ?";
		try {
			pstmLocaliza = conexao.prepareStatement(sql);
			pstmLocaliza.setString(1, usuario.getUsername());
			pstmLocaliza.setString(2, usuario.getUserpwd());
			resultado = pstmLocaliza.executeQuery();
			
			if (resultado.next()) {
				usuario.setUsername(resultado.getString("TB_USER_NAME"));
				usuario.setUserpwd(resultado.getString("TB_USER_PWD"));
				usuario.setTb_function(resultado.getString("TB_FUNCTION"));	
		
				return "principal";
				
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Login ou senha inválido!", ""));
				return null;
			}
		} catch (SQLException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao localizar registro. Mensagem: " + e.getMessage(), ""));
			return null;
		} finally {
			try {
				pstmLocaliza.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao fechar operação de Localização. Mensagem: " + e.getMessage(), ""));
				return null;
			}
		}
	}//fim localiza
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;

	}
	public String logout() {          
		  
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	
		return "/WebBroker";  	
	}
}