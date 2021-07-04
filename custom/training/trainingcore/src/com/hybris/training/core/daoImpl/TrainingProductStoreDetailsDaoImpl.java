package com.hybris.training.core.daoImpl;

import com.hybris.training.core.dao.TrainingProductStoreDetailsDao;
import com.hybris.training.core.model.TrainingProductStoreDetailsModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.util.ServicesUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingProductStoreDetailsDaoImpl implements TrainingProductStoreDetailsDao {

    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<TrainingProductStoreDetailsModel> getProductstoreDetailsByCode(String storeId) {

        final Map<String,Object> params= new HashMap<>();
        params.put("code",storeId);

        ServicesUtil.validateParameterNotNull(storeId,"Store Id must not be null");
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT {s:").append(TrainingProductStoreDetailsModel.PK).append("} ");
        stringBuilder.append("FROM {").append(TrainingProductStoreDetailsModel._TYPECODE).append(" AS s} ");
        stringBuilder.append("WHERE ").append("{s.storeId} = ?code");

        final String STORE_QUERY = stringBuilder.toString();

        final SearchResult<TrainingProductStoreDetailsModel> result= getFlexibleSearchService().search(STORE_QUERY,params);

        return result.getResult() != null ? result.getResult(): Collections.emptyList();
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
