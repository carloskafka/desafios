package idwall.desafio.formatter.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import idwall.desafio.dto.FormatContentCommandResultDTO;
import idwall.desafio.dto.TextDTO;
import idwall.desafio.facade.TextFacade;
import idwall.desafio.formatter.TextContext;

public class TextFacadeTest {

	@Test
	public void given_one_valid_textdto_when_it_formats_return_successful_result() {
		TextDTO textDto = TextContext.createValidTextDTO();

		FormatContentCommandResultDTO formatContentCommandResultDto = new TextFacade().format(textDto);

		Assert.assertTrue(formatContentCommandResultDto.sucessful());
		Assert.assertEquals(formatContentCommandResultDto.getErrors().size(), 0);
		Assert.assertEquals(formatContentCommandResultDto.getMessages().size(), 8);
		Assert.assertNotNull(formatContentCommandResultDto.getUpdatedTextDto());
	}
	
	@Test
	public void given_one_invalid_textdto_when_it_formats_return_invalid_result() {
		String expectedErrors = "Invalid content. Input a valid one\n"
				+ "Invalid max length. Input a max length greater than 0.\n";

		TextDTO textDto = TextContext.createInvalidTextDTO();
		
		FormatContentCommandResultDTO formatContentCommandResultDto = new TextFacade().format(textDto);

		Assert.assertFalse(formatContentCommandResultDto.sucessful());
		Assert.assertEquals(formatContentCommandResultDto.getErrors().size(), 1);
		Assert.assertTrue(formatContentCommandResultDto.getErrors().contains(expectedErrors));
		Assert.assertEquals(formatContentCommandResultDto.getMessages().size(), 0);
		Assert.assertNull(formatContentCommandResultDto.getUpdatedTextDto());
	}
}
