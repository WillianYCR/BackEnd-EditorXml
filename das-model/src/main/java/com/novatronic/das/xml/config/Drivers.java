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
public class Drivers {

	@XmlAttribute
	private String classManager;
	@XmlAttribute
	private String queueLocation;
	@XmlAttribute
	private String sleepTime;
	@XmlAttribute
	private String refreshTime;

	@XmlElement(name = "driver")
	private List<Driver> drivers;

	public Drivers() {

	}

	public Drivers(List<Driver> drivers) {
		super();
		this.drivers = drivers;
	}

	public Drivers(String classManager, String queueLocation, String sleepTime,
			String refreshTime, List<Driver> drivers) {
		super();
		this.classManager = classManager;
		this.queueLocation = queueLocation;
		this.sleepTime = sleepTime;
		this.refreshTime = refreshTime;
		this.drivers = drivers;
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

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	@Override
	public String toString() {
		return "Drivers [classManager=" + classManager + ", queueLocation="
				+ queueLocation + ", sleepTime=" + sleepTime + ", refreshTime="
				+ refreshTime + ", drivers=" + drivers + "]";
	}

}
