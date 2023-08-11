package com.ingeocimyc.lab.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String reference;

    @Column
    private Short probes;
    @Column
    private String user_id;
    @Column
    private String solicitante_id;
    @Column
    private Date date;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "username",insertable=false, updatable=false)
//    private UserEntity user;
//
//    @ManyToOne
//    @JoinColumn(name = "solicitante_id", referencedColumnName = "id",insertable=false, updatable=false)
//    private SolicitanteEntity solicitante;

}
