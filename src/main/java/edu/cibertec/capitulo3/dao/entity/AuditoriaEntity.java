package edu.cibertec.capitulo3.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "auditoria")
public class AuditoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuditoria;

    @Column(name = "fechahora",columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;

    @OneToOne
    @JoinColumn(name = "usuario",updatable = false, nullable = false)
    private UsuarioEntity usuario;
    private String operacion;

    public AuditoriaEntity() {
    }

    public AuditoriaEntity(int idAuditoria, Date fechahora, UsuarioEntity usuario, String operacion) {
        this.idAuditoria = idAuditoria;
        this.fechahora = fechahora;
        this.usuario = usuario;
        this.operacion = operacion;
    }

    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
