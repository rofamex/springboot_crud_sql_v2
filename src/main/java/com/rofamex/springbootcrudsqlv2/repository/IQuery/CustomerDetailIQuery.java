package com.rofamex.springbootcrudsqlv2.repository.IQuery;

import java.util.List;

import com.rofamex.springbootcrudsqlv2.dom.CustomerDetail;

public interface CustomerDetailIQuery {
	List<CustomerDetail> findByJoiningTable();
}
