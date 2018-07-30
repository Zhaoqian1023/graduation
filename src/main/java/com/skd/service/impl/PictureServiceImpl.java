/**  
 * @Title: PictureServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
package com.skd.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.dao.PictureDao;
import com.skd.pojo.Image;
import com.skd.service.PictureService;

/**
 * ClassName: PictureServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
@Service("pictureServiceImpl")
public class PictureServiceImpl implements PictureService {
	Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);
	@Autowired
	private PictureDao pictureDao;

	/* (non-Javadoc)
	 * @see com.skd.service.PictureService#savePicture(com.skd.pojo.Image)
	 */
	public int savePicture(Image image) {
		pictureDao.insertSelective(image);
		return image.getImageId();
	}

}
