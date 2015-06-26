package com.ex1.decorator;

import com.ex1.decorated.Beverage;

public class Mocha extends Ingredient {
	public Mocha(Beverage bev)
	{
	    cost = 2;
	    desc = "Mocha";
	    beverage = bev;
	}
}
