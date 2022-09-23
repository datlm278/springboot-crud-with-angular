package com.example.springbootcrudwithangular.controller;

import com.example.springbootcrudwithangular.common.constant.SSWConstant;
import com.example.springbootcrudwithangular.entity.Organization;
import com.example.springbootcrudwithangular.service.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping(SSWConstant.REST_URL + "organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Organization>> getAllOrganization() {
        List<Organization> organizations = organizationService.getAllOrganization();
        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Organization> getOrganizationById(@RequestParam Long id) {
        Organization organization = organizationService.getOrganizationById(id);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

    @GetMapping("/find-by-parent-id")
    public ResponseEntity<List<Organization>>getOrganizationByParentId(@RequestParam Long parentId) {
        List<Organization> organizations = organizationService.getOrganizationByParentId(parentId);
        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        Organization newOrganization = organizationService.createOrganization(organization);
        return new ResponseEntity<>(newOrganization, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization, @RequestParam Long id) {
        Organization updateOrganization = organizationService.updateOrganization(organization, id);
        return new ResponseEntity<>(updateOrganization, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> createOrganization(@RequestParam Long id) {
        organizationService.deleteOrganization(id);
        return new ResponseEntity<>("Delete organization successfully!", HttpStatus.OK);
    }
}
