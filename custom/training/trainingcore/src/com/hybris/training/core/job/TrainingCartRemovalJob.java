/**
 *
 */
package com.hybris.training.core.job;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.search.SearchResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.training.core.model.TrainingOldCartRemovalJobModel;
import com.hybris.training.core.suggestion.dao.TrainingFindOldCartDao;


/**
 * @author vaibhavgupta03
 *
 */
public class TrainingCartRemovalJob extends AbstractJobPerformable<TrainingOldCartRemovalJobModel>
{
	@Autowired
	private TrainingFindOldCartDao findOldCartDao;

	private final Logger LOG = Logger.getLogger(TrainingCartRemovalJob.class);

	@Override
	public PerformResult perform(final TrainingOldCartRemovalJobModel cronjobModel)
	{
		LOG.info("We are fetching the available carts ");
		final SearchResult<CartModel> searchResult = findOldCartDao.getAllCarts(cronjobModel.getHours());

		searchResult.getResult().stream().forEach(this::removeOldCarts);
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	protected void removeOldCarts(final CartModel cartModel)
	{
		LOG.info(cartModel.getCode() + "The Cart has been removed. ");
		modelService.remove(cartModel);
	}

}
