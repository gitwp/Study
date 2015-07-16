package com.ex1.expression.terminal;

import java.util.HashMap;

import com.ex1.expression.Expression;

public class VarExpression extends Expression {
	private String key;

	public VarExpression(String _key) {
		this.key = _key;
	}

	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(this.key);
	}

}
