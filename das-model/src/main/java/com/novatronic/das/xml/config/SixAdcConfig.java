package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author wcahuaya
 * 
 */
@XmlRootElement(name = "sixadc-config")
@XmlAccessorType(XmlAccessType.FIELD)
public class SixAdcConfig {

	@XmlElement(name = "message-formats")
	private MessageFormats messageFormats;

	@XmlElement(name = "admin-queues")
	private AdminQueues adminQueues;
	
	@XmlElement(name = "drivers")
	private Drivers drivers;
	
	@XmlElement(name = "balancers")
	private Balancers balancers;
	
	@XmlElement(name = "routes")
	private Routes routes;
	
	@XmlElement(name = "services")
	private Services services;
	
	@XmlElement(name = "profiles")
	private Profiles profiles;
	
	@XmlElement(name = "service-nodes")
	private ServiceNodes serviceNodes;

	public SixAdcConfig() {
		messageFormats = new MessageFormats();
		adminQueues = new AdminQueues();
		drivers = new Drivers();
		balancers = new Balancers();
		routes = new Routes();
		services = new Services();
		profiles = new Profiles();
		serviceNodes = new ServiceNodes();
	}

	public void setMessageFormats(MessageFormats messageFormats) {
		this.messageFormats = messageFormats;
	}
	
	public MessageFormats getMessageFormats() {
		return messageFormats;
	}

	public AdminQueues getAdminQueues() {
		return adminQueues;
	}

	public void setAdminQueues(AdminQueues adminQueues) {
		this.adminQueues = adminQueues;
	}
	
	public Drivers getDrivers() {
		return drivers;
	}

	public void setDrivers(Drivers drivers) {
		this.drivers = drivers;
	}
	
	public Balancers getBalancers() {
		return balancers;
	}

	public void setBalancers(Balancers balancers) {
		this.balancers = balancers;
	}

	public Routes getRoutes() {
		return routes;
	}

	public void setRoutes(Routes routes) {
		this.routes = routes;
	}
	
	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public Profiles getProfiles() {
		return profiles;
	}

	public void setProfiles(Profiles profiles) {
		this.profiles = profiles;
	}

	public ServiceNodes getServiceNodes() {
		return serviceNodes;
	}

	public void setServiceNodes(ServiceNodes serviceNodes) {
		this.serviceNodes = serviceNodes;
	}

	@Override
	public String toString() {
		return "SixAdcConfig [messageFormats=" + messageFormats
				+ ", adminQueues=" + adminQueues + ", drivers=" + drivers
				+ ", balancers=" + balancers + ", routes=" + routes
				+ ", services=" + services + ", profiles=" + profiles
				+ ", serviceNodes=" + serviceNodes + "]";
	}

}
