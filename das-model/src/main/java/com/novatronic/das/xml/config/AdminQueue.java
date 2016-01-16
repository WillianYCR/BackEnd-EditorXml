package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AdminQueue {

	@XmlElement(name = "admin-queue-id")
	private String adminQueueId;
	@XmlElement(name = "worker-threads-count")
	private String workerThreadsCount;
	@XmlElement(name = "message-type")
	private MessageType messageType;

	public AdminQueue() {

	}

	public AdminQueue(String adminQueueId, String workerThreadsCount,
			MessageType messageType) {
		super();
		this.adminQueueId = adminQueueId;
		this.workerThreadsCount = workerThreadsCount;
		this.messageType = messageType;
	}

	public String getAdminQueueId() {
		return adminQueueId;
	}

	public void setAdminQueueId(String adminQueueId) {
		this.adminQueueId = adminQueueId;
	}

	public String getWorkerThreadsCount() {
		return workerThreadsCount;
	}

	public void setWorkerThreadsCount(String workerThreadsCount) {
		this.workerThreadsCount = workerThreadsCount;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	@Override
	public String toString() {
		return "AdminQueue [adminQueueId=" + adminQueueId
				+ ", workerThreadsCount=" + workerThreadsCount
				+ ", messageType=" + messageType + "]";
	}
}
