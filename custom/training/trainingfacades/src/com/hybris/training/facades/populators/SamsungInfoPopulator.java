package com.hybris.training.facades.populators;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import com.hybris.training.core.model.SamsungProductInfoModel;


/**
 *
 */

/**
 * @author vaibhavgupta03
 *
 */
public class SamsungInfoPopulator implements Populator<SamsungProductInfoModel, ProductData>
{

	@Override
	public void populate(final SamsungProductInfoModel source, final ProductData target) throws ConversionException
	{
		target.setProductColorDto(source.getProductColor());
	}

}
