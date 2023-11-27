package com.codecafe.api.orders;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
	@Id
	@Column(name="ORDRPKID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ordersId;
	private Integer ORDROUID;
	private Integer ORDRCUID;
	private Integer ORDRIUID;
	private Integer ORDRQNTY;
	private double ORDRPRIC;
	private double ORDRTTAX;
	private double ORDRTOTL;
	private boolean ORDRDELV;
	private double ORDRDISC;
	private double ORDRRFND;
	private LocalDateTime ORDRTIME;
	
	
	
	public Orders() {
		
	}



	public Orders(Integer ordersId, Integer oRDROUID, Integer oRDRCUID, Integer oRDRIUID, Integer oRDRQNTY,
			double oRDRPRIC, double oRDRTTAX, double oRDRTOTL, boolean oRDRDELV, double oRDRDISC, double oRDRRFND,
			LocalDateTime oRDRTIME) {
		super();
		this.ordersId = ordersId;
		ORDROUID = oRDROUID;
		ORDRCUID = oRDRCUID;
		ORDRIUID = oRDRIUID;
		ORDRQNTY = oRDRQNTY;
		ORDRPRIC = oRDRPRIC;
		ORDRTTAX = oRDRTTAX;
		ORDRTOTL = oRDRTOTL;
		ORDRDELV = oRDRDELV;
		ORDRDISC = oRDRDISC;
		ORDRRFND = oRDRRFND;
		ORDRTIME = oRDRTIME;
	}



	public Integer getOrdersId() {
		return ordersId;
	}



	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}



	public Integer getORDROUID() {
		return ORDROUID;
	}



	public void setORDROUID(Integer oRDROUID) {
		ORDROUID = oRDROUID;
	}



	public Integer getORDRCUID() {
		return ORDRCUID;
	}



	public void setORDRCUID(Integer oRDRCUID) {
		ORDRCUID = oRDRCUID;
	}



	public Integer getORDRIUID() {
		return ORDRIUID;
	}



	public void setORDRIUID(Integer oRDRIUID) {
		ORDRIUID = oRDRIUID;
	}



	public Integer getORDRQNTY() {
		return ORDRQNTY;
	}



	public void setORDRQNTY(Integer oRDRQNTY) {
		ORDRQNTY = oRDRQNTY;
	}



	public double getORDRPRIC() {
		return ORDRPRIC;
	}



	public void setORDRPRIC(double oRDRPRIC) {
		ORDRPRIC = oRDRPRIC;
	}



	public double getORDRTTAX() {
		return ORDRTTAX;
	}



	public void setORDRTTAX(double oRDRTTAX) {
		ORDRTTAX = oRDRTTAX;
	}



	public double getORDRTOTL() {
		return ORDRTOTL;
	}



	public void setORDRTOTL(double oRDRTOTL) {
		ORDRTOTL = oRDRTOTL;
	}



	public boolean isORDRDELV() {
		return ORDRDELV;
	}



	public void setORDRDELV(boolean oRDRDELV) {
		ORDRDELV = oRDRDELV;
	}



	public double getORDRDISC() {
		return ORDRDISC;
	}



	public void setORDRDISC(double oRDRDISC) {
		ORDRDISC = oRDRDISC;
	}



	public double getORDRRFND() {
		return ORDRRFND;
	}



	public void setORDRRFND(double oRDRRFND) {
		ORDRRFND = oRDRRFND;
	}



	public LocalDateTime getORDRTIME() {
		return ORDRTIME;
	}



	public void setORDRTIME(LocalDateTime oRDRTIME) {
		ORDRTIME = oRDRTIME;
	}



	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", ORDROUID=" + ORDROUID + ", ORDRCUID=" + ORDRCUID + ", ORDRIUID="
				+ ORDRIUID + ", ORDRQNTY=" + ORDRQNTY + ", ORDRPRIC=" + ORDRPRIC + ", ORDRTTAX=" + ORDRTTAX
				+ ", ORDRTOTL=" + ORDRTOTL + ", ORDRDELV=" + ORDRDELV + ", ORDRDISC=" + ORDRDISC + ", ORDRRFND="
				+ ORDRRFND + ", ORDRTIME=" + ORDRTIME + "]";
	}

	
}