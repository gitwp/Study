package com.ex1.decorator;

import com.ex1.decorated.Beverage;

public class Coffee extends Ingredient {
	public Coffee(Beverage bev)
	{
	    cost = 3;
	    desc = "Coffee";
	    beverage = bev;
	}
}
