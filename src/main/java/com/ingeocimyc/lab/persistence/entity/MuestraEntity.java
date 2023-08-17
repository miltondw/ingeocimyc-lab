package com.ingeocimyc.lab.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "muestra")
@Getter
@Setter
@NoArgsConstructor
public class MuestraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Short muestra;

    @Column
    private Integer sondeo_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "sondeo_id", referencedColumnName = "id",insertable=false, updatable=false)
    private SondeoEntity sondeo;
}
