/**
 *
 */
package com.hybris.training.core.suggestion.dao;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.SearchResult;


/**
 * @author vaibhavgupta03
 *
 */
public interface ProductListResultDao
{

	SearchResult<ProductModel> findProductsByFirstLetter();
}
