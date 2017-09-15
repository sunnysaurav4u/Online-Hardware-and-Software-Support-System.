package beanPack;

import java.io.Serializable;

public class ComplainBean implements Serializable{

	private int complainId;
	private String complainName;
	private String complainDetail;
	private String complainStatus;
	private String complainType;
	private String complainAnswer;
	private int customerId;
	public ComplainBean() {
		// TODO Auto-generated constructor stub
	}






	public ComplainBean(int complainId,String complainName, String complainDetail, String complainStatus, String complainType,
			String complainAnswer, int customerId) {
		super();
		this.complainId = complainId;
		this.complainName = complainName;
		this.complainDetail = complainDetail;
		this.complainStatus = complainStatus;
		this.complainType = complainType;
		this.complainAnswer = complainAnswer;
		this.customerId = customerId;
	}

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public String getComplainName() {
		return complainName;
	}

	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}

	public String getComplainDetail() {
		return complainDetail;
	}

	public void setComplainDetail(String complainDetails) {
		this.complainDetail = complainDetails;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}

	public String getComplainType() {
		return complainType;
	}

	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}

	public String getComplainAnswer() {
		return complainAnswer;
	}

	public void setComplainAnswer(String complainAnswer) {
		this.complainAnswer = complainAnswer;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
