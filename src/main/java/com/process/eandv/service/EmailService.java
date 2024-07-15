package com.process.eandv.service;

import org.springframework.stereotype.Service;

import com.process.eandv.Entity.Vendor;

@Service
public class EmailService {

    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }

    public String prepareEmailTemplate(Vendor vendor) {
        return "Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi();
    }
}