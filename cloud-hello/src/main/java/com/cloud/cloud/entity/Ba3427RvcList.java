package com.cloud.cloud.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Table(name = "")
public class Ba3427RvcList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String piaojuhm;//票据号码

	private Double shouxfje;//手续费金额

	private Double djiejine;//冻结金额

	private Double jiedjine;//解冻金额

	private List<Ba3427RvcList2> listnm02 = new ArrayList<Ba3427RvcList2>();//保证金冻结明细

	
	public String getPiaojuhm() {
		return piaojuhm;
	}
	public void setPiaojuhm(String piaojuhm) {
		this.piaojuhm = piaojuhm;
	}
	public Double getShouxfje() {
		return shouxfje;
	}
	public void setShouxfje(Double shouxfje) {
		this.shouxfje = shouxfje;
	}
	public Double getDjiejine() {
		return djiejine;
	}
	public void setDjiejine(Double djiejine) {
		this.djiejine = djiejine;
	}
	public Double getJiedjine() {
		return jiedjine;
	}
	public void setJiedjine(Double jiedjine) {
		this.jiedjine = jiedjine;
	}
	
	
	
}
