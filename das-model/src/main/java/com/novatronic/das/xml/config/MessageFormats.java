package com.novatronic.das.xml.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageFormats {

	@XmlElement(name = "message-format")
	private List<MessageFormat> messageFormats;

	public MessageFormats() {
	}

	public MessageFormats(List<MessageFormat> messageFormats) {
		super();
		this.messageFormats = messageFormats;
	}
	
	public List<MessageFormat> getMessageFormats() {
		return messageFormats;
	}

	public void setMessageFormats(List<MessageFormat> messageFormats) {
		this.messageFormats = messageFormats;
	}

	@Override
	public String toString() {
		return "MessageFormats [messageFormats=" + messageFormats + "]";
	}

}
