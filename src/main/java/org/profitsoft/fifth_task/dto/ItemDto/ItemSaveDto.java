package org.profitsoft.fifth_task.dto.ItemDto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public class ItemSaveDto {

    private String name;

    private int storeId; // TODO: 23-Jan-23 what if store id is not correct
    // TODO: 23-Jan-23 what if storeId is not listed in query

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
