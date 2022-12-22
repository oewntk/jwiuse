package org.jwi.use;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import edu.mit.jwi.item.ISenseEntry;
import edu.mit.jwi.item.ISenseKey;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;

public class JWITryIterateTests
{
	private static JWI jwi;

	@BeforeAll
	public static void init() throws IOException
	{
		String wnHome = System.getProperty("SOURCE");
		jwi = new JWI(wnHome);
	}

	@Test
	public void iterateLemmas()
	{
		jwi.tryForAllLemmas((String l) -> {
		});
	}

	@Test
	public void iterateSenses()
	{
		jwi.tryForAllSenses((IWord s) -> {
		});
	}

	@Test
	public void iterateSynsets()
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
