package com.java.mapping;

public class ResponseMap {
int code;
String desc;



public ResponseMap() {
	super();
	// TODO Auto-generated constructor stub
}
public ResponseMap(int code, String desc) {
	super();
	this.code = code;
	this.desc = desc;
}
@Override
public String toString() {
	return "ResponseMap [code=" + code + ", desc=" + desc + "]";
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}

}
