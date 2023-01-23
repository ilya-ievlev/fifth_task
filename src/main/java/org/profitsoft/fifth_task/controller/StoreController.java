package org.profitsoft.fifth_task.controller;

import org.profitsoft.fifth_task.dto.storeDto.StoreDetailsDto;
import org.profitsoft.fifth_task.service.store_service.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stores/")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<StoreDetailsDto> getAll() {
        return storeService.getAll();
    }
}
