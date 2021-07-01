package com.hybris.training.core.suggestion.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

public class TrainingValidateInterceptor implements ValidateInterceptor {
    @Override
    public void onValidate(Object model, InterceptorContext interceptorContext) throws InterceptorException {

        if(model instanceof CustomerModel) {
            final CustomerModel customer= (CustomerModel) model;

            if(customer.getUid().contains("hybrisValidateInterceptor is called"))
                throw new InterceptorException("Exception occurred during validation!");
        }
    }
}
