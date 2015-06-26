package com.ex1.decorator;

import com.ex1.decorated.Beverage;

public class IceWater extends Ingredient {
	public IceWater(Beverage bev)
	{
	    cost = 0.5f;
	    desc = "IceWater";
	    beverage = bev;
	}
}
