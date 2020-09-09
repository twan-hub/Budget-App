package com.grocerylist.app.models.data;

import com.grocerylist.app.models.GroceryList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GroceryListRepository extends CrudRepository<GroceryList,Integer> {

}
