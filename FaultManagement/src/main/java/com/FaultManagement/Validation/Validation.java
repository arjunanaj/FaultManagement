package com.FaultManagement.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	
	
	public Boolean isValidIp(String ip) throws Exception {

		String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";

		String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(ip);

		return m.matches();

	}


}
