package com.albertosancheznieto.polux.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
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
@Table(name = "POLUX_ORGANIZACION", indexes = {
        @Index(name = "IDX_POLUX_ORGANIZACION_ID_PADRE", columnList = "ID_PADRE_ID")
})
@Entity(name = "polux_Organizacion")
public class Organizacion {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @NotBlank(message = "{msg://com.albertosancheznieto.polux.entity/Organizacion.codigo.validation.NotBlank}")
    @NotEmpty(message = "{msg://com.albertosancheznieto.polux.entity/Organizacion.codigo.validation.NotEmpty}")
    @Column(name = "CODIGO", nullable = false)
    @NotNull
    private String codigo;

    @InstanceName
    @NotBlank(message = "{msg://com.albertosancheznieto.polux.entity/Organizacion.descripcion.validation.NotBlank}")
    @NotEmpty(message = "{msg://com.albertosancheznieto.polux.entity/Organizacion.descripcion.validation.NotEmpty}")
    @Column(name = "DESCRIPCION", nullable = false)
    @NotNull
    private String descripcion;

    @Column(name = "CODIGO_GESTION")
    private String codigoGestion;

    @Column(name = "CODIGO_RRHH")
    private String codigoRrhh;

    @Column(name = "CODIGO_ALMACEN")
    private String codigoAlmacen;

    @Column(name = "PATH_ORGANIZACION")
    private String pathOrganizacion;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "ID_PADRE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacion idPadre;

    @Column(name = "CATEGORIA_ORGANIZACION", nullable = false)
    @NotNull
    private String categoriaOrganizacion;

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

    @JoinTable(name = "POLUX_SURTIDO_ORGANIZACION_LINK",
            joinColumns = @JoinColumn(name = "ORGANIZACION_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SURTIDO_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Surtido> surtidos;

    public List<Surtido> getSurtidos() {
        return surtidos;
    }

    public void setSurtidos(List<Surtido> surtidos) {
        this.surtidos = surtidos;
    }

    public CategoriaOrganizacion getCategoriaOrganizacion() {
        return categoriaOrganizacion == null ? null : CategoriaOrganizacion.fromId(categoriaOrganizacion);
    }

    public void setCategoriaOrganizacion(CategoriaOrganizacion categoriaOrganizacion) {
        this.categoriaOrganizacion = categoriaOrganizacion == null ? null : categoriaOrganizacion.getId();
    }

    public Organizacion getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Organizacion idPadre) {
        this.idPadre = idPadre;
    }

    public String getPathOrganizacion() {
        return pathOrganizacion;
    }

    public void setPathOrganizacion(String pathOrganizacion) {
        this.pathOrganizacion = pathOrganizacion;
    }

    public String getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(String codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }

    public String getCodigoRrhh() {
        return codigoRrhh;
    }

    public void setCodigoRrhh(String codigoRrhh) {
        this.codigoRrhh = codigoRrhh;
    }

    public String getCodigoGestion() {
        return codigoGestion;
    }

    public void setCodigoGestion(String codigoGestion) {
        this.codigoGestion = codigoGestion;
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