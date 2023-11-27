package com.codecafe.api.customers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customers {
	
	@Id
	@Column(name = "CUSTCUID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customersId;
	private String CUSTNAME;
	private String CUSTPHNO;
	private String CUSTMAIL;
	
	public Customers() {
		
	}

	public Customers(Integer CustomersId, String cUSTNAME, String cUSTPHNO, String cUSTMAIL) {
		super();
		customersId = CustomersId;
		CUSTNAME = cUSTNAME;
		CUSTPHNO = cUSTPHNO;
		CUSTMAIL = cUSTMAIL;
	}

	public Integer getcustomersId() {
		return customersId;
	}

	public void setcustomersId(Integer CustomersId) {
		customersId = CustomersId;
	}

	public String getCUSTNAME() {
		return CUSTNAME;
	}

	public void setCUSTNAME(String cUSTNAME) {
		CUSTNAME = cUSTNAME;
	}

	public String getCUSTPHNO() {
		return CUSTPHNO;
	}

	public void setCUSTPHNO(String cUSTPHNO) {
		CUSTPHNO = cUSTPHNO;
	}

	public String getCUSTMAIL() {
		return CUSTMAIL;
	}

	public void setCUSTMAIL(String cUSTMAIL) {
		CUSTMAIL = cUSTMAIL;
	}

	@Override
	public String toString() {
		return "Customers [customersId=" + customersId + ", CUSTNAME=" + CUSTNAME + ", CUSTPHNO=" + CUSTPHNO
				+ ", CUSTMAIL=" + CUSTMAIL + "]";
	}
	
	
	
}
