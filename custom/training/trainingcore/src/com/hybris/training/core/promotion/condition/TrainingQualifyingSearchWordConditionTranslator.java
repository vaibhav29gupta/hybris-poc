/**
 *
 */
package com.hybris.training.core.promotion.condition;

import de.hybris.platform.ruleengineservices.compiler.RuleCompilerContext;
import de.hybris.platform.ruleengineservices.compiler.RuleCompilerException;
import de.hybris.platform.ruleengineservices.compiler.RuleConditionTranslator;
import de.hybris.platform.ruleengineservices.compiler.RuleIrAttributeCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrAttributeOperator;
import de.hybris.platform.ruleengineservices.compiler.RuleIrCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrFalseCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrGroupCondition;
import de.hybris.platform.ruleengineservices.compiler.RuleIrGroupOperator;
import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rule.data.RuleConditionData;
import de.hybris.platform.ruleengineservices.rule.data.RuleConditionDefinitionData;
import de.hybris.platform.ruleengineservices.rule.data.RuleParameterData;

import java.util.ArrayList;


/**
 * @author vaibhavgupta03
 *
 */
public class TrainingQualifyingSearchWordConditionTranslator implements RuleConditionTranslator
{

	private final String SEARCHED_WORD = "searchedWord";

	@Override
	public RuleIrCondition translate(final RuleCompilerContext context, final RuleConditionData condition,
			final RuleConditionDefinitionData conditionDefinition) throws RuleCompilerException
	{
		try
		{

			final RuleParameterData searchWord = condition.getParameters().get(SEARCHED_WORD);

			if (searchWord != null)
			{
				final String word = searchWord.getValue();

				final String cartRAOVariable = context.generateVariable(CartRAO.class);

				final RuleIrAttributeCondition ruleIrAttributeCondition = new RuleIrAttributeCondition();
				ruleIrAttributeCondition.setVariable(cartRAOVariable);
				ruleIrAttributeCondition.setValue(word);
				ruleIrAttributeCondition.setOperator(RuleIrAttributeOperator.CONTAINS);
				ruleIrAttributeCondition.setAttribute(SEARCHED_WORD);

				final RuleIrGroupCondition ruleIrGroupCondition = new RuleIrGroupCondition();
				ruleIrGroupCondition.setOperator(RuleIrGroupOperator.AND);
				ruleIrGroupCondition.setChildren(new ArrayList<>());
				ruleIrGroupCondition.getChildren().add(ruleIrAttributeCondition);
				return ruleIrGroupCondition;
			}
		}
		catch (final Exception e)
		{
			throw e;
		}
		return new RuleIrFalseCondition();
	}
}
