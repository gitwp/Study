package org.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beans.TbImage;
import org.common.MessageSourceAccessor;
import org.common.RespData;
import org.dao.TbImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadAction {
	@Autowired
	TbImageDao tbImageDao;
	@Autowired
	private MessageSourceAccessor msa;
	
	int name = 1000;

	@RequestMapping(value = "/upload")
	@ResponseBody
	public RespData upload(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model,
			HttpServletResponse response) {
		TbImage image = new TbImage();
		image.setName(name++ + "");
		try {
			image.setImages(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		tbImageDao.insert(image);
		response.setContentType("text/html;charset=UTF-8");
		
		RespData respData = new RespData();
		try {
			respData.addObject("msg",
					"上传成功");
			respData.setSuccess(msa);
		} catch (Exception e) {
			respData.setSysError(msa);
		}
		return respData;
	}

	@RequestMapping(value = "/image")
	public void getImage(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		 Map resultmap=new HashMap();
		 resultmap=tbImageDao.queryImage2(id);//数据库查询
		 oracle.sql.BLOB blob=(oracle.sql.BLOB)resultmap.get("IMAGE");
		response.setContentType("image/jpg;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		InputStream inStream = null;
		OutputStream op = null;
		byte[] data;
		long nLen = 0;

		try {
			try {
				inStream = blob.getBinaryStream();
				nLen = blob.length();
				int nSize = (int) nLen;
				data = new byte[nSize];
				inStream.read(data);// 将输入流中的数据读到数组中
				op = response.getOutputStream();
				op.write(data);// 直接显示到网页上
				op.flush();
				op.close();
				inStream.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (IOException e1) {
			System.out.println("获取图片数据失败,原因:" + e1.getMessage());
		}
	}
	
	
	@RequestMapping(value = "queryList")
	@ResponseBody
	public RespData queryList(@RequestBody TbImage query) {
		RespData respData = new RespData();
		try {
			respData.addObject("pagingData",
					tbImageDao.queryList(query));
			respData.setSuccess(msa);
		} catch (Exception e) {
			respData.setSysError(msa);
		}
		return respData;
	}
}
