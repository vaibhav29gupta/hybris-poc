/**
 *
 */
package com.hybris.training.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @author vaibhavgupta03
 *
 */
public class TrainingProductReviewCountProvider implements FieldValueProvider
{

	private FieldNameProvider fieldNameProvider;

	@Override
	public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty,
			final Object model) throws FieldValueProviderException
	{
		if (model instanceof ProductModel)
		{

			final ProductModel product = (ProductModel) model;
			final Collection<FieldValue> fieldValues = new ArrayList<FieldValue>();
			fieldValues.addAll(createFieldValues(product, indexedProperty));
			return fieldValues;
		}
		throw new FieldValueProviderException("Item is not a product instance");
	}

	/**
	 * @param product
	 * @param indexedProperty
	 * @return
	 */
	private Collection<? extends FieldValue> createFieldValues(final ProductModel product, final IndexedProperty indexedProperty)
	{
		final List<FieldValue> field = new ArrayList<FieldValue>();
		final String reviewCount = product.getNumberOfReviews() + " Reviews";
		if (reviewCount != null)
		{
			addFieldValues(field, indexedProperty, reviewCount);
		}

		return field;
	}

	/**
	 * @param field
	 * @param indexedProperty
	 * @param reviewCount
	 */
	protected void addFieldValues(final List<FieldValue> field, final IndexedProperty indexedProperty, final String value)
	{
		final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty, null);

		for (final String fieldName : fieldNames)
		{
			field.add(new FieldValue(fieldName, value));
		}
	}

	/**
	 * @return the fieldNameProvider
	 */
	public FieldNameProvider getFieldNameProvider()
	{
		return fieldNameProvider;
	}

	/**
	 * @param fieldNameProvider
	 *           the fieldNameProvider to set
	 */
	public void setFieldNameProvider(final FieldNameProvider fieldNameProvider)
	{
		this.fieldNameProvider = fieldNameProvider;
	}


}
