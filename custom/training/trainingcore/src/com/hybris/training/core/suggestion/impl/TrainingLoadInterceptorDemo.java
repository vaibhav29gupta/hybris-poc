package com.hybris.training.core.suggestion.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.LoadInterceptor;

public class TrainingLoadInterceptorDemo implements LoadInterceptor {

    @Override
    public void onLoad(Object model, InterceptorContext interceptorContext) throws InterceptorException {

        if(model instanceof CustomerModel) {
            final CustomerModel customer= (CustomerModel) model;
            customer.setName("hybrisLoadInterceptor");
        }
        else
            throw new InterceptorException("The load interceptor failed.");
    }
}
