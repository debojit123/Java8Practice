package com.java8.practice.custominterface;

import com.java8.practice.functionalinterface.FunctionalInterfaceBasic;

public class FunctionalInterfaceImplWithoutLambda implements FunctionalInterfaceBasic {

	@Override
	public void printHelloWord() {
		System.out.println("Implemented FunctionalInterfaceBasic without Lambda");
		
	}

}
