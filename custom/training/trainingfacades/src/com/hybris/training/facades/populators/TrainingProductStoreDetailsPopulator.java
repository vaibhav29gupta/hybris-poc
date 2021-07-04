package com.hybris.training.facades.populators;

import com.hybris.training.core.model.TrainingProductStoreDetailsModel;
import de.hybris.platform.commercefacades.product.data.TrainingProductDetailsData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class TrainingProductStoreDetailsPopulator implements Populator<TrainingProductStoreDetailsModel,TrainingProductDetailsData> {
    @Override
    public void populate(TrainingProductStoreDetailsModel source, TrainingProductDetailsData target) throws ConversionException {

        target.setStoreId(source.getStoreId());
        target.setStoreName(source.getStoreName());
        target.setStoreCity(source.getStoreCity());
        target.setStoreOwnerName(source.getStoreOwnerName());
    }

}
