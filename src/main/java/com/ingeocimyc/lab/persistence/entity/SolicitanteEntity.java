package com.ingeocimyc.lab.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "solicitante")
@Getter
@Setter
@NoArgsConstructor
public class SolicitanteEntity {
    @Id
    @Column(nullable = false, length = 30)
    private String id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastname;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(length = 100)
    private String business;

    @Column(length = 100)
    private String email;

    @Override
    public String toString() {
        return "SolicitanteEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", business='" + business + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
