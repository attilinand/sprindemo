package com.lohith.springDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "cars")
public class Cars {


	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	  private Integer id;
	 
	@Column(name="name")
	  private String name;

	@Column(name="manufacture_name")
	  private String manufacture_name;
	  
	@Column(name="model")
	  private Integer model;
	  
	@Column(name="manufacture_year")
	  private Integer manufacture_year;
	  
	@Column(name="color")
	  private String color;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getManufacture_name() {
		return manufacture_name;
	}

	public Integer getModel() {
		return model;
	}

	public Integer getManufacture_year() {
		return manufacture_year;
	}

	public String getColor() {
		return color;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacture_name(String manufacture_name) {
		this.manufacture_name = manufacture_name;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public void setManufacture_year(Integer manufacture_year) {
		this.manufacture_year = manufacture_year;
	}

	public void setColor(String color) {
		this.color = color;
	}


	    

}
