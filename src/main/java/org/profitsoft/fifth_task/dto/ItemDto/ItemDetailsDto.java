package org.profitsoft.fifth_task.dto.ItemDto;

import lombok.Builder;
import org.profitsoft.fifth_task.dto.storeDto.StoreDetailsDto;
import org.profitsoft.fifth_task.model.Store;

import java.util.Date;

@Builder
public class ItemDetailsDto {
    private int id;
    private String name;
    private Date modificationDate;
    private StoreDetailsDto store;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public StoreDetailsDto getStore() {
        return store;
    }

    public void setStore(StoreDetailsDto store) {
        this.store = store;
    }
}
