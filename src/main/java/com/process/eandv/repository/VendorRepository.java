package com.process.eandv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.process.eandv.Entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, String> {

}
