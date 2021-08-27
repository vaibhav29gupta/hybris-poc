package com.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.converters.populator.ProductPopulator;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;


public class TrainingProductCustomAttributesPopulator extends ProductPopulator implements Populator<ProductModel, ProductData>
{
	@Override
	public void populate(final ProductModel source, final ProductData target)
	{

		super.populate(source, target);

		target.setAvailableQuantity(source.getAvailableQuantity());
		target.setReservedQuantity(source.getReservedQuantity());
		target.setNetAvailableQuantity(source.getNetAvailableQuantity());
	}
}
