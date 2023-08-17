package com.ingeocimyc.lab.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sondeo")
@Getter
@Setter
@NoArgsConstructor
public class SondeoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column
    private Short probe;

    @Column
    private Integer project_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "project_id", referencedColumnName = "id",insertable=false, updatable=false)
    private ProjectEntity project;
}
