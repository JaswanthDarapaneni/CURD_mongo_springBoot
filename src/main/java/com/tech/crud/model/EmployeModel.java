package com.tech.crud.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor()
@AllArgsConstructor
@Document(collection = "employee")
public class EmployeModel {
	@Id
	private String id;
	@Field(name = "employee_name")
	
	private String name;
	private String location;
	private BigDecimal salery;
	private List<DepartmentModel> departments;

	public EmployeModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public List<DepartmentModel> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentModel> departments) {
		this.departments = departments;
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
