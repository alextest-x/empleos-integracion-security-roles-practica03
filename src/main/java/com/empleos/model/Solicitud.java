/**
 * Esta clase representa una entidad (un registro) en la tabla de Solicitudes de la base de datos
 */
package com.empleos.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Solicitudes")
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer id;
	private Date fecha; // Fecha en que aplico el usuario para esta oferta de trabajo
	private String comentarios;
	private String archivo; // El nombre del archivo PDF, DOCX del CV.


	// EJERCICIO: Configurar relación Uno a Uno con Vacantes
	@OneToOne
	@JoinColumn(name="idVacante") // foreignKey en la tabla de solicitudes
	private Vacante vacante;


	// EJERCICIO: Configurar relación Uno a Uno con Usuarios
	@OneToOne
	@JoinColumn(name="idUsuario") // foreignKey en la tabla de usuarios
	private Usuario usuario;



	public Solicitud() {

	}

	public Solicitud(Date fecha) {
		this.fecha = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Vacante getVacante() {
		return vacante;
	}

	public void setVacante(Vacante vacante) {
		this.vacante = vacante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * solucion
	 *
	 * se hace cicla por que ponemos en el to.string() el atributo usuario y tenemos que quitarlo de la clase entity de solicitud
	 * para que no de este error se funciona.
	 *
	 * error en solicitudes porque poniamos en un string, usuario=" + usuario + " en este lado de la clase solicitud
	 * era quitar y solo puede estar de lado del la clase Usuario en el to.string();
	 *  error java.lang.StackOverflowError: null
	 */


	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", fecha=" + fecha + ", comentarios=" + comentarios + ", archivo=" + archivo
				+ ", vacante=" + vacante + "]";
	}

}
