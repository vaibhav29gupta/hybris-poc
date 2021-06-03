/**
 *
 */
package com.hybris.training.core.suggestion.dao;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.servicelayer.search.SearchResult;


/**
 * @author vaibhavgupta03
 *
 */
public interface TrainingFindOldCartDao
{

	/**
	 * @param integer
	 * @return
	 */
	SearchResult<CartModel> getAllCarts(int hours);

}
