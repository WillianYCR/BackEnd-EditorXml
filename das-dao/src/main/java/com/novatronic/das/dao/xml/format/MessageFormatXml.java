package com.novatronic.das.dao.xml.format;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.novatronic.das.xml.config.MessageFormats;

/**
 * @author wcahuaya
 *
 */
@XmlRootElement(name = "sixadc-config")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageFormatXml {
	
	@XmlElement(name = "message-formats")
    private MessageFormats messageFormats;
	
	public MessageFormatXml() {
		messageFormats = new MessageFormats();
	}
	
	public void addMessageFormats(MessageFormats messageFormats) {
    	this.messageFormats = messageFormats;
    }
	
	public MessageFormats getMessageFormats() {
		return messageFormats;
	}
}
