package com.springboot.entity;
/**
 * 封装服务端发送过来	判断是否登陆	的数据
 * @author 13391
 *
 */
public class TToken extends PublicEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2654150571723146807L;
	private String tokenStr;
	public String getTokenStr() {
		return tokenStr;
	}
	public void setTokenStr(String tokenStr) {
		this.tokenStr = tokenStr;
	}
	@Override
	public String toString() {
		return "TToken [tokenStr=" + tokenStr + "]";
	}
}
