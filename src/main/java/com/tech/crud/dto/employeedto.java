package com.tech.crud.dto;

import java.math.BigDecimal;
import java.util.List;

import com.tech.crud.model.DepartmentModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class employeedto {

	private String id;
	private String name;
	private String location;
	private BigDecimal salery;
	private List<DepartmentModel> departments;

	public employeedto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public employeedto(String id, String name, String location, BigDecimal salery, List<DepartmentModel> departments) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.salery = salery;
		this.departments = departments;
	}

	public List<DepartmentModel> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentModel> departments) {
		this.departments = departments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getSalery() {
		return salery;
	}

	public void setSalery(BigDecimal salery) {
		this.salery = salery;
	}

}
