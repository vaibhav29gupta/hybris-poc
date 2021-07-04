package com.hybris.training.core.services;

import com.hybris.training.core.model.TrainingProductStoreDetailsModel;

import java.util.List;

public interface TrainingProductDetailsService {

    List<TrainingProductStoreDetailsModel> getProductDetailsByCode(String storeId);
}
