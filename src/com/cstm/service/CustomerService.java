package com.cstm.service;

import java.util.List;

import com.cstm.dao.CustomerDao;
import com.cstm.domain.Customer;

/**
 * to deal with business
 * @author Gloria
 *
 */
public class CustomerService {
	private CustomerDao customerDao=new CustomerDao();
	
	public void add(Customer c){
		customerDao.addUser(c);
	}
	
	public List<Customer> findAll(){
		return customerDao.findUser();
	}

	public Customer load(String cid) {
		
		return customerDao.load(cid);
	}

	public void edit(Customer cstm) {
		customerDao.edit(cstm);
		
	}

	public void delete(String cid) {
		customerDao.delete(cid);
	}

	public List<Customer> query(Customer criteria) {
		return customerDao.query(criteria);
	}

}
