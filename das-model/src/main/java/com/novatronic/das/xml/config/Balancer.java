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
public class Balancer {

	@XmlAttribute
	private String id;

	@XmlElement(name = "algorithm")
	private String algorithm;
	@XmlElement(name = "worker-threads-count")
	private String workerThreadsCount;

	public Balancer() {
	}

	public Balancer(String algorithm, String workerThreadsCount) {
		super();
		this.algorithm = algorithm;
		this.workerThreadsCount = workerThreadsCount;
	}

	public Balancer(String id, String algorithm, String workerThreadsCount) {
		super();
		this.id = id;
		this.algorithm = algorithm;
		this.workerThreadsCount = workerThreadsCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getWorkerThreadsCount() {
		return workerThreadsCount;
	}

	public void setWorkerThreadsCount(String workerThreadsCount) {
		this.workerThreadsCount = workerThreadsCount;
	}

	@Override
	public String toString() {
		return "Balancer [id=" + id + ", algorithm=" + algorithm
				+ ", workerThreadsCount=" + workerThreadsCount + "]";
	}

}
