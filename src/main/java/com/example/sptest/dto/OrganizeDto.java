package com.example.sptest.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organize")
public class OrganizeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

        
    @Column(name="create_time")
    private Date createTime;

    @Column(name="group_name")
    private String groupName;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "user_organize",
        joinColumns = {@JoinColumn(name="organize_id")},
        inverseJoinColumns ={@JoinColumn(name="user_id")}
    )
    private List<UserDto> users;
}
