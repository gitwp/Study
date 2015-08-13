package com.wangp.web.action;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangp.web.beans.RetData;
import com.wangp.web.beans.User;

@Controller
@RequestMapping(value = "/test/")
public class ValidationAction {

	/**
	 * 数据验证demo
	 * @return
	 */
	@RequestMapping(value = "/submit")
	@ResponseBody
	public RetData submit(@Valid @RequestBody User user, BindingResult result) {
		RetData resp = new RetData();
		resp.addObject("succ", "操作成功");
		return resp;
	}
}
