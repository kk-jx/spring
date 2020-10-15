package org.springframework.research;

import org.python.google.common.hash.BloomFilter;
import org.python.google.common.hash.Funnels;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.research.dao.IndexDao;
import org.springframework.research.imports.GoodsManager;
import org.springframework.research.imports.UserManager;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create By Zhenli.Hu
 * Create Time 2019-07-30 10:44
 */
public class ResearchMain {

	public static void main(String[] args) throws Exception {

		/**
		 * 在父类org.springframework.context.support.GenericApplicationContext#GenericApplicationContext()构造函数中创建了org.springframework.beans.factory.support.DefaultListableBeanFactory工厂对象
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Class[] cla = new Class[]{org.springframework.research.config.AppConfig.class};
		context.register(org.springframework.research.config.AppConfig.class);
		context.refresh();

		IndexDao indexDao = (IndexDao) context.getBean("indexDao");
		UserManager userManager = (UserManager) context.getBean("org.springframework.research.imports.UserManager");
		GoodsManager goodsManager = (GoodsManager) context.getBean(GoodsManager.class);
		System.out.println("==============");
	}

	public void timeTest() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = dateFormat.format(sdf.parse("20190807"));
		String day = "20190807".substring(4);
	}

	public void bloomTest(){
		int count = 800000;
		BloomFilter<String> filter = BloomFilter.create(
				Funnels.stringFunnel(Charset.forName("UTF-8")),
				count,
				0.000001);

		BloomFilter<Integer> filter1 = BloomFilter.create(
				Funnels.integerFunnel(),
				count,
				0.000001);

		Long start  =System.currentTimeMillis();
		Map<String,String> map = new ConcurrentHashMap<String,String>(count);
		List<String> list = new ArrayList<>(count);
		for(int i=0;i<count;i++){
//			map.put(i+"",i+"");
			list.add(i+"");
			filter1.put(i);
		}
		long putEnd = System.currentTimeMillis();
		System.out.println("put 耗时："+(putEnd-start));
		for (int j=0;j<100;j++){
			start  =System.currentTimeMillis();
			int c = (int)Math.floor(Math.random()*100000);
			String val = map.get(c);
			boolean b = filter1.mightContain(c);
			long end = System.currentTimeMillis();
			System.out.println(c+"---"+b+"--get 耗时："+(end-start));
		}
	}

}
