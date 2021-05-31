/**
 *
 */
package com.hybris.training.core.suggestion.dao.impl;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.training.core.suggestion.dao.TrainingFindOldCartDao;


/**
 * @author vaibhavgupta03
 *
 */
public class TrainingFindOldCartDaoImpl implements TrainingFindOldCartDao
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Override
	public SearchResult<CartModel> getAllCarts(final int hours)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT {c:").append(CartModel.PK).append("} ");
		stringBuilder.append("FROM {").append(CartModel._TYPECODE).append(" AS c} ");
		stringBuilder.append("WHERE ").append("{c.creationTime} < SYSDATE - INTERVAL '");
		stringBuilder.append(hours).append("' HOUR");

		final FlexibleSearchQuery query = new FlexibleSearchQuery(stringBuilder.toString());
		return flexibleSearchService.search(query);


	}

}
