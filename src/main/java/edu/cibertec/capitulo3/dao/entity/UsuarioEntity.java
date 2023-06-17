package edu.cibertec.capitulo3.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Base64;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Size(min=3, max=20)
    @Id
    private String usuario;
    
    @NotNull
    @NotBlank
    private String clave;
    @Column(name = "nomCompleto")
    private String nombreCompleto;
    //@Transient
    @Column
    private byte[] foto;
    @Transient
    private String fotoBase64;
    public String getFotoBase64(){
        String rpta=null;
        if(foto!=null && foto.length>0){
            rpta= Base64.getEncoder().encodeToString(foto);

        }
        return rpta;
    }

    public void setFotoBase64(String fotoBase64){
        this.fotoBase64=fotoBase64;
    }

    public UsuarioEntity() {
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public UsuarioEntity(String usuario, String clave, String nombreCompleto) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "usuario=" + usuario +
                ", clave=" + clave +
                ", nombreCompleto=" + nombreCompleto +
                '}';
    }
}
