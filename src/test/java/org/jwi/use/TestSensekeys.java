package org.jwi.use;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import edu.mit.jwi.item.ISenseEntry;
import edu.mit.jwi.item.ISenseKey;

public class TestSensekeys
{
	private static boolean verbose = !System.getProperties().containsKey("SILENT");

	private static JWI jwi;

	@BeforeClass
	public static void init() throws IOException
	{
		String wnHome = System.getProperty("SOURCE");
		jwi = new JWI(wnHome);
	}

	@Test
	public void findSensekeys() throws IOException
	{
		lookupSensekey("you_bet%4:02:00::");
		lookupSensekey("electric%5:00:00:exciting:00");
		findSensekeysOf("aborigine");
		findSensekeysOf("Aborigine");
	}

	@Test
	public void findAllSensekeys()
	{
		findAllSensekeys(jwi);
	}

	public void findSensekeysOf(String lemma)
	{
		Collection<ISenseEntry> ses = Sensekeys.findSensekeysOf(jwi, lemma);
		if (verbose)
		{
			System.out.println("\n⯆" + lemma);
			for (ISenseEntry se : ses)
			{
				System.out.printf("%s %s%n", se.getSenseKey(), se.getOffset());
			}
		}
	}

	public void lookupSensekey(String skStr)
	{
		ISenseEntry se = Sensekeys.lookupSensekey(jwi, skStr);
		if (verbose)
		{
			System.out.println("\n⯈" + skStr);
			System.out.printf("%s %s%n", se.getSenseKey(), se.getOffset());
		}
	}

	private static void findAllSensekeys(JWI jwi)
	{
		AtomicInteger count = new AtomicInteger(0);
		AtomicInteger errCount = new AtomicInteger(0);

		jwi.forAllSenses(s -> {
			ISenseKey sk = s.getSenseKey();
			ISenseEntry se = jwi.getDict().getSenseEntry(sk);
			if (se == null)
			{
				System.err.printf("Sensekey not found %s%n", sk.toString());
				errCount.incrementAndGet();
			}
			else
			{
				int ofs = se.getOffset();
				if (verbose)
				{
					System.out.printf("%s %s%n", sk, ofs);
				}
				count.incrementAndGet();
			}
		});
		System.out.printf("Sensekeys: %d Errors: %d%n", count.get(), errCount.get());
	}
}
