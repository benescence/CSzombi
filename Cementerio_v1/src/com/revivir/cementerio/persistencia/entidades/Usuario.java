package com.revivir.cementerio.persistencia.entidades;

import com.revivir.cementerio.persistencia.definidos.Roles;


public class Usuario {
		private Integer ID;
		private String  usuario, contrase�a;
		private Roles roles;

		
		public Usuario(Integer ID, Roles roles, String usuario, String contrase�a) {
			this.ID = ID;
			this.usuario = usuario;
			this.contrase�a = contrase�a;
			this.roles =roles;
			
		}


		public Integer getID() {
			return ID;
		}


		public void setID(Integer iD) {
			this.ID = iD;
		}


		public String getUsuario() {
			return usuario;
		}


		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}


		public String getContrase�a() {
			return contrase�a;
		}


		public void setContrase�a(String contrase�a) {
			this.contrase�a = contrase�a;
		}


		public Roles getRoles() {
			return roles;
		}


		public void setRoles(Roles roles) {
			this.roles = roles;
		}

		
		
	
}
