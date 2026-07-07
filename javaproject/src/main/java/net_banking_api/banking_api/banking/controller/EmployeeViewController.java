package net_banking_api.banking_api.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net_banking_api.banking_api.banking.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeViewController {

    private final EmployeeService employeeService;

    public EmployeeViewController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String employeePage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees"; // employees.html in templates folder
    }
}
