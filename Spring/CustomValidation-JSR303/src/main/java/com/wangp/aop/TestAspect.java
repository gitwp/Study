package com.wangp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.wangp.web.beans.RetData;

public class TestAspect {
	MessageSource messageSource;
    
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		RetData resp = new RetData();
		
		if (args!=null && args.length>0) {
			String errMsg = "";
			for(Object arg : args){
				if(arg instanceof BindingResult) {
					BindingResult result = (BindingResult)arg;
					if (result.hasErrors()) {
						for (Object object : result.getAllErrors()) {
							if (object instanceof FieldError) {
								FieldError fieldError = (FieldError) object;
								
								System.out.println(fieldError.getCode());
						        System.out.println(messageSource.getMessage(fieldError, null));
						        
								String message = messageSource.getMessage(fieldError, null);
								errMsg+=message;
							}
						}
						resp.addObject("error", errMsg);
					} else {
						resp.addObject("succ", "操作成功");
					}

			        
			    }
			}
			
			if(errMsg!=null && !errMsg.isEmpty()){
				resp.addObject("error", errMsg);
				return resp;
			}else{
				Object retVal = pjp.proceed();
				return retVal;
			}
		} else {
			Object retVal = pjp.proceed();
			return retVal;
		}
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
}
