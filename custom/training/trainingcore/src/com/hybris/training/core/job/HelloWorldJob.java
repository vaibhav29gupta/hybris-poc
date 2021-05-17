/**
 *
 */
package com.hybris.training.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import com.hybris.training.core.model.HelloWorldCronJobModel;


/**
 * @author vaibhavgupta03
 *
 */
public class HelloWorldJob extends AbstractJobPerformable<HelloWorldCronJobModel>
{

	@Override
	public PerformResult perform(final HelloWorldCronJobModel helloWorldCronJobModel)
	{
		try
		{

			final String firstName = helloWorldCronJobModel.getFirstName();
			System.out.println(firstName);
			return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}

		catch (final Exception e)
		{
			System.out.println("Exception= " + e);
			return new PerformResult(CronJobResult.ERROR, CronJobStatus.ABORTED);
		}
	}

}
