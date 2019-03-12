package idwall.desafio.formatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import idwall.desafio.string.IdwallFormatter;
import idwall.desafio.utilities.FileManagerUtils;

public class FormatterTests {

	private static final String EXPECTED_OUTPUT_FILE_PATH = "docs/output_parte1.txt";
	private static final String GENERATED_FILE_PATH = "docs/generated_file_parte_1.txt";

	@Test
	public void given_one_text_and_limit_42_when_formatter_format_returns_expected_output_formatted() throws Exception {
		String text = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
				+ "\n"
				+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
		Integer limit = 42;
		Boolean justify = false;

		IdwallFormatter idwallFormatter = new IdwallFormatter();

		idwallFormatter.setLimit(limit);
		idwallFormatter.setJustify(justify);
		
		idwallFormatter.format(text);

		String generatedFile = FileManagerUtils.fetchContent(GENERATED_FILE_PATH);
		String outputExpected = FileManagerUtils.fetchContent(EXPECTED_OUTPUT_FILE_PATH);

		Assert.assertEquals(generatedFile, outputExpected);
	}

	@Test
	public void given_one_text_and_limit_42_when_formatter_format_returns_file_with_default_text() throws Exception {
		String text = null;
		Integer limit = 0;
		Boolean justify = null;

		IdwallFormatter idwallFormatter = new IdwallFormatter();

		idwallFormatter.setLimit(limit);
		idwallFormatter.setJustify(justify);
		
		idwallFormatter.format(text);

		String generatedFile = FileManagerUtils.fetchContent(GENERATED_FILE_PATH);

		Assert.assertNotNull(generatedFile);
		Assert.assertFalse(generatedFile.isEmpty());
	}
}
