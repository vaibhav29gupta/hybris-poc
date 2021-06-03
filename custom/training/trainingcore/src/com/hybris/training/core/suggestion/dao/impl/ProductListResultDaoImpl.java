/**
 *
 */
package com.hybris.training.core.suggestion.dao.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.daos.impl.DefaultProductDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import com.hybris.training.core.suggestion.dao.ProductListResultDao;


/**
 * @author vaibhavgupta03
 *
 */
public class ProductListResultDaoImpl extends DefaultProductDao implements ProductListResultDao
{

	/**
	 * @param typecode
	 */
	public ProductListResultDaoImpl(final String typecode)
	{
		super(typecode);
	}

	@Override
	public SearchResult<ProductModel> findProductsByFirstLetter()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT {p:").append(ProductModel.PK).append("} ");
		stringBuilder.append("FROM {").append(ProductModel._TYPECODE).append(" AS p} ");
		stringBuilder.append("WHERE ").append("{p.code} like '1%'");

		final FlexibleSearchQuery query = new FlexibleSearchQuery(stringBuilder.toString());
		return getFlexibleSearchService().search(query);
	}

}
