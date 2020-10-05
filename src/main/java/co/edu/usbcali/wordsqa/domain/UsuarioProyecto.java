package co.edu.usbcali.wordsqa.domain;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "usuario_proyecto", schema = "public")
public class UsuarioProyecto implements java.io.Serializable {
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UsuarioProyectoId id;
    @NotNull
    private Proyecto proyecto;
    @NotNull
    private Usuario usuario;

    public UsuarioProyecto() {
    }

    public UsuarioProyecto(UsuarioProyectoId id, Proyecto proyecto,
        Usuario usuario) {
        this.id = id;
        this.proyecto = proyecto;
        this.usuario = usuario;
    }

    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "emailUsuario",column = @Column(name = "email_usuario",nullable = false)
        )
        , @AttributeOverride(name = "idProyecto",column = @Column(name = "id_proyecto",nullable = false)
        )
    })
    public UsuarioProyectoId getId() {
        return this.id;
    }

    public void setId(UsuarioProyectoId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto", insertable = false, updatable = false)
    public Proyecto getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_usuario", insertable = false, updatable = false)
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
