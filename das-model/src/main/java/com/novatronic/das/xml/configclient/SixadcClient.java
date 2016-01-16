package com.novatronic.das.xml.configclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SixadcClient {

	@XmlElement(name = "sixadc-client-id")
	private String sixadcClientId;
	@XmlElement(name = "sixadc-client-desc")
	private String sixadcClientDesc;
	@XmlElement(name = "atributos")
	private Atributos atributos;
	@XmlElement(name = "ip-addresses")
	private IpAddresses ipAddresses;
	@XmlElement(name = "six-hostname")
	private String sixHostname;
	@XmlElement(name = "six-username")
	private String sixUsername;
	@XmlElement(name = "six-password")
	private String sixPassword;
	@XmlElement(name = "enabled")
	private String enabled;
	@XmlElement(name = "sixadc-client-profiles")
	private SixadcClientProfiles sixadcClientProfiles;

	public SixadcClient() {

	}

	public SixadcClient(String sixadcClientId, String sixadcClientDesc,
			Atributos atributos, IpAddresses ipAddresses, String sixHostname,
			String sixUsername, String sixPassword, String enabled,
			SixadcClientProfiles sixadcClientProfiles) {
		super();
		this.sixadcClientId = sixadcClientId;
		this.sixadcClientDesc = sixadcClientDesc;
		this.atributos = atributos;
		this.ipAddresses = ipAddresses;
		this.sixHostname = sixHostname;
		this.sixUsername = sixUsername;
		this.sixPassword = sixPassword;
		this.enabled = enabled;
		this.sixadcClientProfiles = sixadcClientProfiles;
	}

	public String getSixadcClientId() {
		return sixadcClientId;
	}

	public void setSixadcClientId(String sixadcClientId) {
		this.sixadcClientId = sixadcClientId;
	}

	public String getSixadcClientDesc() {
		return sixadcClientDesc;
	}

	public void setSixadcClientDesc(String sixadcClientDesc) {
		this.sixadcClientDesc = sixadcClientDesc;
	}

	public Atributos getAtributos() {
		return atributos;
	}

	public void setAtributos(Atributos atributos) {
		this.atributos = atributos;
	}

	public IpAddresses getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(IpAddresses ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

	public String getSixHostname() {
		return sixHostname;
	}

	public void setSixHostname(String sixHostname) {
		this.sixHostname = sixHostname;
	}

	public String getSixUsername() {
		return sixUsername;
	}

	public void setSixUsername(String sixUsername) {
		this.sixUsername = sixUsername;
	}

	public String getSixPassword() {
		return sixPassword;
	}

	public void setSixPassword(String sixPassword) {
		this.sixPassword = sixPassword;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public SixadcClientProfiles getSixadcClientProfiles() {
		return sixadcClientProfiles;
	}

	public void setSixadcClientProfiles(SixadcClientProfiles sixadcClientProfiles) {
		this.sixadcClientProfiles = sixadcClientProfiles;
	}

	@Override
	public String toString() {
		return "SixadcClient [sixadcClientId=" + sixadcClientId
				+ ", sixadcClientDesc=" + sixadcClientDesc + ", atributos="
				+ atributos + ", ipAddresses=" + ipAddresses + ", sixHostname="
				+ sixHostname + ", sixUsername=" + sixUsername
				+ ", sixPassword=" + sixPassword + ", enabled=" + enabled
				+ ", sixadcClientProfiles=" + sixadcClientProfiles + "]";
	}

}
