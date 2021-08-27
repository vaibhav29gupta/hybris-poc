package com.hybris.training.facades.stores;


import de.hybris.platform.commercefacades.product.data.TrainingProductDetailsData;

import java.util.List;

public interface TrainingProductStoreDetailsFacade {

    List<TrainingProductDetailsData> getProductStoreDetails(String storeId);
}
