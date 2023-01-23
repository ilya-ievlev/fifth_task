package org.profitsoft.fifth_task.service.store_service.interfaces;

import org.profitsoft.fifth_task.dto.storeDto.StoreDetailsDto;

import java.util.List;

public interface StoreService {

    List<StoreDetailsDto> getAll();
}
