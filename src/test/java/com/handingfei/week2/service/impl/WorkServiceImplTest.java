package com.handingfei.week2.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.handingfei.util.NumberUtil;
import com.handingfei.util.StreamUtil;
import com.handingfei.util.StringUtil;
import com.handingfei.week2.domain.Work;
import com.handingfei.week2.service.WorkService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class WorkServiceImplTest {

	@Resource
	private WorkService workService;
	
	@Test
	public void testSelects() {
		
	}

	@Test
	public void testInsertBatch() throws UnsupportedEncodingException {
		
		List<Work> list = new ArrayList<Work>();
		
		List<String> list2 = StreamUtil.readLine(this.getClass().getResourceAsStream("/data.txt"));
	
		for (String string : list2) {
			
			Work work = new Work();
			String[] s = string.split("\\==");
			
			if (NumberUtil.isNumber(s[0])) {
				work.setId(Integer.valueOf(s[0]));
			}
			
			if (StringUtil.hasText(s[1])) {
				work.setKeywords(s[1]);
			}
			
			if (StringUtil.hasText(s[2])) {
				work.setDescription(s[2]);
			}
			
			if (StringUtil.hasText(s[3])) {
				work.setName(s[3]);
			}
			
			if (StringUtil.hasText(s[4])) {
				work.setCp(s[4]);
			}
			
			if (StringUtil.hasText(s[5])) {
				work.setAddress(s[5]);
			}
			
			if (StringUtil.hasText(s[6])) {
				if (NumberUtil.isNumber(s[6])) {
					work.setMoney(s[6]);
				}
			}
			
			if (StringUtil.hasText(s[7])) {
				work.setCreated(s[7]);
			}
			
			/*
			 * if (StringUtil.hasText(s[8])) { work.setYear(s[8]); } else {
			 * work.setYear("0"); }
			 */
			
			/*
			 * if (StringUtil.hasText(s[9])) { work.setYeartype(s[9]); } else {
			 * work.setYeartype(""); }
			 */
			
			work.setYeartype(s[9]);
			
			
			
			list.add(work);
		}
		workService.insertBatch(list);
	}

}
