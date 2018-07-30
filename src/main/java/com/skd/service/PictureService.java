/**  
 * @Title: PictureService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
package com.skd.service;

import com.skd.pojo.Image;

/**
 * ClassName: PictureService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
public interface PictureService {
	/**
	 * 保存上传的图片，返回图片主键
	 * @Description: TODO
	 * @param @param image
	 * @param @return   
	 * @return int  
	 * @author zhaoqian
	 * @date 2018年5月27日
	 */
	public int savePicture(Image image);

}
