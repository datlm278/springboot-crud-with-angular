package com.example.springbootcrudwithangular.repository;

import com.example.springbootcrudwithangular.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long> {
    Optional<Organization> findOrganizationById(Long id);

    List<Organization> findOrganizationByParentId(Long parentId);

    void deleteOrganizationById(Long id);
}
