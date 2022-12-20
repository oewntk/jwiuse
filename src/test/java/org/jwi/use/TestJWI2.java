package org.jwi.use;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestJWI2
{
	private static JWI jwi1;

	private static JWI jwi2;

	@BeforeAll
	public static void init() throws IOException
	{
		String wnHome1 = System.getProperty("SOURCE");
		String wnHome2 = System.getProperty("SOURCE2");
		jwi1 = new JWI(wnHome1);
		jwi2 = new JWI(wnHome2);
	}

	@Test
	public void walkSpread() throws IOException
	{
		walk2("spread");
	}

	@Test
	public void walkSpread1() throws IOException
	{
		System.out.println(jwi1.wnHome);
		jwi1.walk("spread");
	}

	@Test
	public void walkSpread2() throws IOException
	{
		System.out.println(jwi2.wnHome);
		jwi2.walk("spread");
	}

	private void walk2(String lemma)
	{
		System.out.println(jwi1.wnHome);
		jwi1.walk(lemma);
		System.out.println(jwi2.wnHome);
		jwi2.walk(lemma);
	}
}
