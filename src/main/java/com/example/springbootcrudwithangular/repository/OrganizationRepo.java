package com.example.springbootcrudwithangular.repository;

import com.example.springbootcrudwithangular.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long> {
}
