/**
 *
 */
package com.hybris.training.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;

import com.hybris.training.core.model.HelloWorldEmailProcessModel;


/**
 * @author vaibhavgupta03
 *
 */
public class HelloWorldEmailContext extends AbstractEmailContext<HelloWorldEmailProcessModel>
{

	@Override
	public void init(final HelloWorldEmailProcessModel helloWorldEmailProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(helloWorldEmailProcessModel, emailPageModel);

		put(EMAIL, getCustomerEmailResolutionService().getEmailForCustomer(getCustomer(helloWorldEmailProcessModel)));
		put(DISPLAY_NAME, getCustomer(helloWorldEmailProcessModel).getDisplayName());
	}


	@Override
	protected BaseSiteModel getSite(final HelloWorldEmailProcessModel helloWorldEmailProcessModel)
	{
		// XXX Auto-generated method stub
		return helloWorldEmailProcessModel.getSite();
	}

	@Override
	protected CustomerModel getCustomer(final HelloWorldEmailProcessModel helloWorldEmailProcessModel)
	{
		// XXX Auto-generated method stub
		return helloWorldEmailProcessModel.getCustomer();
	}

	@Override
	protected LanguageModel getEmailLanguage(final HelloWorldEmailProcessModel helloWorldEmailProcessModel)
	{
		// XXX Auto-generated method stub
		return helloWorldEmailProcessModel.getLanguage();
	}


}
