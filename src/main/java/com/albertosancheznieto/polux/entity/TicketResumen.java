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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "POLUX_TICKET_RESUMEN", indexes = {
        @Index(name = "IDX_POLUX_TICKET_RESUMEN_ORGANIZACION", columnList = "ORGANIZACION_ID"),
        @Index(name = "IDX_POLUX_TICKET_RESUMEN_CLIENTE", columnList = "CLIENTE_ID")
})
@Entity(name = "polux_TicketResumen")
public class TicketResumen {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FECHA_YHORA")
    private LocalDateTime fechaYhora;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "HORA")
    private LocalTime hora;

    @InstanceName
    @Column(name = "NUMERO_TICKET")
    private String numeroTicket;

    @Column(name = "IMPORTE_TICKET", precision = 12, scale = 2)
    private BigDecimal importeTicket = BigDecimal.ZERO;

    @Column(name = "IMPORTE_CUPON", precision = 12, scale = 2)
    private BigDecimal importeCupon = BigDecimal.ZERO;

    @Column(name = "CANTIDAD_CUPONES")
    private Short cantidadCupones = 0;

    @Column(name = "TICKET_XML_JSON")
    @Lob
    private String ticketXmlJson;

    @Column(name = "ESTADO_TICKET")
    private String estadoTicket;

    @Column(name = "CODIGO_RESPUESTA")
    private String codigoRespuesta;

    @Column(name = "RESPUESTA")
    @Lob
    private String respuesta;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "ORGANIZACION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organizacion organizacion;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "CLIENTE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public EstadoTicket getEstadoTicket() {
        return estadoTicket == null ? null : EstadoTicket.fromId(estadoTicket);
    }

    public void setEstadoTicket(EstadoTicket estadoTicket) {
        this.estadoTicket = estadoTicket == null ? null : estadoTicket.getId();
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Short getCantidadCupones() {
        return cantidadCupones;
    }

    public void setCantidadCupones(Short cantidadCupones) {
        this.cantidadCupones = cantidadCupones;
    }

    public String getTicketXmlJson() {
        return ticketXmlJson;
    }

    public void setTicketXmlJson(String ticketXmlJson) {
        this.ticketXmlJson = ticketXmlJson;
    }

    public BigDecimal getImporteCupon() {
        return importeCupon;
    }

    public void setImporteCupon(BigDecimal importeCupon) {
        this.importeCupon = importeCupon;
    }

    public BigDecimal getImporteTicket() {
        return importeTicket;
    }

    public void setImporteTicket(BigDecimal importeTicket) {
        this.importeTicket = importeTicket;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
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