package com.anncode.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {

    /**
     * Captura el tiempo de inicio dd visualización
     * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto.
     * @return Devuelve la fecha y hora capturada
     */
    Date startToSee(Date dateI);

    /**
     * Captura el tiempo exacto de inicio y final de visualización
     *
     * @param dateI Es un objeto {@code Date} con el tiempo de inicio
     * @param dateF Es un objeto {@code Date} con el tiempo de finalización
     *
     */
    void stopToSee(Date dateI, Date dateF);

}