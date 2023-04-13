package com.albertosancheznieto.polux.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "POLUX_CLIENTE")
@Entity(name = "polux_Cliente")
public class Cliente {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "TELEFONO")
    private String telefono;

    @Email(message = "{msg://com.albertosancheznieto.polux.entity/Cliente.email.validation.Email}")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "LOCALIDAD")
    private String localidad;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "CODIGO_POSTAL")
    private Integer codigoPostal;

    @Column(name = "CODIGO_CLIENTE")
    private String codigoCliente;

    @Column(name = "TARJETA_CLIENTE")
    private String tarjetaCliente;

    @Column(name = "CODIGO_FIDELIZADO")
    private String codigoFidelizado;

    @Column(name = "TARJETA_FIDELIZADO")
    private String tarjetaFidelizado;

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
    @JoinTable(name = "POLUX_COLECTIVO_CLIENTE_LINK",
            joinColumns = @JoinColumn(name = "CLIENTE_ID"),
            inverseJoinColumns = @JoinColumn(name = "COLECTIVO_ID"))
    @ManyToMany
    private List<Colectivo> colectivos;

    public List<Colectivo> getColectivos() {
        return colectivos;
    }

    public void setColectivos(List<Colectivo> colectivos) {
        this.colectivos = colectivos;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTarjetaFidelizado() {
        return tarjetaFidelizado;
    }

    public void setTarjetaFidelizado(String tarjetaFidelizado) {
        this.tarjetaFidelizado = tarjetaFidelizado;
    }

    public String getTarjetaCliente() {
        return tarjetaCliente;
    }

    public void setTarjetaCliente(String tarjetaCliente) {
        this.tarjetaCliente = tarjetaCliente;
    }

    public String getCodigoFidelizado() {
        return codigoFidelizado;
    }

    public void setCodigoFidelizado(String codigoFidelizado) {
        this.codigoFidelizado = codigoFidelizado;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @InstanceName
    @DependsOnProperties({"nombre", "apellidos"})
    public String getInstanceName() {
        return String.format("%s %s", nombre, apellidos);
    }
}