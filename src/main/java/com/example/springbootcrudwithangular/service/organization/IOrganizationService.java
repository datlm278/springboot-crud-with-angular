package com.example.springbootcrudwithangular.service.organization;

import com.example.springbootcrudwithangular.entity.Organization;

import java.util.List;

public interface IOrganizationService {
    List<Organization> getAllOrganization();
    Organization getOrganizationById(Long id);
    List<Organization> getOrganizationByParentId(Long parentId);
    Organization createOrganization(Organization organization);
    Organization updateOrganization(Organization organization, Long id);
    void deleteOrganization(Long id);
}
