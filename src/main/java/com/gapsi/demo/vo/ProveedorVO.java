package com.gapsi.demo.vo;

public class ProveedorVO {
	private long id;
	private String nombre;
	private String razonSocial;
	private String direccion;
	
	public ProveedorVO() {
		
	}
	
	public ProveedorVO(long id, String nombre, String razonSocial, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}
