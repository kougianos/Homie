/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export.model;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author valia
 */
public class MessageWrapper {
    private MessageModel[] messages;

    @XmlElement(name="message")
    public MessageModel[] getMessages() {
        return messages;
    }

    public void setMessages(MessageModel[] messages) {
        this.messages = messages;
    }
}