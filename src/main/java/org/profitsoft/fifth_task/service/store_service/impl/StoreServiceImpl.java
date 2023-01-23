package org.profitsoft.fifth_task.service.store_service.impl;

import org.profitsoft.fifth_task.dto.storeDto.StoreDetailsDto;
import org.profitsoft.fifth_task.model.Store;
import org.profitsoft.fifth_task.repository.StoreRepository;
import org.profitsoft.fifth_task.service.store_service.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<StoreDetailsDto> getAll(){
        List<Store> storeList = storeRepository.getAll();
        List<StoreDetailsDto> storeDetailsDtoList  = new ArrayList<StoreDetailsDto>();
        for(Store storeToConvert: storeList){
            storeDetailsDtoList.add(convertToDetails(storeToConvert));
        }
        return storeDetailsDtoList;
    }

    private StoreDetailsDto convertToDetails(Store store){
        return StoreDetailsDto.builder()
                .id(store.getId())
                .name(store.getName())
                .build();
    }
}
