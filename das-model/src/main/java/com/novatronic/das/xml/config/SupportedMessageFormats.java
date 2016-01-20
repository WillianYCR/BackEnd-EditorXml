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
public class SupportedMessageFormats {

	@XmlElement(name = "message-format-id")
	private List<String> messageFormatId;

	public SupportedMessageFormats() {
	}

	public SupportedMessageFormats(List<String> messageFormatId) {
		super();
		this.messageFormatId = messageFormatId;
	}

	public List<String> getMessageFormatId() {
		return messageFormatId;
	}

	public void setMessageFormatId(List<String> messageFormatId) {
		this.messageFormatId = messageFormatId;
	}

	@Override
	public String toString() {
		return "SupportedMessageFormats [messageFormatId=" + messageFormatId
				+ "]";
	}

}
