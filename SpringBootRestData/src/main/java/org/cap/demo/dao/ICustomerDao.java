package org.cap.demo.dao;



import org.cap.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("customerDao")
@Transactional
public interface ICustomerDao extends JpaRepository<Customer,Integer>{

}
