package com.example.sptest.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrganizeMapPrimaryKey implements Serializable {
    @Column(name = "organize_id")
    private Integer organizeId;
    @Column(name = "user_id")
    private Integer userId;
}
