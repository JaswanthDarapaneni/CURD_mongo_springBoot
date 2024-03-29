package com.tech.crud.dto;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.tech.crud.model.DepartmentModel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class employeedto {
    
	private String id;
	@NotBlank(message = "Name should not be blank")
	@Length(min = 3,message = "Name required min 3 leters")
	private String name;
	@NotBlank(message = "Location should not be blank")
	private String location;
	@NotNull(message = "Salary required should not be blank")
	@Min(value = 3, message = "Salary required should not be blank")
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
