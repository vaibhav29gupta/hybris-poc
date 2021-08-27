package com.hybris.training.facades.countryOriginImpl;

import com.hybris.training.core.model.TrainingCountryOfOriginCMSRestrictionModel;
import com.hybris.training.facades.countryOrigin.TrainingCountryOriginProductFacade;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.session.SessionService;


public class TrainingCountryOriginProductFacadeImpl implements TrainingCountryOriginProductFacade {

    private ProductService productService;
    private Converter<ProductModel,ProductData> productCountryOriginDetailsConverter;

    @Override
    public ProductData getCountryOriginProductDetails(String productCode) {
       final ProductModel productModel= getProductService().getProductForCode(productCode);
       final ProductData productData= productCountryOriginDetailsConverter.convert(productModel);
       return productData;
    }

    public Converter<ProductModel, ProductData> getProductCountryOriginDetailsConverter() {
        return productCountryOriginDetailsConverter;
    }

    public void setProductCountryOriginDetailsConverter(Converter<ProductModel, ProductData> productCountryOriginDetailsConverter) {
        this.productCountryOriginDetailsConverter = productCountryOriginDetailsConverter;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
