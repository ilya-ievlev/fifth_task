package org.profitsoft.fifth_task.service.item_service.impl;

import jakarta.transaction.Transactional;
import org.profitsoft.fifth_task.dto.ItemDto.ItemDetailsDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemInformationDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemQueryDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemSaveDto;
import org.profitsoft.fifth_task.dto.storeDto.StoreDetailsDto;
import org.profitsoft.fifth_task.model.Item;
import org.profitsoft.fifth_task.model.Store;
import org.profitsoft.fifth_task.repository.ItemRepository;
import org.profitsoft.fifth_task.repository.StoreRepository;
import org.profitsoft.fifth_task.service.exceptions.NotFoundException;
import org.profitsoft.fifth_task.service.item_service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, StoreRepository storeRepository) {
        this.itemRepository = itemRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    @Transactional
    public void createItem(ItemSaveDto itemSaveDto) {
        validateItemSaveDto(itemSaveDto);
        Item item = new Item();
        updateItemFromDto(item, itemSaveDto);
        itemRepository.save(item);
    }

    @Override
    public ItemDetailsDto getItem(int id) {
        Item item = getItemOrThrow(id);
        return convertItemToDetails(item);
    }

    @Override
    @Transactional
    public void updateItem(int id, ItemSaveDto saveDto) {
        validateItemSaveDto(saveDto);
        Item updatedItem = convertSaveDtoToData(saveDto);
        itemRepository.update(id, updatedItem);
    }


    @Override
    public List<ItemInformationDto> search(ItemQueryDto queryDto) {
        validateQueryDto(queryDto);
        return itemRepository.search(queryDto).stream().map(this::toInformationDto).toList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        if(id<0){
            throw new IllegalArgumentException("you can't delete element with id < 0");
        }
        itemRepository.delete(id);
    }


    private void updateItemFromDto(Item item, ItemSaveDto itemSaveDto) {
        Store store = getStoreOrThrow(itemSaveDto.getStoreId());
        item.setName(itemSaveDto.getName());
        item.setStore(store);
    }

    private Item convertSaveDtoToData(ItemSaveDto saveDto) {
        Item item = new Item();
        Store store = getStoreOrThrow(saveDto.getStoreId());
        return new Item(saveDto.getName(), store);
    }

    private Item getItemOrThrow(int id) {
        Item item = itemRepository.get(id);
        if (item == null) {
            throw new NotFoundException("Item with id %d not found".formatted(id));
        }
        return item;
    }

    private Store getStoreOrThrow(int id) {
        Store store = storeRepository.get(id);
        if(store==null){
            throw new NotFoundException("Store with id %d not found".formatted(id));
        }
        return store;
    }

    private StoreDetailsDto convertStoreToDetails(Store store) {
        return StoreDetailsDto.builder()
                .id(store.getId())
                .name(store.getName())
                .build();
    }

    private ItemDetailsDto convertItemToDetails(Item item) {
        StoreDetailsDto storeDetailsDto = convertStoreToDetails(item.getStore());
        return ItemDetailsDto.builder()
                .id(item.getId())
                .name(item.getName())
                .modificationDate(item.getModificationDate())
                .store(storeDetailsDto)
                .build();
    }

    private ItemInformationDto toInformationDto(Item item) {
        return ItemInformationDto.builder()
                .id(item.getId())
                .name(item.getName())
                .storeName(item.getStore().getName())
                .build();
    }

    private void validateQueryDto(ItemQueryDto queryDto){
        if(queryDto.getName()==null){
            throw new IllegalArgumentException("you can't set item with null name");
        }
    }

    private void validateItemSaveDto(ItemSaveDto saveDto){
        if(saveDto.getName()==null){
            throw new IllegalArgumentException("you can't save or update item with null name");
        }
    }
}
