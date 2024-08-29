package com.empleos.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Perfiles")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer id;

	private String perfil;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Perfil perfil1)) return false;
        return Objects.equals(getId(), perfil1.getId()) && Objects.equals(getPerfil(), perfil1.getPerfil());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getPerfil());
	}

	@Override
	public String toString() {
		return "Perfil{" +
				"id=" + id +
				", perfil='" + perfil + '\'' +
				'}';
	}
}
