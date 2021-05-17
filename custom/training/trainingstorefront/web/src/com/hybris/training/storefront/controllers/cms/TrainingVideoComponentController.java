/**
 *
 */
package com.hybris.training.storefront.controllers.cms;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hybris.training.core.model.TrainingVideoComponentModel;
import com.hybris.training.storefront.controllers.ControllerConstants;


/**
 * @author vaibhavgupta03
 *
 */

@Controller("TrainingVideoComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.TrainingVideoComponent)
public class TrainingVideoComponentController extends AbstractCMSComponentController<TrainingVideoComponentModel>
{

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final TrainingVideoComponentModel component)
	{
		model.addAttribute("autoPlay", component.getAutoPlay() ? 1 : 0);
		model.addAttribute("width", component.getWidth());
		model.addAttribute("height", component.getHeight());
		model.addAttribute("videoId", component.getVideoId());
		model.addAttribute("showControls", component.getShowControls() ? 1 : 0);
	}

	@Override
	protected String getView(final TrainingVideoComponentModel component)
	{
		return null;
	}

}
