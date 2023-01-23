package org.profitsoft.fifth_task.controller;

import org.profitsoft.fifth_task.dto.*;
import org.profitsoft.fifth_task.dto.ItemDto.ItemDetailsDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemInformationDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemQueryDto;
import org.profitsoft.fifth_task.dto.ItemDto.ItemSaveDto;
import org.profitsoft.fifth_task.service.item_service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items/")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ItemDetailsDto getItem(@PathVariable int id){
        return itemService.getItem(id);
    }

    @PostMapping
    public RestResponse createItem(@RequestBody ItemSaveDto dto){
        itemService.createItem(dto);
        return new RestResponse("ok");
    }

    @PatchMapping("/{id}")
    public RestResponse updateItem(@PathVariable int id, @RequestBody ItemSaveDto dto){
        itemService.updateItem(id, dto);
        return new RestResponse("ok");
    }

    @PostMapping("_search")
    public List<ItemInformationDto> search(@RequestBody ItemQueryDto queryDto){
        return itemService.search(queryDto);
    }

    @DeleteMapping("/{id}")
    public RestResponse deleteItem(@PathVariable int id){
        itemService.delete(id);
        return new RestResponse("ok");
    }
}
