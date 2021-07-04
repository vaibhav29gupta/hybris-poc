package com.hybris.training.core.ServicesImpl;

import com.hybris.training.core.dao.TrainingProductStoreDetailsDao;
import com.hybris.training.core.model.TrainingProductStoreDetailsModel;
import com.hybris.training.core.services.TrainingProductDetailsService;

import javax.annotation.Resource;
import java.util.List;

public class TrainingProductDetailsServiceImpl implements TrainingProductDetailsService {

    @Resource
    private TrainingProductStoreDetailsDao trainingProductStoreDetailsDao;

    @Override
    public List<TrainingProductStoreDetailsModel> getProductDetailsByCode(String storeId) {

       List<TrainingProductStoreDetailsModel> storeDetails= trainingProductStoreDetailsDao.getProductstoreDetailsByCode(storeId);
        return storeDetails;
    }
}
