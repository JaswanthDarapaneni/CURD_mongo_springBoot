package com.tech.crud.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
public class DepartmentModel {
	  @Id
	    private String id;
	    private String name;
	    private String description;
	    @DBRef
	    private List<EmployeModel> employees;
	    // Getters and setters
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public List<EmployeModel> getEmployees() {
			return employees;
		}
		public void setEmployees(List<EmployeModel> employees) {
			this.employees = employees;
		}
	    
}


