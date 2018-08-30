package com.sdyy.springboot.cs.controller;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {
	
/**
 * 验证判断
 * @param request
 * @param response
 * @return
 */
	@RequestMapping(value="login.action")
	public void login(HttpServletRequest request,HttpSession session,PrintWriter out){
		boolean flag=true;
		String yzm=request.getParameter("yzm");
		String imgyzm=session.getAttribute("validateCode").toString();
		System.out.println(yzm+"========="+imgyzm);
		if(!yzm.equalsIgnoreCase(imgyzm)){
			flag=false;
			out.print(flag);
		}else{
			flag=true;
			out.print(flag);
		}
	}
	@RequestMapping(value="login1.action")
	public void login1(HttpServletRequest request,HttpSession session,PrintWriter out){
		boolean flag=true;
		int numyzm=Integer.parseInt(request.getParameter("numyzm"));
		int result=Integer.parseInt(session.getAttribute("result").toString());
		System.out.println(numyzm+"========="+result);
		if(numyzm!=result){
			flag=false;
			out.print(flag);
		}else{
			flag=true;
			out.print(flag);
		}
	}
	@RequestMapping(value="login2.action")
	public void login2(HttpServletRequest request,HttpSession session,PrintWriter out){
		boolean flag=true;
		
		String text = request.getParameter("textyzm");
		try {
			String textyzm = java.net.URLDecoder.decode(text,"UTF-8");
			String result=session.getAttribute("validateCode").toString();
			System.out.println(textyzm+"========="+result);
			if(!textyzm.equals(result)){
				flag=false;
				out.print(flag);
			}else{
				flag=true;
				out.print(flag);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		/*String textyzm=request.getParameter("textyzm");
		
		System.out.println("textyzm==="+textyzm);
		String result=session.getAttribute("validateCode").toString();
		System.out.println(textyzm+"========="+result);*/
		/*if(textyzm!=result){
			flag=false;
			out.print(flag);
		}else{
			flag=true;
			out.print(flag);
		}*/
	}
	
/**
 * 字母验证码
 * @param session
 * @param resp
 */
	@RequestMapping(value="yzm.action")
	public void Yzm(HttpSession session,PrintWriter out){
		
	    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',      
	            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',      
	            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        // 创建一个随机数生成器类
        Random random = new Random();      
 
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。      
        StringBuffer randomCode = new StringBuffer();  
     
        // 随机产生codeCount数字的验证码。      
        for (int i = 0; i < 4; i++) {      
            // 得到随机产生的验证码数字。      
        	randomCode.append(codeSequence[random.nextInt(36)]);  
        }
        // 将四位数字的验证码保存到Session中。      
       session.setAttribute("validateCode", randomCode.toString());      
       out.print(randomCode.toString());
	}
/**
 * 算数式子验证码
 * @param session
 * @param out
 */
	@RequestMapping(value="numyzm.action")
	public void NumYzm(HttpSession session,PrintWriter out){
        // 创建一个随机数生成器类      
        Random random = new Random();      
 
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。      
        StringBuffer randomCode = new StringBuffer();  
     
        // 随机产生两个数字n1、n2
        int n1=(int) (Math.random()*10);
        int n2=(int) (Math.random()*10);
        String h=n1+"+"+n2+"=?";
        String c=n1+"-"+n2+"=?";
        String j=n1+"*"+n2+"=?";
        String s=n1+"/"+n2+"=?";
        String[] codeFh = {h,c,j,s};
        randomCode.append(codeFh[random.nextInt(4)]);
        String num=randomCode.toString();
        int result=0;
        //System.out.println("n1+n2="+(n1+n2));
        //判断随机式子和和、差、积、商、哪个式子相同，并计算出答案存在result中
        if(num.equals(h)){
        	result=(n1+n2);
        }else if(num.equals(c)){
        	result=(n1-n2);
        }else if(num.equals(j)){
        	result=(n1*n2);
        }else if(num.equals(s)){
        	result=(n1/n2);
        }else{
        	System.out.println("----error------");
        }
       // System.out.println(result+"============"+num);
        // 将随机式子保存到Session中。      
       session.setAttribute("validateCode", num);
       //将正确答案也保存在session中
       session.setAttribute("result", result);
       //返回式子
       out.print(num);
	}
	
/**
 * 汉字验证码
 * @param session
 * @param out
 */
	@RequestMapping(value="txtyzm.action")
	public void TxtYzm(HttpSession session,PrintWriter out){
		
		StringBuffer randomCode = new StringBuffer();  
		for (int i = 0; i < 4; i++) {
			int temp=(int)(Math.random()*10+10);
			char codeHz=(char)(0x4e00+temp);
			randomCode.append(codeHz);
		}
		/*String res=string2Unicode(randomCode.toString());
		System.out.println(randomCode.toString()+"-----"+res);*/
        // 将四位汉字的验证码保存到Session中
        session.setAttribute("validateCode", randomCode.toString());    
        out.print(randomCode.toString());
	}
}
