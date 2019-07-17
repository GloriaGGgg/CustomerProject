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
		 * 1.��װ�����ݵ�customer������
		 * 2.��ȫsid��ʹ��uuid
		 * 3.ʹ��service����������
		 * 4.��request���б���ɹ���Ϣ
		 * 5.ת����msg.jsp��
		 */
		Customer c=CommonUtils.toBean(request.getParameterMap(), Customer.class);
		
		//��ʱ�����ݿ�û����������������������Ҫ�ô����Զ�������ȫ
		c.setCid(CommonUtils.uuid());
		
		customerService.add(c);
		request.setAttribute("msg", "Add Customer Successfully!");
		
		return "f:/msg.jsp";//���ת������Ϣҳ��	
	}
	
	
	
	/**
	 * check all customers information from database
	 */
	public String find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.����service�õ����пͻ�
		 * 2.���浽request��
		 * 3.ת����list.jsp��
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
		 * 1.��ȡcid
		 * 2.��cid����service�������õ�customer����
		 * 3.��customer���󱣴浽request����
		 * 4.ת����edit.jsp����ʾ�ڱ���
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
	 * 1.��װ�����ݵ�customer������
	 * 2.����service��������޸�
	 * 3.����ɹ���Ϣ��request����
	 * 4.ת����msg.jsp����ʾ�ɹ���Ϣ 
	 */
		Customer cstm=CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.edit(cstm);
		request.setAttribute("msg", "Congratulations! Edit Successfully!");
		return "f:/msg.jsp";
	}
	
	
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		/*
		 * 1.��ȡcid
		 * 2.��cid����service���������ɾ��
		 * 3.����ɹ���Ϣ��request����
		 * 4.ת����msg.jsp��ʾ�ɹ���Ϣ
		 */
		String cid=request.getParameter("cid");
		customerService.delete(cid);
		request.setAttribute("msg", "Congratulations! Delete Successfully!");
		return "f:/msg.jsp";
	}
	
	
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		/*
		 * 1.��װ�����ݵ�customer�����У�ֻ���ĸ����ԣ�cname,gender,cellphone,email
		 * 2.ʹ��customer����service�������õ�list<Customer>
		 * 3.���浽request����
		 * 4.ת����list.jsp��
		 */
		Customer criteria=CommonUtils.toBean(request.getParameterMap(), Customer.class);
		List<Customer> cstm=customerService.query(criteria);
		request.setAttribute("cstmList", cstm);
		return "f:/list.jsp";
		
	}

}
