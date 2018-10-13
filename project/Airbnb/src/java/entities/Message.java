/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valia
 */
@Entity
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findByIdmessage", query = "SELECT m FROM Message m WHERE m.messagePK.idmessage = :idmessage")
    , @NamedQuery(name = "Message.findByWriterUsername", query = "SELECT m FROM Message m WHERE m.messagePK.writerUsername = :writerUsername")
    , @NamedQuery(name = "Message.findByReaderUsername", query = "SELECT m FROM Message m WHERE m.messagePK.readerUsername = :readerUsername")
    , @NamedQuery(name = "Message.findByMessagetext", query = "SELECT m FROM Message m WHERE m.messagetext = :messagetext")
    , @NamedQuery(name = "Message.findByDate", query = "SELECT m FROM Message m WHERE m.date = :date")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MessagePK messagePK;
    @Basic(optional = false)
    @Column(name = "messagetext")
    private String messagetext;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "idroom", referencedColumnName = "idroom")
    @ManyToOne(optional = false)
    private Room idroom;
    @JoinColumn(name = "writer_username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "reader_username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public Message() {
    }

    public Message(MessagePK messagePK) {
        this.messagePK = messagePK;
    }

    public Message(MessagePK messagePK, String messagetext, Date date) {
        this.messagePK = messagePK;
        this.messagetext = messagetext;
        this.date = date;
    }

    public Message(int idmessage, String writerUsername, String readerUsername) {
        this.messagePK = new MessagePK(idmessage, writerUsername, readerUsername);
    }

    public MessagePK getMessagePK() {
        return messagePK;
    }

    public void setMessagePK(MessagePK messagePK) {
        this.messagePK = messagePK;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Room getIdroom() {
        return idroom;
    }

    public void setIdroom(Room idroom) {
        this.idroom = idroom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messagePK != null ? messagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messagePK == null && other.messagePK != null) || (this.messagePK != null && !this.messagePK.equals(other.messagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Message[ messagePK=" + messagePK + " ]";
    }
    
}
