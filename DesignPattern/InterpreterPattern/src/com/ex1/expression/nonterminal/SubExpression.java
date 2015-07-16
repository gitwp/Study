package com.ex1.expression.nonterminal;

import java.util.HashMap;

import com.ex1.expression.Expression;

public class SubExpression extends SymbolExpression {

	public SubExpression(Expression _left, Expression _right) {
		super(_left, _right);
	}

	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return super.left.interpreter(var) - super.right.interpreter(var);
	}

}
