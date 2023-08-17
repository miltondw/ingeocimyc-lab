package com.ingeocimyc.lab.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "header")
@Getter
@Setter
@NoArgsConstructor
public class HeaderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Double tare_weight;

    @Column(nullable = false)
    private Double sample_weight;

    @Column(nullable = false)
    private Integer muestra_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "muestra_id", referencedColumnName = "id",insertable=false, updatable=false)
    private MuestraEntity muestra;
}
