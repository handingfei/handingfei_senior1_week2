package com.handingfei.week2.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.handingfei.week2.domain.Work;
import com.handingfei.week2.service.WorkService;
import com.handingfei.week2.util.PageUtil;
import com.handingfei.week2.vo.WorkVo;

@Controller
public class WorkController {

	@Resource
	private WorkService workService;
	
	@RequestMapping("works")
	public String selects(HttpServletRequest request,WorkVo vo,
			@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "3")Integer pageSize) {
		
		PageInfo<Work> info = workService.selects(vo,page,pageSize);
		PageUtil.page(request, "/works", pageSize, info.getList(), (int)info.getTotal(), page);
		
		request.setAttribute("works", info.getList());
		request.setAttribute("vo", vo);
				
		return "works";
	}
	
	@GetMapping("add")
	public String add() {
		return "add";
	}
	
	@PostMapping("add")
	@ResponseBody
	public boolean insert( int id) {
		
		return workService.insert(id)>0;
	}
	
	@RequestMapping("selectbywork")
	@ResponseBody
	public Object selectbywork(Model m,int id) {
		
		List<Work> list = workService.selectbywork(id);
		
		m.addAttribute("obj", list);
		
		return m;
	}
	
}
