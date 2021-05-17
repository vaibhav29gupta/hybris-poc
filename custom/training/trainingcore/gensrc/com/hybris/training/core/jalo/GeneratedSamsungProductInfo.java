/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 15-May-2021, 6:15:24 PM                     ---
 * ----------------------------------------------------------------
 */
package com.hybris.training.core.jalo;

import com.hybris.training.core.constants.TrainingCoreConstants;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link com.hybris.training.core.jalo.SamsungProductInfo SamsungProductInfo}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedSamsungProductInfo extends Product
{
	/** Qualifier of the <code>SamsungProductInfo.productColor</code> attribute **/
	public static final String PRODUCTCOLOR = "productColor";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Product.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(PRODUCTCOLOR, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SamsungProductInfo.productColor</code> attribute.
	 * @return the productColor
	 */
	public String getProductColor(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTCOLOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SamsungProductInfo.productColor</code> attribute.
	 * @return the productColor
	 */
	public String getProductColor()
	{
		return getProductColor( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SamsungProductInfo.productColor</code> attribute. 
	 * @param value the productColor
	 */
	public void setProductColor(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTCOLOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SamsungProductInfo.productColor</code> attribute. 
	 * @param value the productColor
	 */
	public void setProductColor(final String value)
	{
		setProductColor( getSession().getSessionContext(), value );
	}
	
}
