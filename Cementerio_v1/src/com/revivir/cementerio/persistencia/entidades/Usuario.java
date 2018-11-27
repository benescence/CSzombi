package com.revivir.cementerio.persistencia.entidades;

import com.revivir.cementerio.persistencia.definidos.Roles;


public class Usuario {
		private Integer ID;
		private String  usuario, contraseña;
		private Roles roles;

		
		public Usuario(Integer ID, Roles roles, String usuario, String contraseña) {
			this.ID = ID;
			this.usuario = usuario;
			this.contraseña = contraseña;
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


		public String getContraseña() {
			return contraseña;
		}


		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}


		public Roles getRoles() {
			return roles;
		}


		public void setRoles(Roles roles) {
			this.roles = roles;
		}

		
		
	
}
