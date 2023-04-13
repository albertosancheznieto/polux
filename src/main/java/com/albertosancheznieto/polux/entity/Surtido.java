package com.albertosancheznieto.polux.entity;

import io.jmix.core.entity.annotation.CaseConversion;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "POLUX_SURTIDO")
@Entity(name = "polux_Surtido")
public class Surtido {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @NotBlank(message = "{msg://com.albertosancheznieto.polux.entity/Surtido.codigo.validation.NotBlank}")
    @NotEmpty(message = "{msg://com.albertosancheznieto.polux.entity/Surtido.codigo.validation.NotEmpty}")
    @Column(name = "CODIGO")
    private String codigo;

    @NotBlank(message = "{msg://com.albertosancheznieto.polux.entity/Surtido.descripcion.validation.NotBlank}")
    @NotEmpty(message = "{msg://com.albertosancheznieto.polux.entity/Surtido.descripcion.validation.NotEmpty}")
    @CaseConversion
    @Column(name = "DESCRIPCION", nullable = false)
    @NotNull
    private String descripcion;

    @JoinTable(name = "POLUX_SURTIDO_ORGANIZACION_LINK",
            joinColumns = @JoinColumn(name = "SURTIDO_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ORGANIZACION_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Organizacion> organizaciones;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public List<Organizacion> getOrganizaciones() {
        return organizaciones;
    }

    public void setOrganizaciones(List<Organizacion> organizaciones) {
        this.organizaciones = organizaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}