package com.example.springbootcrudwithangular.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SSW_ORGANIZATION")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "path", nullable = true)
    private String path;
    private String information;
    private Long status; // 1: đang hoạt động 0: đã xóa
    @Column(name = "create_time", nullable = false, updatable = false)
    private String createTime;
    private String updateTime;
    private Long parentId;
}
