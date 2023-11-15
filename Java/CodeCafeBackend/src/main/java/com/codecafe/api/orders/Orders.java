package com.codecafe.api.orders;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@Column(name = "ORDROUID")
	private Integer ordersId;
	private Integer ORDRCUID;
	private Integer ORDRIUID;
	private Integer ORDRQNTY;
	private Integer ORDRPRIC;
	private Integer ORDRTTAX;
	private Integer ORDRTOTL;
	private boolean ORDRDELV;
	
	public Orders() {
		
	}
	
	public Orders(Integer oRDROUID, Integer oRDRCUID, Integer oRDRIUID, Integer oRDRQNTY, Integer oRDRPRIC,
			Integer oRDRTTAX, Integer oRDRTOTL, boolean oRDRDELV) {
		super();
		ordersId = oRDROUID;
		ORDRCUID = oRDRCUID;
		ORDRIUID = oRDRIUID;
		ORDRQNTY = oRDRQNTY;
		ORDRPRIC = oRDRPRIC;
		ORDRTTAX = oRDRTTAX;
		ORDRTOTL = oRDRTOTL;
		ORDRDELV = oRDRDELV;
	}
	
	@Override
	public String toString() {
		return "orders [ordersId=" + ordersId + ", ORDRCUID=" + ORDRCUID + ", ORDRIUID=" + ORDRIUID + ", ORDRQNTY="
				+ ORDRQNTY + ", ORDRPRIC=" + ORDRPRIC + ", ORDRTTAX=" + ORDRTTAX + ", ORDRTOTL=" + ORDRTOTL
				+ ", ORDRDELV=" + ORDRDELV + "]";
	}
	public Integer getordersId() {
		return ordersId;
	}
	public void setordersId(Integer oRDROUID) {
		ordersId = oRDROUID;
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
	public Integer getORDRPRIC() {
		return ORDRPRIC;
	}
	public void setORDRPRIC(Integer oRDRPRIC) {
		ORDRPRIC = oRDRPRIC;
	}
	public Integer getORDRTTAX() {
		return ORDRTTAX;
	}
	public void setORDRTTAX(Integer oRDRTTAX) {
		ORDRTTAX = oRDRTTAX;
	}
	public Integer getORDRTOTL() {
		return ORDRTOTL;
	}
	public void setORDRTOTL(Integer oRDRTOTL) {
		ORDRTOTL = oRDRTOTL;
	}
	public boolean isORDRDELV() {
		return ORDRDELV;
	}
	public void setORDRDELV(boolean oRDRDELV) {
		ORDRDELV = oRDRDELV;
	}
	
	
	
}
