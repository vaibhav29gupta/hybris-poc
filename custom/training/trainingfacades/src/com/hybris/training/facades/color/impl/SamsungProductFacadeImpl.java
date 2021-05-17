/**
 *
 */
package com.hybris.training.facades.color.impl;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.event.EventService;

import com.hybris.training.core.model.SamsungProductInfoModel;
import com.hybris.training.facades.color.SamsungProductFacade;


/**
 * @author vaibhavgupta03
 *
 */
public class SamsungProductFacadeImpl implements SamsungProductFacade
{

	private Converter<SamsungProductInfoModel, ProductData> samsungInfoConverter;
	private EventService eventService;


	public ProductData getColorCode()
	{
		final AbstractOrderEntryModel orderEntryModel = null;
		//		final Model model = null;
		final SamsungProductInfoModel samsung = new SamsungProductInfoModel();
		samsung.setProductColor("green");

		//final ProductData prod= samsungProductFacade.getColorCode();
		final ProductData productData = getSamsungInfoConverter().convert(samsung);

		/*
		 * getEventService().publishEvent(initializeEvent(new HelloWorldEmailActivationEvent( orderEntryModel,
		 * orderEntryModel.getOrder().getSite(), orderEntryModel.getOrder().getStore(),
		 * orderEntryModel.getOrder().getCurrency()), (CustomerModel) orderEntryModel.getOrder().getUser()));
		 */
		//		model.addAttribute(productData);
		return productData;
	}

	public AbstractCommerceUserEvent initializeEvent(final AbstractCommerceUserEvent event, final CustomerModel customer)
	{
		event.setCustomer(customer);
		return event;
	}

	/**
	 * @return the samsungInfoConverter
	 */
	public Converter<SamsungProductInfoModel, ProductData> getSamsungInfoConverter()
	{
		return samsungInfoConverter;
	}

	/**
	 * @param samsungInfoConverter
	 *           the samsungInfoConverter to set
	 */
	public void setSamsungInfoConverter(final Converter<SamsungProductInfoModel, ProductData> samsungInfoConverter)
	{
		this.samsungInfoConverter = samsungInfoConverter;
	}

	/**
	 * @return the eventService
	 */
	public EventService getEventService()
	{
		return eventService;
	}

	/**
	 * @param eventService
	 *           the eventService to set
	 */
	public void setEventService(final EventService eventService)
	{
		this.eventService = eventService;
	}


}
