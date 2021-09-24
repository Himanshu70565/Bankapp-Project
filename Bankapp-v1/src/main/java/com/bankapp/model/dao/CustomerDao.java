package com.bankapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.web.entities.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
