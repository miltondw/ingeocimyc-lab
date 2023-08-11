package com.ingeocimyc.lab.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ensayo_humedad")
@Getter
@Setter
@NoArgsConstructor
public class HumedadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer muestra_id;

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

    @Column
    private String observation;

    @Column
    private double[] cylinder;

    @Column(nullable = false, columnDefinition = "DOUBLE PRECISION[]")
    private double[] depth;

    @ManyToOne
    @JoinColumn(name = "muestra_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MuestraEntity muestra;
}
