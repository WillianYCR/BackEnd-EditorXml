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
public class AdminChannel {

	@XmlAttribute
	private String connectTimeOut;
	@XmlAttribute
	private String readTimeOut;
	@XmlAttribute
	private String timeOutQueueRead;
	@XmlAttribute
	private String poolSize;
	@XmlAttribute
	private String sleepTime;
	@XmlAttribute
	private String refreshTime;
	@XmlAttribute
	private String maxReconnect;
	@XmlAttribute
	private String reconnectPause;

	@XmlElement(name = "admin-channel-id")
	private String adminChannelId;
	@XmlElement(name = "admin-channel-port")
	private String adminChannelPort;
	@XmlElement(name = "admin-channel-status")
	private String adminChannelStatus;
	@XmlElement(name = "timeoutReceive")
	private String timeoutReceive;
	@XmlElement(name = "lagTimeReceive")
	private String lagTimeReceive;
	@XmlElement(name = "timeoutSend")
	private String timeoutSend;
	@XmlElement(name = "lagTimeSend")
	private String lagTimeSend;

	public AdminChannel() {

	}

	public AdminChannel(String adminChannelId, String adminChannelPort,
			String adminChannelStatus, String timeoutReceive,
			String lagTimeReceive, String timeoutSend, String lagTimeSend) {
		super();
		this.adminChannelId = adminChannelId;
		this.adminChannelPort = adminChannelPort;
		this.adminChannelStatus = adminChannelStatus;
		this.timeoutReceive = timeoutReceive;
		this.lagTimeReceive = lagTimeReceive;
		this.timeoutSend = timeoutSend;
		this.lagTimeSend = lagTimeSend;
	}

	public AdminChannel(String connectTimeOut, String readTimeOut,
			String timeOutQueueRead, String poolSize, String sleepTime,
			String refreshTime, String maxReconnect, String reconnectPause,
			String adminChannelId, String adminChannelPort,
			String adminChannelStatus, String timeoutReceive,
			String lagTimeReceive, String timeoutSend, String lagTimeSend) {
		super();
		this.connectTimeOut = connectTimeOut;
		this.readTimeOut = readTimeOut;
		this.timeOutQueueRead = timeOutQueueRead;
		this.poolSize = poolSize;
		this.sleepTime = sleepTime;
		this.refreshTime = refreshTime;
		this.maxReconnect = maxReconnect;
		this.reconnectPause = reconnectPause;
		this.adminChannelId = adminChannelId;
		this.adminChannelPort = adminChannelPort;
		this.adminChannelStatus = adminChannelStatus;
		this.timeoutReceive = timeoutReceive;
		this.lagTimeReceive = lagTimeReceive;
		this.timeoutSend = timeoutSend;
		this.lagTimeSend = lagTimeSend;
	}

	public String getConnectTimeOut() {
		return connectTimeOut;
	}

	public void setConnectTimeOut(String connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public String getReadTimeOut() {
		return readTimeOut;
	}

	public void setReadTimeOut(String readTimeOut) {
		this.readTimeOut = readTimeOut;
	}

	public String getTimeOutQueueRead() {
		return timeOutQueueRead;
	}

	public void setTimeOutQueueRead(String timeOutQueueRead) {
		this.timeOutQueueRead = timeOutQueueRead;
	}

	public String getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(String poolSize) {
		this.poolSize = poolSize;
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

	public String getMaxReconnect() {
		return maxReconnect;
	}

	public void setMaxReconnect(String maxReconnect) {
		this.maxReconnect = maxReconnect;
	}

	public String getReconnectPause() {
		return reconnectPause;
	}

	public void setReconnectPause(String reconnectPause) {
		this.reconnectPause = reconnectPause;
	}

	public String getAdminChannelId() {
		return adminChannelId;
	}

	public void setAdminChannelId(String adminChannelId) {
		this.adminChannelId = adminChannelId;
	}

	public String getAdminChannelPort() {
		return adminChannelPort;
	}

	public void setAdminChannelPort(String adminChannelPort) {
		this.adminChannelPort = adminChannelPort;
	}

	public String getAdminChannelStatus() {
		return adminChannelStatus;
	}

	public void setAdminChannelStatus(String adminChannelStatus) {
		this.adminChannelStatus = adminChannelStatus;
	}

	public String getTimeoutReceive() {
		return timeoutReceive;
	}

	public void setTimeoutReceive(String timeoutReceive) {
		this.timeoutReceive = timeoutReceive;
	}

	public String getLagTimeReceive() {
		return lagTimeReceive;
	}

	public void setLagTimeReceive(String lagTimeReceive) {
		this.lagTimeReceive = lagTimeReceive;
	}

	public String getTimeoutSend() {
		return timeoutSend;
	}

	public void setTimeoutSend(String timeoutSend) {
		this.timeoutSend = timeoutSend;
	}

	public String getLagTimeSend() {
		return lagTimeSend;
	}

	public void setLagTimeSend(String lagTimeSend) {
		this.lagTimeSend = lagTimeSend;
	}

	@Override
	public String toString() {
		return "AdminChannel [connectTimeOut=" + connectTimeOut
				+ ", readTimeOut=" + readTimeOut + ", timeOutQueueRead="
				+ timeOutQueueRead + ", poolSize=" + poolSize + ", sleepTime="
				+ sleepTime + ", refreshTime=" + refreshTime
				+ ", maxReconnect=" + maxReconnect + ", reconnectPause="
				+ reconnectPause + ", adminChannelId=" + adminChannelId
				+ ", adminChannelPort=" + adminChannelPort
				+ ", adminChannelStatus=" + adminChannelStatus
				+ ", timeoutReceive=" + timeoutReceive + ", lagTimeReceive="
				+ lagTimeReceive + ", timeoutSend=" + timeoutSend
				+ ", lagTimeSend=" + lagTimeSend + "]";
	}

}
