package com.novatronic.das.xml.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author wcahuaya
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Profiles {

	@XmlElement(name = "profile")
	private List<Profile> profiles;

	public Profiles() {

	}

	public Profiles(List<Profile> profiles) {
		super();
		this.profiles = profiles;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public String toString() {
		return "Profiles [profiles=" + profiles + "]";
	}
}
