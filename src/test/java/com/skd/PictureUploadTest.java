/**  
 * @Title: PictureUploadTest.java
 * @Package com.skd
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月5日
 */
package com.skd;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.skd.dao.PictureDao;
import com.skd.fastdfs.FastDFSService;
import com.skd.pojo.Image;

/**
 * ClassName: PictureUploadTest 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月5日
 */
public class PictureUploadTest {
	@Test
	public void run(){
		testSavePicture();
	}
	
	public void testFastDfsClient() throws Exception {
        FastDFSService  client = new FastDFSService();
        ClassPathResource cpr = new ClassPathResource("fastdfs/fdfs_client.conf");
        System.out.print(cpr.getClassLoader().getResource("fastdfs/fdfs_client.conf").getPath());
		Map<String, Object> uploadFile = client.upload("D:\\00b8d1253af70d499ee6354d0262be06.jpg");
        System.out.println(uploadFile.toString());//返回的是文件的
    }
	public void testSavePicture(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		PictureDao pictureDao = (PictureDao) ctx.getBean("pictureDao");
		Image image = new Image();
		image.setImageUrl("http://img10.360buyimg.com/n1/s450x450_jfs/t4276/257/2416766721/125228/ba72a107/58d1d078N20e18b62.jpg");
		System.out.println(pictureDao.insertSelective(image));
		System.out.println(image.getImageId());
	}

}
