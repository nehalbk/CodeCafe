package com.codecafe.api.menu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Menu {
	@Id
	@Column(name="ITEMIUID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuId;
	private String ITEMNAME;
	private Integer ITEMPRIC;
	private String ITEMTYPE;
	private String ITEMTXTP;
	private boolean ITEMAVAIL;
	
	public Menu() {
		
	}
	public Menu(Integer menuId, String iTEMNAME, Integer iTEMPRIC, String iTEMTYPE, String iTEMTXTP, boolean iTEMAVAIL) {
		super();
		this.menuId = menuId;
		ITEMNAME = iTEMNAME;
		ITEMPRIC = iTEMPRIC;
		ITEMTYPE = iTEMTYPE;
		ITEMTXTP = iTEMTXTP;
		ITEMAVAIL = iTEMAVAIL;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getITEMNAME() {
		return ITEMNAME;
	}
	public void setITEMNAME(String iTEMNAME) {
		ITEMNAME = iTEMNAME;
	}
	public Integer getITEMPRIC() {
		return ITEMPRIC;
	}
	public void setITEMPRIC(Integer iTEMPRIC) {
		ITEMPRIC = iTEMPRIC;
	}
	public String getITEMTYPE() {
		return ITEMTYPE;
	}
	public void setITEMTYPE(String iTEMTYPE) {
		ITEMTYPE = iTEMTYPE;
	}
	public String getITEMTXTP() {
		return ITEMTXTP;
	}
	public void setITEMTXTP(String iTEMTXTP) {
		ITEMTXTP = iTEMTXTP;
	}
	public boolean isITEMAVAIL() {
		return ITEMAVAIL;
	}
	public void setITEMAVAIL(boolean iTEMAVAIL) {
		ITEMAVAIL = iTEMAVAIL;
	}
	@Override
	public String toString() {
		return "menu [menuId=" + menuId + ", ITEMNAME=" + ITEMNAME + ", ITEMPRIC=" + ITEMPRIC + ", ITEMTYPE=" + ITEMTYPE
				+ ", ITEMTXTP=" + ITEMTXTP + ", ITEMAVAIL=" + ITEMAVAIL + "]";
	}
	
	
	
	

}
