package com.rofamex.springbootcrudsqlv2.service.IQuery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rofamex.springbootcrudsqlv2.entity.Customer;
import com.rofamex.springbootcrudsqlv2.repository.IQuery.CustomerDetailIQuery;

@Service
public class CustomerDetailService implements CustomerDetailIQuery {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerDetailService.class);

	@Autowired
	EntityManagerFactory emf;

	public List<Customer> findByEntityManagerJpql() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(""
				+ "SELECT c.name FROM Customer c "
				+ "INNER JOIN c.zipcode z");
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) query.getResultList();
		LOG.info(list.toString());
		em.close();

		return list;
	}
	
	public List<Customer> findByEntityManagerNativeQuery() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNativeQuery(""
				+ "SELECT c.id as customerId, z.id as zipcodeId FROM Customer c "
				+ "INNER JOIN zipcode z "
				+ "ON c.zipcode_id=z.id");
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) query.getResultList();
		LOG.info(list.toString());
		em.close();

		return list;
	}

}
