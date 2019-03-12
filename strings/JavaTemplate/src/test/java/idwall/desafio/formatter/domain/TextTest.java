package idwall.desafio.formatter.domain;

import org.testng.Assert;
import org.testng.annotations.Test;

import idwall.desafio.domain.Text;
import idwall.desafio.formatter.TextContext;
import idwall.desafio.utilities.FileManagerUtils;

public class TextTest {

	@Test
	public void given_one_generated_file_and_output_file_when_verify_equality_between_both_then_return_true() {
		Assert.assertEquals(FileManagerUtils.fetchContent("docs/generated_file.txt"),
				FileManagerUtils.fetchContent("docs/output_parte1.txt"));
	}
	
	@Test
	public void given_one_text_and_limit_42_when_formatter_format_then_returns_expected_output_formatted() {
		String content = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
				+ "\n"
				+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
		String updatedContent = "In the beginning God created the heavens\r\n" 
				+ "and the earth. Now the earth was\r\n"
				+ "formless and empty, darkness was over\r\n" 
				+ "the surface of the deep, and the Spirit\r\n"
				+ "of God was hovering over the waters.\r\n" 
				+ "\r\n" + "And God said, \"Let there be light,\" and\r\n"
				+ "there was light. God saw that the light\r\n" 
				+ "was good, and he separated the light\r\n"
				+ "from the darkness. God called the light\r\n" 
				+ "\"day,\" and the darkness he called\r\n"
				+ "\"night.\" And there was evening, and\r\n" 
				+ "there was morning - the first day.\r\n" + "";

		Integer maxLength = 42;
		Boolean justify = false;

		Text text = TextContext.createValidText();

		text.setUpdatedContent("");
				
		text.formatLines();

		Assert.assertFalse(text.toString().isEmpty());
		Assert.assertEquals(text.getContent(), content);
		Assert.assertEquals(text.getUpdatedContent(), updatedContent);
		Assert.assertEquals(text.getJustify(), justify);
		Assert.assertEquals(text.getMaxLength(), maxLength);
	}

	@Test
	public void given_one_invalid_text_when_formatter_validate_input_and_format_lines_then_returns_expected_errors() {
		String expectedErrors = "Invalid content. Input a valid one\n"
				+ "Invalid max length. Input a max length greater than 0.\n";

		Text text = TextContext.createInvalidText();
		
		text.validateInput();
		
		Assert.assertEquals(text.getErrorDescriptions(), expectedErrors);
	}

}
