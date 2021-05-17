/**
 *
 */
package com.hybris.training.core.promotion.action.executable;

import de.hybris.platform.ruleengineservices.compiler.RuleCompilerException;
import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;
import de.hybris.platform.ruleengineservices.rao.RuleEngineResultRAO;
import de.hybris.platform.ruleengineservices.rule.evaluation.RuleActionContext;
import de.hybris.platform.ruleengineservices.rule.evaluation.RuleExecutableAction;

import java.util.Map;
import java.util.Optional;

/**
 * @author vaibhavgupta03
 *
 */
public class TrainingRuleSearchedWordAddScoreAction implements RuleExecutableAction
{

	@Override
	public void executeAction(final RuleActionContext context, final Map<String, Object> parameters) throws RuleCompilerException
	{

		final String value= (String) parameters.get("value");
		final RuleEngineResultRAO resultRAO= context.getValue(RuleEngineResultRAO.class);
		final CartRAO cartRAO= context.getValue(CartRAO.class);

		final Optional<OrderEntryRAO> orderEntry = cartRAO
				.getEntries()
				.stream()
				.filter(orderEntryRAO -> orderEntryRAO.getProduct().getCode().equalsIgnoreCase(value)).findFirst();


		//	 orderEntry.ifPresent(orderEntryRAO -> this.getAddOrderEntryDiscountRAOAction().addOrderEntryLevelDiscount(orderEntryRAO, false, value, resultRAO, context.getDelegate()));
	 }

	 //	 	public AddOrderEntryDiscountRAOAction getAddOrderEntryDiscountRAOAction() {
	 //	 		return this.addOrderEntryDiscountRAOAction;
	 //	 	}
	 //
	 //	public void setAddOrderEntryDiscountRAOAction(final AddOrderEntryDiscountRAOAction addOrderEntryDiscountRAOAction) {
	 //		this.addOrderEntryDiscountRAOAction=addOrderEntryDiscountRAOAction;
	 //	}
}
