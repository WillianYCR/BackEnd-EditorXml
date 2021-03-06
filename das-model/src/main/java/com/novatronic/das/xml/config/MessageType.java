package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageType {

	@XmlElement(name = "message-type-id")
	private String messageTypeId;
	@XmlElement(name = "message-type-desc")
	private String messageTypeDesc;
	@XmlElement(name = "supported-message-formats")
	private SupportedMessageFormats supportedMessageFormats;

	public MessageType() {

	}

	public MessageType(String messageTypeId, String messageTypeDesc,
			SupportedMessageFormats supportedMessageFormats) {
		super();
		this.messageTypeId = messageTypeId;
		this.messageTypeDesc = messageTypeDesc;
		this.supportedMessageFormats = supportedMessageFormats;
	}

	public String getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(String messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getMessageTypeDesc() {
		return messageTypeDesc;
	}

	public void setMessageTypeDesc(String messageTypeDesc) {
		this.messageTypeDesc = messageTypeDesc;
	}

	public SupportedMessageFormats getSupportedMessageFormats() {
		return supportedMessageFormats;
	}

	public void setSupportedMessageFormats(
			SupportedMessageFormats supportedMessageFormats) {
		this.supportedMessageFormats = supportedMessageFormats;
	}

	@Override
	public String toString() {
		return "MessageType [messageTypeId=" + messageTypeId
				+ ", messageTypeDesc=" + messageTypeDesc
				+ ", supportedMessageFormats=" + supportedMessageFormats + "]";
	}

}
