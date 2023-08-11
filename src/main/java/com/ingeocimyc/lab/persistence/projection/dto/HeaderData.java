package com.ingeocimyc.lab.persistence.projection.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
 public  class HeaderData {
    String TITLE;
    String LOCATION;
    String REFERENCE;
    Date DATE;
    String SOLICITANTE;
    Integer PROBE;
    Integer MUESTRA;
    Double SAMPLE_WEIGHT;
    Double TARE_WEIGHT_H;
}
