package com.hybris.training.facades.storesImpl;

import com.hybris.training.core.model.TrainingProductStoreDetailsModel;
import com.hybris.training.core.services.TrainingProductDetailsService;
import com.hybris.training.facades.stores.TrainingProductStoreDetailsFacade;
import de.hybris.platform.commercefacades.product.data.TrainingProductDetailsData;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class TrainingProductStoreDetailsFacadeImpl implements TrainingProductStoreDetailsFacade {

    private TrainingProductDetailsService productDetailsService;
    private Converter<TrainingProductStoreDetailsModel, TrainingProductDetailsData> productStoreDetailsConverter;

    @Override
    public List<TrainingProductDetailsData> getProductStoreDetails(String storeId) {

        List<TrainingProductStoreDetailsModel> stores = getProductDetailsService().getProductDetailsByCode(storeId);
        List<TrainingProductDetailsData> list = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(stores)) {
            for (final TrainingProductStoreDetailsModel s1 : stores) {
                TrainingProductDetailsData details = getProductStoreDetailsConverter().convert(s1);
                list.add(details);
            }
        }
        return list;
    }

    public TrainingProductDetailsService getProductDetailsService() {
        return productDetailsService;
    }

    public void setProductDetailsService(TrainingProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    public Converter<TrainingProductStoreDetailsModel, TrainingProductDetailsData> getProductStoreDetailsConverter() {
        return productStoreDetailsConverter;
    }

    public void setProductStoreDetailsConverter(Converter<TrainingProductStoreDetailsModel, TrainingProductDetailsData> productStoreDetailsConverter) {
        this.productStoreDetailsConverter = productStoreDetailsConverter;
    }
}
