package com.example.springbootcrudwithangular.service.organization;

import com.example.springbootcrudwithangular.common.constant.SSWConstant;
import com.example.springbootcrudwithangular.common.exception.EmployeeNotFoundException;
import com.example.springbootcrudwithangular.common.exception.OrganizationNotFoundException;
import com.example.springbootcrudwithangular.common.utils.DateUtils;
import com.example.springbootcrudwithangular.entity.Organization;
import com.example.springbootcrudwithangular.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrganizationService implements IOrganizationService {
    private final OrganizationRepo organizationRepo;

    @Autowired
    public OrganizationService(OrganizationRepo organizationRepo) {
        this.organizationRepo = organizationRepo;
    }

    @Override
    public List<Organization> getAllOrganization() {
        return organizationRepo.findAll();
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return organizationRepo.findOrganizationById(id)
                .orElseThrow(() -> new OrganizationNotFoundException("Organization by id " + id + " was not found"));
    }

    @Override
    public List<Organization> getOrganizationByParentId(Long parentId) {
        return organizationRepo.findOrganizationByParentId(parentId);
    }

    @Override
    public Organization createOrganization(Organization organization) {
        organization.setCreateTime(DateUtils.getCurrentTime(SSWConstant.FORMAT_DAY_HOUR, SSWConstant.TIMEZONE_VIETNAM));
//        updatePath(organization);
        organization.setPath(null);
        return organizationRepo.save(organization);
    }

    @Override
    public Organization updateOrganization(Organization organization, Long id) {
        if (!organization.getId().equals(id) || getOrganizationById(id) == null) {
            throw new EmployeeNotFoundException("Employee by id " + id + " was not found");
        }
        organization.setUpdateTime(DateUtils.getCurrentTime(SSWConstant.FORMAT_DAY_HOUR, SSWConstant.TIMEZONE_VIETNAM));
        return organizationRepo.save(organization);
    }

    @Override
    public void deleteOrganization(Long id) {
        if (getOrganizationById(id) == null) {
            throw new EmployeeNotFoundException("Employee by id " + id + " was not found");
        }
        organizationRepo.deleteOrganizationById(id);
    }

    private void updatePath(Organization organization) {
        if (organization.getParentId() == null) {
            organization.setPath(organization.getId().toString());
        } else {
            Organization parentOrganization = getOrganizationById(organization.getParentId());
            organization.setPath(parentOrganization.getPath() + "/" + organization.getId().toString());
        }
    }
}
