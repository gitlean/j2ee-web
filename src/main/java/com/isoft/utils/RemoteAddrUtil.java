package com.isoft.utils;


import javax.servlet.http.HttpServletRequest;
/**
*@author anonymous
*@createTime 2019年11月6日 下午4:09:14
*@describe 
*/
public class RemoteAddrUtil {
	//get RemoteAddr by HttpServletRequest
	public static  String getRequestIpAddr(HttpServletRequest request){
		
        String requestIpAddr = request.getHeader("x-forwarded-for");
        
        if (requestIpAddr == null || requestIpAddr.length() == 0 || "unknown".equalsIgnoreCase(requestIpAddr)) {
        	requestIpAddr = request.getHeader("Proxy-Client-IP");
        }
        if (requestIpAddr == null || requestIpAddr.length() == 0 || "unknown".equalsIgnoreCase(requestIpAddr)) {
        	requestIpAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        if (requestIpAddr == null || requestIpAddr.length() == 0 || "unknown".equalsIgnoreCase(requestIpAddr)) {
        	requestIpAddr = request.getHeader("X-Real-IP");//nginx作为反向代理
        }
        
        if (requestIpAddr == null || requestIpAddr.length() == 0 || "unknown".equalsIgnoreCase(requestIpAddr)) {
        	requestIpAddr = request.getRemoteAddr();
        }

	    return requestIpAddr;
	}
}

