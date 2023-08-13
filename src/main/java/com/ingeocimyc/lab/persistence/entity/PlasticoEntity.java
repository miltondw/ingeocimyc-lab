package com.ingeocimyc.lab.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ensayo_plastico")
@Getter
@Setter
@NoArgsConstructor
public class PlasticoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer muestra_id;


    @Column(nullable = false)
    private Integer tare_number;

    @Column(nullable = false)
    private Double tare_weight;

    @Column(nullable = false)
    private Double tare_plus_wet_soil_weight;

    @Column(nullable = false)
    private Double tare_plus_dry_soil;

    @Column(nullable = false)
    private Double dry_soil_weight;

    @Column(nullable = false)
    private Double water_weight;

    @Column(nullable = false)
    private Double humidity;

    @Column(nullable = false)
    private Short numero_prueba;

    @Column
    private String observation;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "muestra_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MuestraEntity muestra;

}
