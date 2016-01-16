package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageFormat {

	@XmlElement(name = "message-format-id")
	private String messageFormatId;
	@XmlElement(name = "message-format-desc")
	private String messageFormatDesc;
	@XmlElement(name = "transformer-config-file")
	private String transformerConfigFile;
	@XmlElement(name = "router-config-file")
	private String routerConfigFile;
	@XmlElement(name = "transformer-struct")
	private String transformerStruct;

	public MessageFormat() {
	}

	public MessageFormat(String messageFormatId, String messageFormatDesc,
			String transformerConfigFile, String routerConfigFile,
			String transformerStruct) {
		super();
		this.messageFormatId = messageFormatId;
		this.messageFormatDesc = messageFormatDesc;
		this.transformerConfigFile = transformerConfigFile;
		this.routerConfigFile = routerConfigFile;
		this.transformerStruct = transformerStruct;
	}

	public String getMessageFormatId() {
		return messageFormatId;
	}

	public void setMessageFormatId(String messageFormatId) {
		this.messageFormatId = messageFormatId;
	}

	public String getMessageFormatDesc() {
		return messageFormatDesc;
	}

	public void setMessageFormatDesc(String messageFormatDesc) {
		this.messageFormatDesc = messageFormatDesc;
	}

	public String getTransformerConfigFile() {
		return transformerConfigFile;
	}

	public void setTransformerConfigFile(String transformerConfigFile) {
		this.transformerConfigFile = transformerConfigFile;
	}

	public String getRouterConfigFile() {
		return routerConfigFile;
	}

	public void setRouterConfigFile(String routerConfigFile) {
		this.routerConfigFile = routerConfigFile;
	}

	public String getTransformerStruct() {
		return transformerStruct;
	}

	public void setTransformerStruct(String transformerStruct) {
		this.transformerStruct = transformerStruct;
	}

	@Override
	public String toString() {
		return "MessageFormat [messageFormatId=" + messageFormatId
				+ ", messageFormatDesc=" + messageFormatDesc
				+ ", transformerConfigFile=" + transformerConfigFile
				+ ", routerConfigFile=" + routerConfigFile
				+ ", transformerStruct=" + transformerStruct + "]";
	}

}
