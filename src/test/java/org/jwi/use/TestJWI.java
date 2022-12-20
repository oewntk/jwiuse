package org.jwi.use;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;


import java.io.IOException;

import edu.mit.jwi.item.ISenseEntry;
import edu.mit.jwi.item.ISenseKey;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;

public class TestJWI
{
	private static JWI jwi;

	@BeforeAll
	public static void init() throws IOException
	{
		String wnHome = System.getProperty("SOURCE");
		jwi = new JWI(wnHome);
	}

	@Test
	public void walkSpread() throws IOException
	{
		jwi.walk("spread");
	}
}
