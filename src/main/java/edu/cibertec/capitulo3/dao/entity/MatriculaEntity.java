package edu.cibertec.capitulo3.dao.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "matricula")
public class MatriculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatricula;
    private Date fechaMat;
    @OneToOne
    @JoinColumn(name = "usuario", updatable = false, nullable = false)
    private UsuarioEntity usuario;

    @OneToOne
    @JoinColumn(name = "idCurso", updatable = false, nullable = false)
    private CursoEntity curso;
    private int estado;

    public MatriculaEntity() {
    }

    public MatriculaEntity(int idMatricula, Date fechaMat, UsuarioEntity usuario, CursoEntity curso, int estado) {
        this.idMatricula = idMatricula;
        this.fechaMat = fechaMat;
        this.usuario = usuario;
        this.curso = curso;
        this.estado = estado;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getFechaMat() {
        return fechaMat;
    }

    public void setFechaMat(Date fechaMat) {
        this.fechaMat = fechaMat;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
