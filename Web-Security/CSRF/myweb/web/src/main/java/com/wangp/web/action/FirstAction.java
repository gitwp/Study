package com.wangp.web.action;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangp.web.beans.RetData;

@Controller
public class FirstAction {

	/**
	 * 获取当时日期
	 * 
	 * @return
	 */
	@RequestMapping(value = "/test")
	@ResponseBody
	public RetData getNowDate() {
		RetData resp = new RetData();
		resp.addObject("nowDate",new Date());
		return resp;
	}
}
