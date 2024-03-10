package com.tech.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.tech.crud.dto.employeedto;
import com.tech.crud.exceptions.customExcepctions.ResourceNotFoundException;
import com.tech.crud.model.DepartmentModel;
import com.tech.crud.model.EmployeModel;
import com.tech.crud.repositery.EmployeRepository;
import com.tech.crud.repositery.employeeDepartmentRepository;

@Service
public class EmployeService {

	@Autowired
	private EmployeRepository emprepo;
	@Autowired
	private employeeDepartmentRepository departmentRepository;

	public String createEmployee(employeedto Employeedto) throws NullPointerException, ResourceNotFoundException {
		if (Employeedto.getName() != null && !Employeedto.getName().isEmpty()) {
			EmployeModel emp = new EmployeModel();
			emp.setName(Employeedto.getName());
			emp.setSalery(Employeedto.getSalery());
			emp.setLocation(Employeedto.getLocation());
			List<DepartmentModel> departments = new ArrayList<>();
			List<DepartmentModel> departmentResponce = departmentRepository.findAll();

			for (DepartmentModel departmentDto : Employeedto.getDepartments()) {

				List<DepartmentModel> departmentres = departmentResponce.stream().filter(
						d -> d.getId().equals(departmentDto.getId()) || d.getName().toLowerCase().replaceAll("\\s", "")
								.equals(departmentDto.getName().toLowerCase().replaceAll("\\s", "")))
						.collect(Collectors.toList());

				if (!departmentres.isEmpty()) {
					DepartmentModel departmentModel = new DepartmentModel();
					departmentModel.setName(departmentDto.getName().replaceAll("\\s", ""));
					departmentModel.setDescription(departmentDto.getDescription());
					// Set other department properties as needed
					departments.add(departmentModel);
				} else {
					DepartmentModel departmentModel = new DepartmentModel();
					departmentModel.setName(departmentDto.getName().replaceAll("\\s", ""));
					departmentModel.setDescription(departmentDto.getDescription());
					// Set other department properties as needed
					departments.add(departmentModel);
					departmentRepository.save(departmentModel);
				}

			}
			emp.setDepartments(departments);

			emprepo.save(emp);
			return " Employee Creted Successfully " + departmentResponce;
		} else {
			throw new ResourceNotFoundException("from custom Name should not be null");
		}
	}

	public List<employeedto> getAllEmpoyees() {
		List<employeedto> response = new ArrayList<>();
		try {
			List<EmployeModel> models = emprepo.findAll();
			response = models.stream().map(this::mapModelToDto).collect(Collectors.toList());
		} catch (Exception e) {
			return null;
		}
		return response;
	}

	public String deleteEmployee(String id) throws NotFoundException, NullPointerException {

		if (id != null) {
			System.out.println("im callings");
			Optional<EmployeModel> employeeOptional = emprepo.findById(id);
			if (!employeeOptional.isPresent()) {
				EmployeModel employee = employeeOptional.get();
				emprepo.delete(employee);
				return "Deletion Done";
			} else {
				throw new NotFoundException();
			}
		} else {
			return null;
//				throw new NoSuchElementException("Id is should not be null");
		}

	}

	public String UpdateEmployee(employeedto employeedto) {
		if (employeedto.getId() != null) {
			Optional<EmployeModel> model = emprepo.findById(employeedto.getId());
			if (model.isPresent()) {
				EmployeModel empModel = new EmployeModel();
				empModel.setName(employeedto.getName());
				empModel.setName(employeedto.getLocation());
				empModel.setSalery(employeedto.getSalery());
				empModel.setDepartments(employeedto.getDepartments());
				emprepo.save(empModel);
				return "Employee Updated ";
			} else {
				return "Employee is not Avilable with details" + employeedto.getName();
			}
		} else {
			return null;
		}

	}

	private employeedto mapModelToDto(EmployeModel model) {
		employeedto dto = new employeedto();
		dto.setId(model.getId()); // Assuming there's a getId() method in EmployeModel
		dto.setName(model.getName());
		dto.setSalery(model.getSalery());
		dto.setDepartments(model.getDepartments());
		// Assuming there's a getName() method in EmployeModel
		// Map other fields as needed

		return dto;
	}
}
