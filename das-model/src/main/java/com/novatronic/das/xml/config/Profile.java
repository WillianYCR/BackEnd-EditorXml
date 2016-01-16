package com.novatronic.das.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {

	@XmlElement(name = "profile-id")
	private String profileId;
	@XmlElement(name = "profile-desc")
	private String profileDesc;
	@XmlElement(name = "profile-drivers")
	private ProfileDrivers profileDrivers;
	@XmlElement(name = "auth-services")
	private AuthServices authServices;

	public Profile() {

	}

	public Profile(String profileId, String profileDesc,
			ProfileDrivers profileDrivers, AuthServices authServices) {
		super();
		this.profileId = profileId;
		this.profileDesc = profileDesc;
		this.profileDrivers = profileDrivers;
		this.authServices = authServices;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getProfileDesc() {
		return profileDesc;
	}

	public void setProfileDesc(String profileDesc) {
		this.profileDesc = profileDesc;
	}

	public ProfileDrivers getProfileDrivers() {
		return profileDrivers;
	}

	public void setProfileDrivers(ProfileDrivers profileDrivers) {
		this.profileDrivers = profileDrivers;
	}

	public AuthServices getAuthServices() {
		return authServices;
	}

	public void setAuthServices(AuthServices authServices) {
		this.authServices = authServices;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileDesc="
				+ profileDesc + ", profileDrivers=" + profileDrivers
				+ ", authServices=" + authServices + "]";
	}

}
