package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Driver {

	@XmlAttribute
	private String driverId;
	@XmlAttribute
	private String adminQueueId;
	@XmlAttribute
	private String type;
	@XmlAttribute
	private String timeOutConnect;
	@XmlAttribute
	private String timeOutRead;
	@XmlAttribute
	private String retries;
	@XmlAttribute
	private String timeOutQueueRead;

	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "port")
	private String port;
	@XmlElement(name = "max-concurrent-connections")
	private String maxConcurrentConnections;
	@XmlElement(name = "forward-process")
	private String forwardProcess;
	@XmlElement(name = "valida-ip")
	private String validaIp;
	@XmlElement(name = "concurrent-user-support")
	private String concurrentUserSupport;
	@XmlElement(name = "filters")
	private Filters filters;

	public Driver() {

	}

	public Driver(String name, String port, String maxConcurrentConnections,
			String forwardProcess, String validaIp,
			String concurrentUserSupport, Filters filters) {
		super();
		this.name = name;
		this.port = port;
		this.maxConcurrentConnections = maxConcurrentConnections;
		this.forwardProcess = forwardProcess;
		this.validaIp = validaIp;
		this.concurrentUserSupport = concurrentUserSupport;
		this.filters = filters;
	}

	public Driver(String driverId, String adminQueueId, String type,
			String timeOutConnect, String timeOutRead, String retries,
			String timeOutQueueRead, String name, String port,
			String maxConcurrentConnections, String forwardProcess,
			String validaIp, String concurrentUserSupport, Filters filters) {
		super();
		this.driverId = driverId;
		this.adminQueueId = adminQueueId;
		this.type = type;
		this.timeOutConnect = timeOutConnect;
		this.timeOutRead = timeOutRead;
		this.retries = retries;
		this.timeOutQueueRead = timeOutQueueRead;
		this.name = name;
		this.port = port;
		this.maxConcurrentConnections = maxConcurrentConnections;
		this.forwardProcess = forwardProcess;
		this.validaIp = validaIp;
		this.concurrentUserSupport = concurrentUserSupport;
		this.filters = filters;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getAdminQueueId() {
		return adminQueueId;
	}

	public void setAdminQueueId(String adminQueueId) {
		this.adminQueueId = adminQueueId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimeOutConnect() {
		return timeOutConnect;
	}

	public void setTimeOutConnect(String timeOutConnect) {
		this.timeOutConnect = timeOutConnect;
	}

	public String getTimeOutRead() {
		return timeOutRead;
	}

	public void setTimeOutRead(String timeOutRead) {
		this.timeOutRead = timeOutRead;
	}

	public String getRetries() {
		return retries;
	}

	public void setRetries(String retries) {
		this.retries = retries;
	}

	public String getTimeOutQueueRead() {
		return timeOutQueueRead;
	}

	public void setTimeOutQueueRead(String timeOutQueueRead) {
		this.timeOutQueueRead = timeOutQueueRead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getMaxConcurrentConnections() {
		return maxConcurrentConnections;
	}

	public void setMaxConcurrentConnections(String maxConcurrentConnections) {
		this.maxConcurrentConnections = maxConcurrentConnections;
	}

	public String getForwardProcess() {
		return forwardProcess;
	}

	public void setForwardProcess(String forwardProcess) {
		this.forwardProcess = forwardProcess;
	}

	public String getValidaIp() {
		return validaIp;
	}

	public void setValidaIp(String validaIp) {
		this.validaIp = validaIp;
	}

	public String getConcurrentUserSupport() {
		return concurrentUserSupport;
	}

	public void setConcurrentUserSupport(String concurrentUserSupport) {
		this.concurrentUserSupport = concurrentUserSupport;
	}

	public Filters getFilters() {
		return filters;
	}

	public void setFilters(Filters filters) {
		this.filters = filters;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", adminQueueId="
				+ adminQueueId + ", type=" + type + ", timeOutConnect="
				+ timeOutConnect + ", timeOutRead=" + timeOutRead
				+ ", retries=" + retries + ", timeOutQueueRead="
				+ timeOutQueueRead + ", name=" + name + ", port=" + port
				+ ", maxConcurrentConnections=" + maxConcurrentConnections
				+ ", forwardProcess=" + forwardProcess + ", validaIp="
				+ validaIp + ", concurrentUserSupport=" + concurrentUserSupport
				+ ", filters=" + filters + "]";
	}

}
