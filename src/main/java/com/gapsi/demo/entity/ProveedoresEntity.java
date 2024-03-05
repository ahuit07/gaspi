package com.gapsi.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_proveedores")
public class ProveedoresEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tbl_proveedores_id_proveedor_seq")
	@SequenceGenerator(name="tbl_proveedores_id_proveedor_seq",sequenceName="tbl_proveedores_id_proveedor_seq", allocationSize = 1)
	@Column(name = "id_proveedor")
	private long idProveedor;
	private String nbProveedor;
	private String rsProveedor;
	private String dirProveedor;
	private boolean stProveedor;

	public ProveedoresEntity() {
		
	}
	
	public ProveedoresEntity(String nb_proveedor, String rs_proveedor, String dir_proveedor, boolean st_proveedor) {
		this.nbProveedor = nb_proveedor;
		this.rsProveedor = rs_proveedor;
		this.dirProveedor = dir_proveedor;
		this.stProveedor = st_proveedor;
	}
	
	public long getIdProveedor() {
		return idProveedor;
	}



	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}



	public String getNbProveedor() {
		return nbProveedor;
	}



	public void setNbProveedor(String nbProveedor) {
		this.nbProveedor = nbProveedor;
	}



	public String getRsProveedor() {
		return rsProveedor;
	}



	public void setRsProveedor(String rsProveedor) {
		this.rsProveedor = rsProveedor;
	}



	public String getDirProveedor() {
		return dirProveedor;
	}



	public void setDirProveedor(String dirProveedor) {
		this.dirProveedor = dirProveedor;
	}



	public boolean isStProveedor() {
		return stProveedor;
	}



	public void setStProveedor(boolean stProveedor) {
		this.stProveedor = stProveedor;
	}



	@Override
	public String toString() {
		return "Proveedor [id=" + idProveedor + ", nombre=" + nbProveedor + ", razon social=" + rsProveedor
				+ ", direccion=" + dirProveedor + ", estatus=" + stProveedor + "]";
	}
}
