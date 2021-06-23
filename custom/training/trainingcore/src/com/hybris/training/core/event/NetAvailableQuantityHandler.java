/**
 *
 */
package com.hybris.training.core.event;

import de.hybris.platform.core.model.product.ProductModel;

import com.sun.tools.javac.util.StringUtils;


/**
 * @author vaibhavgupta03
 *
 */
public class NetAvailableQuantityHandler
{

	@Override
	public String get(final ProductModel productModel)
	{
		if (null != productModel.getAvailableQuantity() && null != productModel.getReservedQuantity())
		{
			return String.valueOf(
					Integer.parseInt(productModel.getAvailableQuantity()) - Integer.parseInt(productModel.getReservedQuantity()));
		}
		return StringUtils.EMPTY;
	}

	@Override
	public void set(final ProductModel model, final String s)
	{

	}
}
