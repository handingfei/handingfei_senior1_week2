package com.handingfei.week2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.handingfei.week2.domain.Work;
import com.handingfei.week2.vo.WorkVo;

public interface WorkMapper {

	List<Work> selects(WorkVo vo);

	int insertBatch(List<Work> list);

	int insert(@Param("id")int id);

	List<Work> selectbywork(@Param("id")int id);

}
