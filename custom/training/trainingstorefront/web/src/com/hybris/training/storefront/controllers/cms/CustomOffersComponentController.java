/**
 *
 */
package com.hybris.training.storefront.controllers.cms;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hybris.training.core.model.CustomOffersComponentModel;


/**
 * @author vaibhavgupta03
 *
 */
@Controller("CustomOffersComponentController")
@Scope("tenant")
@RequestMapping(value = "ControllerConstants.Actions.cms.CustomOffersComponent")
public class CustomOffersComponentController extends AbstractCMSComponentController<CustomOffersComponentModel>
{

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final CustomOffersComponentModel component)
	{
		model.addAttribute("headerText", component.getHeaderText());
		model.addAttribute("footerText", component.getFooterText());
		model.addAttribute("offerImage", component.getOfferImage());
		model.addAttribute("offerImageLink", component.getOfferimageLink());
	}

	@Override
	protected String getView(final CustomOffersComponentModel component)
	{

		return null;
	}

}
