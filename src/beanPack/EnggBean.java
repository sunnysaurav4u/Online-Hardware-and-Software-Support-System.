package beanPack;

import java.io.Serializable;

public class EnggBean implements Serializable {
	private int enggId;
	private String enggName;
	private String enggMail;
	private String enggMobile;
	private String enggPassword;

	public EnggBean() {
		// TODO Auto-generated constructor stub
	}

	public String getEnggPassword() {
		return enggPassword;
	}

	public void setEnggPassword(String enggPassword) {
		this.enggPassword = enggPassword;
	}

	public EnggBean(int enggId, String enggName, String enggMail,
			String enggMobile, String enggPassword) {
		super();
		this.enggId = enggId;
		this.enggName = enggName;
		this.enggMail = enggMail;
		this.enggMobile = enggMobile;
		this.enggPassword = enggPassword;
	}

	public int getenggId() {
		return enggId;
	}

	public void setenggId(int enggId) {
		this.enggId = enggId;
	}

	public String getenggName() {
		return enggName;
	}

	public void setenggName(String enggName) {
		this.enggName = enggName;
	}

	public String getenggMail() {
		return enggMail;
	}

	public void setenggMail(String enggMail) {
		this.enggMail = enggMail;
	}

	public String getenggMobile() {
		return enggMobile;
	}

	public void setenggMobile(String enggMobile) {
		this.enggMobile = enggMobile;
	}

}
