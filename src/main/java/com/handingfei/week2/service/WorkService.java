package com.handingfei.week2.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.handingfei.week2.domain.Work;
import com.handingfei.week2.vo.WorkVo;

public interface WorkService {

	PageInfo<Work> selects(WorkVo vo, Integer page, Integer pageSize);

	int insertBatch(List<Work> list);

	int insert(int id);

	List<Work> selectbywork(int id);

}
