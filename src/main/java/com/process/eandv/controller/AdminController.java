package com.process.eandv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.process.eandv.Entity.Employee;
import com.process.eandv.Entity.Vendor;
import com.process.eandv.service.EmailService;
import com.process.eandv.service.EmployeeService;
import com.process.eandv.service.VendorService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:3000/")

public class AdminController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/vendors")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody List<String> vendorEmails) {
        for (String email : vendorEmails) {
            Vendor vendor = vendorService.getAllVendors().stream()
                    .filter(v -> v.getEmail().equals(email))
                    .findFirst()
                    .orElse(null);
            if (vendor != null) {
                String body = emailService.prepareEmailTemplate(vendor);
                emailService.sendEmail(vendor.getEmail(), "Payment Notification", body);
            }
        }
    }
}

