package com.project.spring.Services;

import com.project.spring.DAO.*;
import com.project.spring.DTO.EditEmployee;
import com.project.spring.DomainObjects.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EditEmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private SalaryDAO salaryDAO;
    @Autowired
    private TitleDAO titleDAO;
    @Autowired
    private DepartmentEmployeeDAO departmentEmployeeDAO;
    @Autowired
    private DepartmentManagerDAO departmentManagerDAO;
    @Autowired
    private DepartmentDAO departmentDAO;

    private final static Logger logger = LogManager.getLogger(EditEmployeeService.class);

    public String editEmployee(EditEmployee editEmployee) {

        String first = editEmployee.getFirstName().toLowerCase();
        first = Character.toUpperCase(first.charAt(0)) + first.substring(1);
        String last = editEmployee.getLastName().toLowerCase();
        last = Character.toUpperCase(last.charAt(0)) + last.substring(1);

        Employee edittedEmployee = employeeDAO.findByEmpNo(editEmployee.getEmpNo());


        return editEmployee.getFirstName() + " " + editEmployee.getLastName();
    }

}