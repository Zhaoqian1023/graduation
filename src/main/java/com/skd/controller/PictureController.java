/**  
 * @Title: PictureController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月4日
 */
package com.skd.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.skd.base.BaseController;
import com.skd.common.ResponseResult;
import com.skd.fastdfs.FastDFSService;
import com.skd.pojo.Image;
import com.skd.service.MedicalService;
import com.skd.service.PictureService;
import com.skd.utils.PropertiesUtil;

/**
 * ClassName: PictureController
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月4日
 */
@Controller("pictureController")
@RequestMapping("/picture")
public class PictureController extends BaseController{

	Logger logger = LoggerFactory.getLogger(PictureController.class);
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private MedicalService medicalService;
	/**
	 * 图片上传接口，返回图片URL
	 * @Description: TODO
	 * @param @param uploadFile
	 * @return Map<String,Object>  
	 * @author zhaoqian
	 * @date 2018年5月5日
	 */
	@RequestMapping(value = "uploadPicture",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadPicture(
			 @RequestParam(required = true)MultipartFile upfile) {
		Map<String, Object> data = new HashMap<String, Object>();
		Properties proper = new Properties();
		String ImageURL = "";
		try {
			proper = PropertiesUtil.getConfigProperties();
		} catch (Exception e) {
			logger.info("读取properties配置文件异常，" + e.getMessage());
			return null;
		}
		ImageURL = proper.getProperty("image_url");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = FastDFSService.upload(upfile);
		if (resultMap.get("code").equals("0000")) {
			ImageURL = ImageURL + resultMap.get("group") + "/"
					+ resultMap.get("msg");
			data.put("state", "SUCCESS");
			data.put("url", ImageURL);
			data.put("title", upfile.getName());
			data.put("original", upfile.getOriginalFilename());
			data.put("type", upfile.getContentType());
			data.put("size", upfile.getSize());
			
		} else {
			data.put("state", "ERROR");
		}
		return data;
	}
	/**
	 * 图片上传接口，返回图片ID，用于商品轮播图
	 * @Description: TODO
	 * @param @param uploadFile
	 * @return String  
	 * @author zhaoqian
	 * @date 2018年5月28日
	 */
	@RequestMapping(value = "upload",method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam("file")MultipartFile uploadFile,HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		Properties proper = new Properties();
		String ImageURL = "";
		try {
			proper = PropertiesUtil.getConfigProperties();
		} catch (Exception e) {
			logger.info("读取properties配置文件异常，" + e.getMessage());
			return null;
		}
		ImageURL = proper.getProperty("image_url");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = FastDFSService.upload(uploadFile);
		if (resultMap.get("code").equals("0000")) {
			ImageURL = ImageURL + resultMap.get("group") + "/"
					+ resultMap.get("msg");
			Image image = new Image();
			image.setImageUrl(ImageURL);
			int pictureKey = pictureService.savePicture(image);
			data.put("state", "SUCCESS");
			data.put("url", pictureKey);
			data.put("title", uploadFile.getOriginalFilename());
			data.put("original", uploadFile.getOriginalFilename());
			return JSONObject.toJSONString(data);
		} else {
			return null;
		}
		
	}
	@RequestMapping(value = "saveLocal",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult saveLocal(MultipartFile uploadFile){
		ResponseResult responseResult = new ResponseResult();
        /**
         * 获取Servlet的运行路径下的imgs文件夹作为上传图片的存储路径
         */
		logger.info("上传图片---------------"+uploadFile.getOriginalFilename());
        String path = request.getSession().getServletContext().getRealPath("/tempImags");
        System.out.println("path------------"+path);
        

		/**
		 * 检查图片存储路径是否存在，如果不存在，创建路径
		 */
        File uploadRootDir = new File(path);
        if(!uploadRootDir.exists())
            uploadRootDir.mkdirs();

        /**
         * 获取源文件的文件名
         */
        String fileName = uploadFile.getOriginalFilename();
        String uri = path+"\\"+fileName;
        

        /**
         * 创建目标文件，制定文件存储路径和文件名
         */
        File targetFile = new File(uri);
        System.out.println("uri--------"+uri);

        if(fileName!=null&&fileName.length()>0){
            try {
            	/**
            	 * 将源文件转移到目标文件，使用transferTo方法
            	 */
            	uploadFile.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String imagePath = uri.replace("\\\\", "\\").replace("\\", "/");
        System.out.println("imagePath="+imagePath);
        Map<String, Object> data = medicalService.diagnosis(imagePath);
        responseResult.setData(data);
		return responseResult;
	}
	
	

}
