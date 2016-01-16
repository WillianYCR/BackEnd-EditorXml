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
public class Balancers {

	@XmlAttribute
	private String classManager;
	@XmlAttribute
	private String queueLocation;
	@XmlAttribute
	private String sleepTime;
	@XmlAttribute
	private String refreshTime;

	@XmlElement(name = "balancer")
	private List<Balancer> listBalancer;

	public Balancers() {
	}

	public Balancers(List<Balancer> listBalancer) {
		super();
		this.listBalancer = listBalancer;
	}

	public Balancers(String classManager, String queueLocation,
			String sleepTime, String refreshTime, List<Balancer> listBalancer) {
		super();
		this.classManager = classManager;
		this.queueLocation = queueLocation;
		this.sleepTime = sleepTime;
		this.refreshTime = refreshTime;
		this.listBalancer = listBalancer;
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

	public List<Balancer> getListBalancer() {
		return listBalancer;
	}

	public void setListBalancer(List<Balancer> listBalancer) {
		this.listBalancer = listBalancer;
	}

	@Override
	public String toString() {
		return "Balancers [classManager=" + classManager + ", queueLocation="
				+ queueLocation + ", sleepTime=" + sleepTime + ", refreshTime="
				+ refreshTime + ", listBalancer=" + listBalancer + "]";
	}

}
