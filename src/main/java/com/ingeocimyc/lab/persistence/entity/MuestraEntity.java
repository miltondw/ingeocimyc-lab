package com.ingeocimyc.lab.persistence.entity;

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

    @ManyToOne
    @JoinColumn(name = "sondeo_id", referencedColumnName = "id")
    private SondeoEntity sondeo;
}
