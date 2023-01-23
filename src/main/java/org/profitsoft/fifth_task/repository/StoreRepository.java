package org.profitsoft.fifth_task.repository;

import jakarta.persistence.EntityManager;
import org.profitsoft.fifth_task.model.Item;
import org.profitsoft.fifth_task.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreRepository {


    private final EntityManager entityManager;

    @Autowired
    public StoreRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Store> getAll() {
        return entityManager.createQuery("from Store", Store.class).getResultList();
    }

    public Store get(int id) {
        return entityManager.find(Store.class, id);
    }

    public void deleteAll(){
        entityManager.createQuery("delete from Store", Item.class).executeUpdate();
    }
}
