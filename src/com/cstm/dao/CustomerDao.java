package com.cstm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cstm.domain.Customer;
import com.jdbc.TxQueryRunner;

/**
 * to manupulate Domain layer
 * 
 * @author Gloria
 * 
 */
public class CustomerDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * add customer
	 */
	public void addUser(Customer c) {
		try {
			String sql = "insert into t_customer values(?,?,?,?,?,?,?);";
			Object[] params = { c.getCid(), c.getCname(), c.getGender(),
					c.getBirthday(), c.getCellphone(), c.getEmail(),
					c.getDescription() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * find all customers in database
	 */
	public List<Customer> findUser() {
		try {
			String sql = "select * from t_customer;";
			return qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	

	/**
	 * load customers information
	 * @param cid
	 * @return
	 */
	public Customer load(String cid) {
		try{
		String sql="select * from t_customer where cid=?;";
		return qr.query(sql, new BeanHandler<Customer>(Customer.class),cid);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}


	
	/**
	 * edit customer information
	 * @param cstm
	 */
	public void edit(Customer c) {
		try{
		String sql="update t_customer set cname=?,gender=?,birthday=?,cellphone=?," +
				"email=?,description=? where cid=?;";
		Object[] params = { c.getCname(), c.getGender(),
				c.getBirthday(), c.getCellphone(), c.getEmail(),
				c.getDescription(),c.getCid()};
		qr.update(sql,params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}


	public void delete(String cid) {
		try{
		String sql="delete from t_customer where cid=?;";
		Object[] params={cid};
		qr.update(sql,params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}


	
	
	/**
	 * ��������ϲ�ѯ
	 * @param criteria
	 * @return
	 */
	public List<Customer> query(Customer criteria) {
	
		try{
		/*
		 * 1.��sqlģ��
		 * 2.������
		 * 3.����query������ʹ�ý����������:BeanListHandler
		 */
		/*
		 * һ.��sqlģ��
		 * ��.������
		 */
		/*
		 * 1.��sql���ǰ�벿��
		 */
		StringBuilder sql=new StringBuilder("select * from t_customer where 1=1 ");
		/*
		 * 2.�ж������������sql��׷��where�Ӿ�
		 */
		/*
		 * 3.����ArrayList����װ�ز���
		 */
		List<Object> params=new ArrayList<Object>();
		String 	cname=criteria.getCname();
		if(cname!=null && !cname.trim().isEmpty()){
			sql.append(" and cname like ?");
			params.add("%"+cname+"%");
		}
		
		String 	gender=criteria.getGender();
		if(gender!=null && !gender.trim().isEmpty()){
			sql.append(" and gender=?");
			params.add(gender);
		}
		
		String 	cellphone=criteria.getCellphone();
		if(cellphone!=null && !cellphone.trim().isEmpty()){
			sql.append(" and cellphone=?");
			params.add(cellphone);
		}
		
		String 	email=criteria.getEmail();
		if(email!=null && !email.trim().isEmpty()){
			sql.append(" and email=?");
			params.add(email);
		}
		
		/*
		 * ��.����BeanListHandler
		 */
		return qr.query(sql.toString(), 
				new BeanListHandler<Customer>(Customer.class),
				params.toArray());
		}catch(Exception e){
			throw new RuntimeException(e);
	}
}

}
