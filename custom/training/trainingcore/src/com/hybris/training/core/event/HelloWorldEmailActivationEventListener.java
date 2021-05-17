/**
 *
 */
package com.hybris.training.core.event;

import de.hybris.platform.acceleratorservices.site.AbstractAcceleratorSiteEventListener;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.enums.SiteChannel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.keygenerator.KeyGenerator;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.util.ServicesUtil;

import org.springframework.beans.factory.annotation.Required;

import com.hybris.training.core.model.HelloWorldEmailProcessModel;


/**
 * @author vaibhavgupta03
 *
 */
public class HelloWorldEmailActivationEventListener extends AbstractAcceleratorSiteEventListener<HelloWorldEmailActivationEvent>
{

	private ModelService modelService;
	private KeyGenerator processCodeGenerator;
	private BusinessProcessService businessProcessService;

	@Override
	protected void onSiteEvent(final HelloWorldEmailActivationEvent event)
	{
		final HelloWorldEmailProcessModel helloWorldEmailProcessModel = getBusinessProcessService()
				.createProcess(
						"helloWorldEmail-"
								+ event.getCart().getCode() + "-" + processCodeGenerator.generate().toString(),
						"helloWorldEmailProcess");
		helloWorldEmailProcessModel.setCart(event.getCart());
		helloWorldEmailProcessModel.setCurrency(event.getCurrency());
		//		helloWorldEmailProcessModel.setCustomer(event.getCustomer());
		helloWorldEmailProcessModel.setLanguage(event.getLanguage());
		helloWorldEmailProcessModel.setSite(event.getSite());
		helloWorldEmailProcessModel.setStore(event.getBaseStore());
		helloWorldEmailProcessModel.setCustomer(event.getCustomer());
		getModelService().save(helloWorldEmailProcessModel);
		getBusinessProcessService().startProcess(helloWorldEmailProcessModel);
	}

	@Override
	protected boolean shouldHandleEvent(final HelloWorldEmailActivationEvent event)
	{
		final BaseSiteModel baseSite = event.getSite();
		ServicesUtil.validateParameterNotNullStandardMessage("event.site", baseSite);
		return SiteChannel.B2C.equals(baseSite.getChannel());
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the processCodeGenerator
	 */
	public KeyGenerator getProcessCodeGenerator()
	{
		return processCodeGenerator;
	}

	/**
	 * @param processCodeGenerator
	 *           the processCodeGenerator to set
	 */
	@Required
	public void setProcessCodeGenerator(final KeyGenerator processCodeGenerator)
	{
		this.processCodeGenerator = processCodeGenerator;
	}

	/**
	 * @return the businessProcessService
	 */
	public BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}

	/**
	 * @param businessProcessService
	 *           the businessProcessService to set
	 */
	@Required
	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}

	@Override
	protected SiteChannel getSiteChannelForEvent(final HelloWorldEmailActivationEvent event)
	{
		// XXX Auto-generated method stub
		return null;
	}
}
