package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceNode {

	@XmlElement(name = "service-node-id")
	private String serviceNodeId;
	@XmlElement(name = "ip-address")
	private String ipAddress;
	@XmlElement(name = "bin-monitor-pause")
	private String binMonitorPause;
	@XmlElement(name = "admin-channel")
	private AdminChannel adminChannel;
	@XmlElement(name = "default-channel")
	private DefaultChannel defaultChannel;
	@XmlElement(name = "service-channels")
	private ServiceChannels serviceChannels;

	public ServiceNode() {

	}

	public ServiceNode(String serviceNodeId, String ipAddress,
			String binMonitorPause, AdminChannel adminChannel,
			DefaultChannel defaultChannel, ServiceChannels serviceChannels) {
		super();
		this.serviceNodeId = serviceNodeId;
		this.ipAddress = ipAddress;
		this.binMonitorPause = binMonitorPause;
		this.adminChannel = adminChannel;
		this.defaultChannel = defaultChannel;
		this.serviceChannels = serviceChannels;
	}

	public String getServiceNodeId() {
		return serviceNodeId;
	}

	public void setServiceNodeId(String serviceNodeId) {
		this.serviceNodeId = serviceNodeId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getBinMonitorPause() {
		return binMonitorPause;
	}

	public void setBinMonitorPause(String binMonitorPause) {
		this.binMonitorPause = binMonitorPause;
	}

	public AdminChannel getAdminChannel() {
		return adminChannel;
	}

	public void setAdminChannel(AdminChannel adminChannel) {
		this.adminChannel = adminChannel;
	}

	public DefaultChannel getDefaultChannel() {
		return defaultChannel;
	}

	public void setDefaultChannel(DefaultChannel defaultChannel) {
		this.defaultChannel = defaultChannel;
	}

	public ServiceChannels getServiceChannels() {
		return serviceChannels;
	}

	public void setServiceChannels(ServiceChannels serviceChannels) {
		this.serviceChannels = serviceChannels;
	}

	@Override
	public String toString() {
		return "ServiceNode [serviceNodeId=" + serviceNodeId + ", ipAddress="
				+ ipAddress + ", binMonitorPause=" + binMonitorPause
				+ ", adminChannel=" + adminChannel + ", defaultChannel="
				+ defaultChannel + ", serviceChannels=" + serviceChannels + "]";
	}

}
