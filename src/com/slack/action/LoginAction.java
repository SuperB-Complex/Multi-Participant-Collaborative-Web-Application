package com.slack.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.slack.dao.CustomerDAO;

import net.sf.json.JSONObject;

import java.util.List;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginAction extends ActionSupport {
	//private boolean isEmail;
	//private String nickNameOrUserEmail;
	//private String passWord;
	private CustomerDAO ctmDao;
	//private HttpServletRequest request;
	private String result;
	
	private final static String KEY = "abcdef0123456789";
	private final static  String VECTOR = "0123456789abcdef";

	private static final Logger log = LoggerFactory.getLogger(CustomerDAO.class);
	
	//还没做正则判断是用户名还是邮箱 
	public void login() {
		JSONObject jsonobj = new JSONObject();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		int isEmail_int = Integer.parseInt(request.getParameter("isEmail"));
		String nickNameOrUserEmail = request.getParameter("nickNameOrUserEmail"), passWord = request.getParameter("passWord");
		System.out.println("enter action login function");
		
		System.out.println("before ctmDao");
		List<Object[]> t = ctmDao.login(isEmail_int, nickNameOrUserEmail, passWord);
		System.out.println("after ctmDao");		
		if(t != null && t.size() > 0){
			
			System.out.println("login SUCCESS");
			
			log.debug("login SUCCESS");
			result = loginPartCore((String)t.get(0)[1], t.get(0)[0].toString()).toString();			
		} else {
			
			System.out.println("login ERROR");
			
			//log.debug("login ERROR");
			result = loginPartCore((String)t.get(0)[1], aesEncrypt(t.get(0)[0].toString())).put("res", false).toString();
		}
		
		/*HttpSession session_from_request = request.getSession(); 
		System.out.println("session_from_request : " + session_from_request.toString());
		if (session_from_request.getAttribute("lastTimeLogin") == null) {
			System.out.println("FIRST!!!!!!!!!!!!!TIME!!!!!!!!!!!!!!!!!!!!");
			session_from_request.setAttribute("lastTimeLogin", System.currentTimeMillis());
		} else {
			
		}*/

		writeFrontEnd(result);
	}
	
	public JSONObject loginPartCore (String t1, String t2) {
		
		System.out.println("enter action loginPartCore function");
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("res", true);
		
		Map<String, Object> session_from_context = ServletActionContext.getContext().getSession();
		String lastTimeLogin = (String) session_from_context.get("lastTimeLogin"), nm = "sk_" + aesEncrypt(t1), 
				identity = (String) session_from_context.get(nm), iv = t2;
		System.out.println("lastTimeLogin  =  " + lastTimeLogin);
		System.out.println("nm  =  " + nm);
		System.out.println("identity  =  " + identity);
		System.out.println("iv  =  " + iv);
		if (identity == null) {
			System.out.println("FIRST!!!!!!!!!!!!!TIME!!!!!!!!!!!!!!!!!!!!");
			session_from_context.put(nm, iv);
			jsonobj.put("state", true);
		} else {
			System.out.println("NOT FIRST!!!!!!!!!!!!!TIME!!!!!!!!!!!!!!!!!!!!");
			jsonobj.put("state", false);
		}
		session_from_context.put("lastTimeLogin", timeStampConvertDateFromat(System.currentTimeMillis(), null));
		
		return jsonobj;
	}
			
	public void inputExist() {
		
		System.out.println("enter action inputExist function");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String isEmail = request.getParameter("isEmail");
		String nickNameOrUserEmail = request.getParameter("nickNameOrUserEmail");		
		System.out.println("in function inputExist username:" + nickNameOrUserEmail);	
		inputExistCore(isEmail, nickNameOrUserEmail);
	}
	
	public void inputExistCore(String isEmail, String nickNameOrUserEmail) {	
		
		System.out.println("enter action inputExistCore function");
		
		boolean t = ctmDao.inputExist(isEmail, nickNameOrUserEmail);
		System.out.println("after ctmDao " + t);
		try {
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("res", false);
			if(t == true){
				System.out.println("inputExistCore SUCCESS");
				jsonobj.put("res", true);
				result = jsonobj.toString();
			} else {
				System.out.println("inputExistCore ERROR");
				result = "[]";
			}
			System.out.println("the result of function inputExistCore is " + result);
			
			writeFrontEnd(result);
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void alreadyLogged() {
		
		System.out.println("enter action alreadyLogged function");
		
		JSONObject jsonobj = new JSONObject();
		
		Map<String, Object> session_from_context = ServletActionContext.getContext().getSession();
		Map<String, String> has = new HashMap();
		for (Map.Entry<String, Object> entry : session_from_context.entrySet()) {
			if (entry.getKey().startsWith("sk_")) {
				String t = entry.getKey();
				has.put(t.substring(0, 3) + aesDecrypt(t.substring(3)), (String)entry.getValue());
			}
		}
		
		jsonobj.putAll(has);
		result = jsonobj.toString();
		System.out.println("the result of function alreadyLogged is " + result);
		
		writeFrontEnd(result);
	}
	
	public void autoLogin() {
		
		System.out.println("enter action autoLogin function");
		
		JSONObject jsonobj = new JSONObject();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String nickNameOrUserEmail = request.getParameter("nickNameOrUserEmail"), uid = request.getParameter("uid");		
		
		result = loginPartCore(nickNameOrUserEmail, uid).toString();	
		writeFrontEnd(result);
	}

	/*public boolean isEmail() {
		return isEmail;
	}

	public String getNickNameOrUserEmail() {
		return nickNameOrUserEmail;
	}

	public String getPassWord() {
		return passWord;
	}*/

	public CustomerDAO getCtmDao() {
		return ctmDao;
	}
	
	public String getResult() {
		return result;
	}

	/*public void setEmail(boolean isEmail) {
		this.isEmail = isEmail;
	}

	public void setNickNameOrUserEmail(String nickNameOrUserEmail) {
		this.nickNameOrUserEmail = nickNameOrUserEmail;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}*/

	public void setCtmDao(CustomerDAO customerDao) {
		this.ctmDao = customerDao;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public void writeFrontEnd(String result) {
		
		System.out.println("enter action writeFrontEnd function");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(result);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
			System.out.println("-----------------------------writeFrontEnd function is wrong");
			
			e1.printStackTrace();
			//throw new RuntimeException();
		}	
	}
	
	public String timeStampConvertDateFromat(Long secondsl,String format) { 
		secondsl /= 1000;
		String seconds = String.valueOf(secondsl);
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
            return "";  
        }  
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }   
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        return sdf.format(new Date(Long.valueOf(seconds+"000")));  
    }
	
	public String aesEncrypt(String s) {
		String result = "";
		try {
			Cipher cipher;
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] raw = KEY.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			IvParameterSpec iv = new IvParameterSpec(VECTOR.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(s.getBytes("utf-8"));
			result = new BASE64Encoder().encode(encrypted);
		} catch (Exception e) {
			System.out.print("--------------- encrypt wrong!");
			//e.printStackTrace();
		} 
		return result;
				
	}
	
	public String aesDecrypt(String s) {
		try {
			byte[] raw = KEY.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(VECTOR.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(s);
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			System.out.print("---------------aes decrypt wrong!");
			//ex.printStackTrace();
			return s;
		}
	}
	
	public String md5Encode(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
        	System.out.print("---------------md5 decrypt wrong!");
            //throw new RuntimeException(e);
        	return s;
        }
    }
	
}
