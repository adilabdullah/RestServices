package com.java.mapping;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Challan {
int sno,qty,pkts,ch_pkts;
String desc,addr,client,day,month,dat,cl_no;


@Override
public String toString() {
	return "Challan [sno=" + sno + ", qty=" + qty + ", pkts=" + pkts
			+ ", ch_pkts=" + ch_pkts + ", desc=" + desc + ", addr=" + addr
			+ ", client=" + client + ", day=" + day + ", month=" + month
			+ ", dat=" + dat + ", cl_no=" + cl_no + "]";
}

public Challan()
{}

public Challan(int sno, int qty, int pkts, int ch_pkts, String desc,
		String addr, String client, String day, String month, String dat,
		String cl_no) {
	super();
	this.sno = sno;
	this.qty = qty;
	this.pkts = pkts;
	this.ch_pkts = ch_pkts;
	this.desc = desc;
	this.addr = addr;
	this.client = client;
	this.day = day;
	this.month = month;
	this.dat = dat;
	this.cl_no = cl_no;
}
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public int getPkts() {
	return pkts;
}
public void setPkts(int pkts) {
	this.pkts = pkts;
}
public int getCh_pkts() {
	return ch_pkts;
}
public void setCh_pkts(int ch_pkts) {
	this.ch_pkts = ch_pkts;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public String getClient() {
	return client;
}
public void setClient(String client) {
	this.client = client;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getDat() {
	return dat;
}
public void setDat(String dat) {
	this.dat = dat;
}
public String getCl_no() {
	return cl_no;
}
public void setCl_no(String cl_no) {
	this.cl_no = cl_no;
}


}
