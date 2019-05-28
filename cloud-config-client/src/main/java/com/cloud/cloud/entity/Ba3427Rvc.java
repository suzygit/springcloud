package com.cloud.cloud.entity;

import java.util.ArrayList;
import java.util.List;


public class Ba3427Rvc{

	
	private static final long serialVersionUID = -6410959688538343044L;
	

	private Double shouxfje;//手续费金额

	private List<Ba3427RvcList> listnm01 = new ArrayList<Ba3427RvcList>();//手续费明细

	private Double djiejine;//冻结金额

	private List<Ba3427RvcList> listnm02 = new ArrayList<Ba3427RvcList>();//保证金冻结明细

	private Double jiedjine;//解冻金额

	private List<Ba3427RvcList> listnm03 = new ArrayList<Ba3427RvcList>();//保证金解冻明细

	private Double cduijine;//承兑金额


	private List<Ba3427RvcList> listnm04 = new ArrayList<Ba3427RvcList>();//承兑明细

	private Double piaomjee;//票面金额

	private List<Ba3427RvcList> listnm05 = new ArrayList<Ba3427RvcList>();//到期明细
	
	public Double getShouxfje() {
		return shouxfje;
	}
	public void setShouxfje(Double shouxfje) {
		this.shouxfje = shouxfje;
	}
	public List<Ba3427RvcList> getListnm01() {
		return listnm01;
	}
	public void setListnm01(List<Ba3427RvcList> listnm01) {
		this.listnm01 = listnm01;
	}
	public Double getDjiejine() {
		return djiejine;
	}
	public void setDjiejine(Double djiejine) {
		this.djiejine = djiejine;
	}
	public List<Ba3427RvcList> getListnm02() {
		return listnm02;
	}
	public void setListnm02(List<Ba3427RvcList> listnm02) {
		this.listnm02 = listnm02;
	}
	public Double getJiedjine() {
		return jiedjine;
	}
	public void setJiedjine(Double jiedjine) {
		this.jiedjine = jiedjine;
	}
	public List<Ba3427RvcList> getListnm03() {
		return listnm03;
	}
	public void setListnm03(List<Ba3427RvcList> listnm03) {
		this.listnm03 = listnm03;
	}
	public Double getCduijine() {
		return cduijine;
	}
	public void setCduijine(Double cduijine) {
		this.cduijine = cduijine;
	}
	public List<Ba3427RvcList> getListnm04() {
		return listnm04;
	}
	public void setListnm04(List<Ba3427RvcList> listnm04) {
		this.listnm04 = listnm04;
	}
	public Double getPiaomjee() {
		return piaomjee;
	}
	public void setPiaomjee(Double piaomjee) {
		this.piaomjee = piaomjee;
	}
	public List<Ba3427RvcList> getListnm05() {
		return listnm05;
	}
	public void setListnm05(List<Ba3427RvcList> listnm05) {
		this.listnm05 = listnm05;
	}

}
