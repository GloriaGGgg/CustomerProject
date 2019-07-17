package com.cstm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;

import com.cstm.domain.Customer;
import com.cstm.service.CustomerService;

public class CustomerServlet extends BaseServlet {

	private CustomerService customerService=new CustomerService();
	
	
	/**
	 * add customer function
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.封装表单数据到customer对象中
		 * 2.补全sid，使用uuid
		 * 3.使用service方法完成添加
		 * 4.向request域中保存成功信息
		 * 5.转发到msg.jsp中
		 */
		Customer c=CommonUtils.toBean(request.getParameterMap(), Customer.class);
		
		//有时候数据库没有设置自增，所以我们需要让代码自动帮它补全
		c.setCid(CommonUtils.uuid());
		
		customerService.add(c);
		request.setAttribute("msg", "Add Customer Successfully!");
		
		return "f:/msg.jsp";//最后转发到消息页面	
	}
	
	
	
	/**
	 * check all customers information from database
	 */
	public String find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.调用service得到所有客户
		 * 2.保存到request中
		 * 3.转发到list.jsp中
		 */
		request.setAttribute("cstmList", customerService.findAll());
		return "f:/list.jsp";
	}
	
	
	
	/*
	 * before edit, something have to deal with first
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		/*
		 * 1.获取cid
		 * 2.用cid调用service方法，得到customer对象
		 * 3.把customer对象保存到request域中
		 * 4.转发到edit.jsp中显示在表单中
		 */
		String cid=request.getParameter("cid");
		Customer cstm=customerService.load(cid);
		request.setAttribute("cstm", cstm);
		return "f:/edit.jsp";
	}
	
	
	/*
	 * when edit, something have to deal with first
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
	/**
	 * 1.封装表单数据到customer对象中
	 * 2.调用service方法完成修改
	 * 3.保存成功信息到request域中
	 * 4.转发到msg.jsp中显示成功信息 
	 */
		Customer cstm=CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.edit(cstm);
		request.setAttribute("msg", "Congratulations! Edit Successfully!");
		return "f:/msg.jsp";
	}
	
	
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		/*
		 * 1.获取cid
		 * 2.用cid调用service方法，完成删除
		 * 3.保存成功信息到request域中
		 * 4.转发到msg.jsp显示成功信息
		 */
		String cid=request.getParameter("cid");
		customerService.delete(cid);
		request.setAttribute("msg", "Congratulations! Delete Successfully!");
		return "f:/msg.jsp";
	}
	
	
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		/*
		 * 1.封装表单数据到customer对象中，只有四个属性：cname,gender,cellphone,email
		 * 2.使用customer调用service方法，得到list<Customer>
		 * 3.保存到request域中
		 * 4.转发到list.jsp中
		 */
		Customer criteria=CommonUtils.toBean(request.getParameterMap(), Customer.class);
		List<Customer> cstm=customerService.query(criteria);
		request.setAttribute("cstmList", cstm);
		return "f:/list.jsp";
		
	}

}
