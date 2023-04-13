package com.albertosancheznieto.polux.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum EstadoTicket implements EnumClass<String> {

    ENVIADO("ENVIADO"),
    ERROR("ERROR");

    private String id;

    EstadoTicket(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EstadoTicket fromId(String id) {
        for (EstadoTicket at : EstadoTicket.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}