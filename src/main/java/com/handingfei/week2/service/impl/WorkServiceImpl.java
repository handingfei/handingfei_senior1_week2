package com.handingfei.week2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.handingfei.week2.dao.WorkMapper;
import com.handingfei.week2.domain.Work;
import com.handingfei.week2.service.WorkService;
import com.handingfei.week2.vo.WorkVo;

@Service
public class WorkServiceImpl implements WorkService {

	@Resource
	private WorkMapper workMapper;

	@Override
	public PageInfo<Work> selects(WorkVo vo, Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<Work> list = workMapper.selects(vo);
		
		return new PageInfo<Work>(list);
	}

	@Override
	public int insertBatch(List<Work> list) {
		
		return workMapper.insertBatch(list);
	}

	@Override
	public int insert(int id) {
		
		return workMapper.insert(id);
	}

	@Override
	public List<Work> selectbywork(int id) {
		
		return workMapper.selectbywork(id);
	}
	
}
