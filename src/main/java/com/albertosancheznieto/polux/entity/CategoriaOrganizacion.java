package com.albertosancheznieto.polux.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum CategoriaOrganizacion implements EnumClass<String> {

    ORGANIZACION("ORGANIZACION"),
    LINEA_DE_NEGOCIO("LINEA DE NEGOCIO"),
    SUPERMERCADOS("SUPERMERCADOS"),
    CASH("CASH"),
    HORECA("HORECA"),
    CLIENTES_DISTRIBUCION("CLIENTES DISTRIBUCION"),
    SECCION("SECCION");

    private String id;

    CategoriaOrganizacion(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CategoriaOrganizacion fromId(String id) {
        for (CategoriaOrganizacion at : CategoriaOrganizacion.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}