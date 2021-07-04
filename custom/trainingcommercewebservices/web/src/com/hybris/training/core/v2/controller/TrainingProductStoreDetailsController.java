package com.hybris.training.core.v2.controller;


import de.hybris.platform.commercefacades.product.data.TrainingProductDetailsDataList;
import de.hybris.platform.commercefacades.product.data.TrainingProductDetailsDataWSDTO;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hybris.training.facades.stores.TrainingProductStoreDetailsFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.apache.log4j.Logger;

@Controller
@RequestMapping(value = "/{baseSiteId}")

@Api(tags = "Hybris Practice")
public class TrainingProductStoreDetailsController extends BaseCommerceController
{

	private static Logger LOGGER = Logger.getLogger(TrainingProductStoreDetailsController.class);

	@Resource
	private TrainingProductStoreDetailsFacade trainingProductStoreDetailsFacade;

	@Secured("ROLE_TRUSTED_CLIENT")

	@RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
	@ResponseBody

	@ApiOperation(nickname = "getProductStoreDetails", value = "Get product store details", notes = "Returns a specific store based on store id", authorizations =
	{ @Authorization(value = "oauth2_client_credentials") })

	@ApiBaseSiteIdParam
	public TrainingProductDetailsDataWSDTO getProductStoreDetails(@ApiParam(value = "storeId", required = true)
	@PathVariable
	final String storeId, @ApiParam(value = "Response configuration", allowableValues = "BASIC,DEFAULT,FULL")
	@RequestParam(defaultValue = DEFAULT_FIELD_SET)
	final String fields)
	{

		LOGGER.info("Store id: " + storeId);

		final TrainingProductDetailsDataList productDetailsDataList = new TrainingProductDetailsDataList();
		productDetailsDataList.setProductStoreDetails(getTrainingProductStoreDetailsFacade().getProductStoreDetails(storeId));
		return getDataMapper().map(productDetailsDataList, TrainingProductDetailsDataWSDTO.class, fields);
	}


	public TrainingProductStoreDetailsFacade getTrainingProductStoreDetailsFacade()
	{
		return trainingProductStoreDetailsFacade;
	}

	public void setTrainingProductStoreDetailsFacade(final TrainingProductStoreDetailsFacade trainingProductStoreDetailsFacade)
	{
		this.trainingProductStoreDetailsFacade = trainingProductStoreDetailsFacade;
	}
}
