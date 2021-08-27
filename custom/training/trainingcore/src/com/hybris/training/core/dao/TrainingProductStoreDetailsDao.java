package com.hybris.training.core.dao;

import com.hybris.training.core.model.TrainingProductStoreDetailsModel;
import de.hybris.platform.servicelayer.internal.dao.Dao;

import java.util.List;

public interface TrainingProductStoreDetailsDao extends Dao {

   List<TrainingProductStoreDetailsModel> getProductstoreDetailsByCode(String storeId);
}
