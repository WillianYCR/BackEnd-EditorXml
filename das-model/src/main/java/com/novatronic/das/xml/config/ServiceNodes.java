package com.novatronic.das.xml.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceNodes {

	@XmlAttribute
	private String classManager;
	@XmlAttribute
	private String queueLocation;
	@XmlAttribute
	private String sleepTime;
	@XmlAttribute
	private String refreshTime;

	@XmlElement(name = "service-node")
	private List<ServiceNode> serviceNode;

	public ServiceNodes() {

	}

	public ServiceNodes(List<ServiceNode> serviceNode) {
		super();
		this.serviceNode = serviceNode;
	}

	public ServiceNodes(String classManager, String queueLocation,
			String sleepTime, String refreshTime, List<ServiceNode> serviceNode) {
		super();
		this.classManager = classManager;
		this.queueLocation = queueLocation;
		this.sleepTime = sleepTime;
		this.refreshTime = refreshTime;
		this.serviceNode = serviceNode;
	}

	public String getClassManager() {
		return classManager;
	}

	public void setClassManager(String classManager) {
		this.classManager = classManager;
	}

	public String getQueueLocation() {
		return queueLocation;
	}

	public void setQueueLocation(String queueLocation) {
		this.queueLocation = queueLocation;
	}

	public String getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(String sleepTime) {
		this.sleepTime = sleepTime;
	}

	public String getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(String refreshTime) {
		this.refreshTime = refreshTime;
	}

	public List<ServiceNode> getServiceNode() {
		return serviceNode;
	}

	public void setServiceNode(List<ServiceNode> serviceNode) {
		this.serviceNode = serviceNode;
	}

	@Override
	public String toString() {
		return "ServiceNodes [classManager=" + classManager
				+ ", queueLocation=" + queueLocation + ", sleepTime="
				+ sleepTime + ", refreshTime=" + refreshTime + ", serviceNode="
				+ serviceNode + "]";
	}

}
