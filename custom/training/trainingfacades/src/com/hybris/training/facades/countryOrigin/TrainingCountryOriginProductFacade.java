package com.hybris.training.facades.countryOrigin;

import de.hybris.platform.commercefacades.product.data.ProductData;

public interface TrainingCountryOriginProductFacade  {

    ProductData getCountryOriginProductDetails(String productCode);
}
