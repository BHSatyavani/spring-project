package org.cap.demo.dao;



import org.cap.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("inventoryDao")
@Transactional

public interface IInventoryDao extends JpaRepository<Product,Integer>{

}
