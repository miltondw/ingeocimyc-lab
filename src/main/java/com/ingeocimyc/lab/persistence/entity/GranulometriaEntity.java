package com.ingeocimyc.lab.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ensayo_granulometria")
@Getter
@Setter
@NoArgsConstructor
public class GranulometriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer muestra_id;

    @Column(nullable = false)
    private String tamices;

    @Column
    private Double total;

    @Column(columnDefinition = "DOUBLE PRECISION[]")
    private double[] retenido;

    @Column(columnDefinition = "DOUBLE PRECISION[]")
    private double[] acum;

    @Column(columnDefinition = "DOUBLE PRECISION[]")
    private double[] pasa;

    @Column
    private Double grava;

    @Column
    private Double arena;

    @Column
    private Double finos;

    @Column
    private String observation;

    @Column
    private String sucs_data;

    @ManyToOne
    @JoinColumn(name = "muestra_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MuestraEntity muestra;
}
