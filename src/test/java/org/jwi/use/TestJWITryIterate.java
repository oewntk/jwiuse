package org.jwi.use;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import edu.mit.jwi.item.ISenseEntry;
import edu.mit.jwi.item.ISenseKey;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;

public class TestJWITryIterate
{
	private static JWI jwi;

	@BeforeClass
	public static void init() throws IOException
	{
		String wnHome = System.getProperty("SOURCE");
		jwi = new JWI(wnHome);
	}

	@Test
	public void iterateLemmas() throws IOException
	{
		jwi.tryForAllLemmas((String l) -> {
		});
	}

	@Test
	public void iterateSenses() throws IOException
	{
		jwi.tryForAllSenses((IWord s) -> {
		});
	}

	@Test
	public void iterateSynsets() throws IOException
	{
		jwi.tryForAllSynsets((ISynset s) -> {
		});
	}

	@Test
	public void iterateSenseEntries()
	{
		jwi.tryForAllSenseEntries((ISenseEntry se) -> {
		});
	}

	@Test
	public void iterateSenseRelations()
	{
		jwi.tryForAllSenseRelations((IWord r) -> {
		});
	}

	@Test
	public void iterateSynsetRelations()
	{
		jwi.tryForAllSynsetRelations((ISynset r) -> {
		});
	}

	@Test
	public void iterateSenseKeys()
	{
		jwi.tryForAllSensekeys((ISenseKey sk) -> {
		});
	}
}
