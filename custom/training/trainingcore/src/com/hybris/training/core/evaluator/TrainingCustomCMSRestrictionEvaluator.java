package com.hybris.training.core.evaluator;

import com.hybris.training.core.model.TrainingCountryOfOriginCMSRestrictionModel;
import de.hybris.platform.cms2.model.restrictions.AbstractRestrictionModel;
import de.hybris.platform.cms2.servicelayer.data.RestrictionData;
import de.hybris.platform.cms2.servicelayer.services.evaluator.CMSRestrictionEvaluator;
import de.hybris.platform.servicelayer.session.SessionService;

import javax.annotation.Resource;
import java.util.Set;

public class TrainingCustomCMSRestrictionEvaluator implements CMSRestrictionEvaluator
{
    @Resource(name="sessionService")
    private SessionService sessionService;

    @Override
    public boolean evaluate(AbstractRestrictionModel restriction, RestrictionData restrictionData) {

        if(restriction instanceof TrainingCountryOfOriginCMSRestrictionModel) {

            String countryName = sessionService.getAttribute("countryOfOrigin");

            final Set<String> countryNames = ((TrainingCountryOfOriginCMSRestrictionModel) restriction).getCountryNames();
            if (!countryNames.isEmpty()) {
                if (countryNames.contains(countryName)) {
                    return true;
                }
            }
        }

        return false;
    }
}
