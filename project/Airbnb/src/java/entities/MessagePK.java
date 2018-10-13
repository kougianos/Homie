/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author valia
 */
@Embeddable
public class MessagePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idmessage")
    private int idmessage;
    @Basic(optional = false)
    @Column(name = "writer_username")
    private String writerUsername;
    @Basic(optional = false)
    @Column(name = "reader_username")
    private String readerUsername;

    public MessagePK() {
    }

    public MessagePK(int idmessage, String writerUsername, String readerUsername) {
        this.idmessage = idmessage;
        this.writerUsername = writerUsername;
        this.readerUsername = readerUsername;
    }

    public int getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
    }

    public String getWriterUsername() {
        return writerUsername;
    }

    public void setWriterUsername(String writerUsername) {
        this.writerUsername = writerUsername;
    }

    public String getReaderUsername() {
        return readerUsername;
    }

    public void setReaderUsername(String readerUsername) {
        this.readerUsername = readerUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmessage;
        hash += (writerUsername != null ? writerUsername.hashCode() : 0);
        hash += (readerUsername != null ? readerUsername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessagePK)) {
            return false;
        }
        MessagePK other = (MessagePK) object;
        if (this.idmessage != other.idmessage) {
            return false;
        }
        if ((this.writerUsername == null && other.writerUsername != null) || (this.writerUsername != null && !this.writerUsername.equals(other.writerUsername))) {
            return false;
        }
        if ((this.readerUsername == null && other.readerUsername != null) || (this.readerUsername != null && !this.readerUsername.equals(other.readerUsername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MessagePK[ idmessage=" + idmessage + ", writerUsername=" + writerUsername + ", readerUsername=" + readerUsername + " ]";
    }
    
}
