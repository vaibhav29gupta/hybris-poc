package com.hybris.training.core.suggestion.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.LoadInterceptor;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;

public class TrainingRemoveInterceptor implements RemoveInterceptor {

    @Override
    public void onRemove(Object model, InterceptorContext interceptorContext) throws InterceptorException {

        if (model instanceof CustomerModel) {
            final CustomerModel customer = (CustomerModel) model;

            if(customer.getUid().equalsIgnoreCase("hybrisRemoveInterceptor"))
                throw new InterceptorException(" You cannot remove customer model with emails");
        }
    }
}
