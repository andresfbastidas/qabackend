package co.edu.usbcali.wordsqa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Embeddable
public class UsuarioProyectoId implements java.io.Serializable {
    @NotNull
    private String emailUsuario;
    @NotNull
    private Long idProyecto;

    public UsuarioProyectoId() {
    }

    @Column(name = "email_usuario", nullable = false)
    public String getEmailUsuario() {
        return this.emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Column(name = "id_proyecto", nullable = false)
    public Long getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }

        if ((other == null)) {
            return false;
        }

        if (!(other instanceof UsuarioProyectoId)) {
            return false;
        }

        UsuarioProyectoId castOther = (UsuarioProyectoId) other;

        return ((this.getEmailUsuario() == castOther.getEmailUsuario()) ||
        ((this.getEmailUsuario() != null) &&
        (castOther.getEmailUsuario() != null) &&
        this.getEmailUsuario().equals(castOther.getEmailUsuario()))) &&
        ((this.getIdProyecto() == castOther.getIdProyecto()) ||
        ((this.getIdProyecto() != null) && (castOther.getIdProyecto() != null) &&
        this.getIdProyecto().equals(castOther.getIdProyecto())));
    }

    public int hashCode() {
        int result = 17;

        result = (37 * result) +
            ((getEmailUsuario() == null) ? 0 : this.getEmailUsuario().hashCode());
        result = (37 * result) +
            ((getIdProyecto() == null) ? 0 : this.getIdProyecto().hashCode());

        return result;
    }
}
