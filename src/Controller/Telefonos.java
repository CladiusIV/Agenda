/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "telefonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonos.findAll", query = "SELECT t FROM Telefonos t"),
    @NamedQuery(name = "Telefonos.findByIdtelefono", query = "SELECT t FROM Telefonos t WHERE t.idtelefono = :idtelefono"),
    @NamedQuery(name = "Telefonos.findByNumero", query = "SELECT t FROM Telefonos t WHERE t.numero = :numero"),
    @NamedQuery(name = "Telefonos.findByCelular", query = "SELECT t FROM Telefonos t WHERE t.celular = :celular")})
public class Telefonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtelefono")
    private Integer idtelefono;
    @Column(name = "numero")
    private String numero;
    @Column(name = "celular")
    private Boolean celular;
    @JoinColumn(name = "idContacto", referencedColumnName = "idContacto")
    @ManyToOne
    private Contacto idContacto;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idempresa")
    @ManyToOne
    private Empresas idEmpresa;
    @JoinColumn(name = "idTipo", referencedColumnName = "idTipo")
    @ManyToOne
    private Tipos idTipo;

    public Telefonos() {
    }

    public Telefonos(Integer idtelefono) {
        this.idtelefono = idtelefono;
    }

    public Integer getIdtelefono() {
        return idtelefono;
    }

    public void setIdtelefono(Integer idtelefono) {
        this.idtelefono = idtelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getCelular() {
        return celular;
    }

    public void setCelular(Boolean celular) {
        this.celular = celular;
    }

    public Contacto getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Contacto idContacto) {
        this.idContacto = idContacto;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Tipos getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipos idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtelefono != null ? idtelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonos)) {
            return false;
        }
        Telefonos other = (Telefonos) object;
        if ((this.idtelefono == null && other.idtelefono != null) || (this.idtelefono != null && !this.idtelefono.equals(other.idtelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefonos{" + "numero=" + numero + ", celular=" + celular + '}';
    }


    public Telefonos(String numero, Boolean celular) {
        this.numero = numero;
        this.celular = celular;
    }
    

}
