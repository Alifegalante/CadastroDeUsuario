package alife.g.cadastrousuario.model.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Acl {
    
    private Integer codigoUsuario;

    private Integer codigoServico;

    private Integer nivel;

    public static final String PROP_NIVEL = "nivel";

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        Integer oldNivel = this.nivel;
        this.nivel = nivel;
        propertyChangeSupport.firePropertyChange(PROP_NIVEL, oldNivel, nivel);
    }

    public static final String PROP_CODIGOSERVICO = "codigoServico";

    public Integer getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Integer codigoServico) {
        Integer oldCodigoServico = this.codigoServico;
        this.codigoServico = codigoServico;
        propertyChangeSupport.firePropertyChange(PROP_CODIGOSERVICO, oldCodigoServico, codigoServico);
    }

    public static final String PROP_CODIGOUSUARIO = "codigoUsuario";

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        Integer oldCodigoUsuario = this.codigoUsuario;
        this.codigoUsuario = codigoUsuario;
        propertyChangeSupport.firePropertyChange(PROP_CODIGOUSUARIO, oldCodigoUsuario, codigoUsuario);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
