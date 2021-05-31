/**
 *
 */
package com.hybris.training.core.job;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.search.SearchResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.training.core.suggestion.dao.ProductListResultDao;


/**
 * @author vaibhavgupta03
 *
 */
public class ProductListJobPerformable extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(ProductListJobPerformable.class);

	@Autowired
	private ProductListResultDao productListResultDao;

	@Override
	public boolean isAbortable()
	{
		// XXX Auto-generated method stub
		return true;
	}

	@Override
	public boolean isPerformable()
	{
		// XXX Auto-generated method stub
		return true;
	}

	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		LOG.info("this is before seraching..");
		final SearchResult<ProductModel> searchResult = productListResultDao.findProductsByFirstLetter();
		LOG.info("this is after seraching..");

		searchResult.getResult().stream().forEach(this::printProductCodes);
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	protected void printProductCodes(final ProductModel productModel)
	{
		LOG.info(productModel.getCode() + " " + productModel.getName());
	}
}
