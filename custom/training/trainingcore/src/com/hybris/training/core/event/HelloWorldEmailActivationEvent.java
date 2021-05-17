/**
 *
 */
package com.hybris.training.core.event;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.store.BaseStoreModel;


/**
 * @author vaibhavgupta03
 *
 */
public class HelloWorldEmailActivationEvent extends AbstractCommerceUserEvent
{
	private AbstractOrderModel cart;

	public HelloWorldEmailActivationEvent(final AbstractOrderModel cart,
			final BaseSiteModel site,
			final BaseStoreModel baseStore, final CurrencyModel currency)
	{
		super();
		this.cart = cart;
		setSite(site);
		setBaseStore(baseStore);
		setCurrency(currency);
		setCustomer((CustomerModel) cart.getUser());
		setLanguage(cart.getUser().getSessionLanguage());
	}

	/**
	 * @return the cart
	 */
	public AbstractOrderModel getCart()
	{
		return cart;
	}

	/**
	 * @param cart
	 *           the cart to set
	 */
	public void setCart(final AbstractOrderModel cart)
	{
		this.cart = cart;
	}

}
