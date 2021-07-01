package com.hybris.training.core.suggestion.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import org.apache.commons.lang.StringUtils;

public class TrainingPrepareInterceptor implements PrepareInterceptor {

    @Override
    public void onPrepare(Object model, InterceptorContext interceptorContext) throws InterceptorException {

        if(model instanceof CustomerModel) {
            final CustomerModel customer= new CustomerModel();
            if(interceptorContext.isNew(customer))
                adjustCustomerUID(customer);
            else if(interceptorContext.isModified(model, CustomerModel.ORIGINALUID) || interceptorContext.isModified(model,CustomerModel.UID))
                adjustCustomerUID(customer);
        }
    }

    private void adjustCustomerUID(CustomerModel customer) {

        final String uid= customer.getOriginalUid();
        final String original = customer.getOriginalUid();
        if(StringUtils.isNotEmpty(uid)) {
            if(!uid.equalsIgnoreCase(original)) {
                customer.setOriginalUid(uid);
            }
            else if(!uid.equals(uid.toLowerCase())) {
                customer.setUid(uid.toLowerCase());
                customer.setOriginalUid(uid);
            }
        }
        else if(StringUtils.isNotEmpty(original))
            customer.setOriginalUid(original.toLowerCase());
    }
}
