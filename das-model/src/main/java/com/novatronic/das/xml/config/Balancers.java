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
	private List<Balancer> balancers;

	public Balancers() {
	}

	public Balancers(List<Balancer> balancers) {
		super();
		this.balancers = balancers;
	}

	public Balancers(String classManager, String queueLocation,
			String sleepTime, String refreshTime, List<Balancer> balancers) {
		super();
		this.classManager = classManager;
		this.queueLocation = queueLocation;
		this.sleepTime = sleepTime;
		this.refreshTime = refreshTime;
		this.balancers = balancers;
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

	public List<Balancer> getBalancers() {
		return balancers;
	}

	public void setBalancers(List<Balancer> balancers) {
		this.balancers = balancers;
	}

	@Override
	public String toString() {
		return "Balancers [classManager=" + classManager + ", queueLocation="
				+ queueLocation + ", sleepTime=" + sleepTime + ", refreshTime="
				+ refreshTime + ", balancers=" + balancers + "]";
	}

}
