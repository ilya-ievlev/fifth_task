package org.profitsoft.fifth_task.repository;

import jakarta.persistence.EntityManager;
import org.profitsoft.fifth_task.dto.ItemDto.ItemQueryDto;
import org.profitsoft.fifth_task.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ItemRepository {

    private final EntityManager entityManager;

    @Autowired
    public ItemRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Item get(int id) {
        return entityManager.find(Item.class, id);
    }

    public void save(Item item) {
        item.setModificationDate(new Date());
        entityManager.persist(item);
    }

    public void update(int id, Item updatedItem) {
        updatedItem.setId(id);
        updatedItem.setModificationDate(new Date());
        entityManager.merge(updatedItem);
    }

    public void delete(int id) {
        entityManager.createQuery("delete from Item i where i.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Item> search(ItemQueryDto queryDto) {
        return entityManager.createQuery("FROM Item where name=:itemName and store.id=:itemStoreId")
                .setParameter("itemName", queryDto.getName())
                .setParameter("itemStoreId", queryDto.getStoreId())
                .setFirstResult(queryDto.getPageFrom())
                .setMaxResults(queryDto.getPageSize())
                .getResultList();
    }

    public void deleteAll(){
        entityManager.createQuery("delete from Item", Item.class).executeUpdate();
    }

}
