package com.hybris.training.core.suggestion.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

public class TrainingInitDefaultsInterceptor implements InitDefaultsInterceptor {
    @Override
    public void onInitDefaults(Object model, InterceptorContext interceptorContext) throws InterceptorException {

        if(model instanceof CustomerModel) {
            final CustomerModel customer= new CustomerModel();
            if(interceptorContext.isNew(customer))
                adjustcustomerDesc(customer);
            else if (interceptorContext.isModified(model,CustomerModel.ORIGINALUID) || interceptorContext.isModified(model,CustomerModel.UID)) {
                adjustcustomerDesc(customer);
            }
        }
    }

    private void adjustcustomerDesc(CustomerModel customer) {
        customer.setDescription("This is the customer description! ");
    }
}
