package org.profitsoft.fifth_task.service.item_service.interfaces;

import org.profitsoft.fifth_task.dto.ItemDto.ItemDetailsDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemInformationDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemQueryDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemSaveDto;

import java.util.List;

public interface ItemService {
    void createItem(ItemSaveDto itemSaveDto);

    ItemDetailsDto getItem(int id);

    void updateItem(int id, ItemSaveDto saveDto);

    List<ItemInformationDto> search(ItemQueryDto queryDto);

    void delete(int id);
}
