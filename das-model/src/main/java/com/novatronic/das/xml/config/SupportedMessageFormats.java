package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SupportedMessageFormats {

	@XmlElement(name = "message-format-id")
	private String messageFormatId;

	public SupportedMessageFormats() {
	}

	public SupportedMessageFormats(String messageFormatId) {
		super();
		this.messageFormatId = messageFormatId;
	}

	public String getMessageFormatId() {
		return messageFormatId;
	}

	public void setMessageFormatId(String messageFormatId) {
		this.messageFormatId = messageFormatId;
	}

	@Override
	public String toString() {
		return "SupportedMessageFormats [messageFormatId=" + messageFormatId
				+ "]";
	}

}
