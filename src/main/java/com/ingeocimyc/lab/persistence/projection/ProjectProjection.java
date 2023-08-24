package com.ingeocimyc.lab.persistence.projection;

import java.util.Date;

public interface ProjectProjection {
    // HEADER
    String getTITLE();
    String getLOCATION();
    String getREFERENCE();
    Date getDATE();
    //SOLICITANTE
    String getNAME();
    String getLASTNAME();
    //SONDEO
    Integer getPROBE();
    //MUESTRA
    Integer getMUESTRA();
    //HEADER
    Double getSAMPLE_WEIGHT();
    Double getTARE_WEIGHT_H();
    // HUMEDAD
    Double[] getDEPTH();
    Double getHUMIDITY_EH();
    Double[] getCYLINDER();
    // GRANULOMETRIA
    String getTAMICES();
    Double[] getacum();
    Double getarena();
    Double getfinos();
    Double getgrava();
    Double[] getpasa();
    Double[] getretenido();
    String getsucs_data();
    Double gettotal();
    Integer getID();
    Integer getMUESTRA_ID();
    //Liquido
    Integer getNUMBER_OF_STROKES();
    Integer getTARE_NUMBER_EL();
    Double getTARE_WEIGHT_EL();
    Double getTARE_PLUS_WET_SOIL_WEIGHT_EL();
    Double getTARE_PLUS_DRY_SOIL_EL();
    Double getWATER_WEIGHT_EL();
    Double getDRY_SOIL_WEIGHT_EL();
    Double getHUMIDITY_EL();
    Double getlimite_liquido();
    Integer getNUMERO_PRUEBA_EL();
    //PLASTICO
    Integer getTARE_NUMBER();
    Double getTARE_WEIGHT();
    Double getTARE_PLUS_WET_SOIL_WEIGHT();
    Double getTARE_PLUS_DRY_SOIL();
    Double getDRY_SOIL_WEIGHT();
    Double getWATER_WEIGHT();
    Double getHUMIDITY();
    String getOBSERVATION();
    Integer getNUMERO_PRUEBA();
    Double getlimite_plastico();

}
