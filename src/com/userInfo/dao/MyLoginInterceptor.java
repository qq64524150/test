package com.userInfo.dao;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyLoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		ActionContext ctx=arg0.getInvocationContext();
		Map session=ctx.getSession();
		if(session.get("loginName")==null)
			return "loginError";
		return arg0.invoke();
	}
}




