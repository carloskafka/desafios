package idwall.desafio.formatter.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import idwall.desafio.dto.FormatContentCommandResultDTO;
import idwall.desafio.dto.TextDTO;
import idwall.desafio.facade.TextFacade;
import idwall.desafio.formatter.TextContext;

public class TextFacadeTest {

	@Test
	public void given_one_valid_textdto_when_it_formats_then_return_successful_result() {
		TextDTO textDto = TextContext.createValidTextDTO();

		FormatContentCommandResultDTO formatContentCommandResultDto = new TextFacade().format(textDto);

		Assert.assertTrue(formatContentCommandResultDto.sucessful());
		Assert.assertEquals(formatContentCommandResultDto.getErrors().size(), 0);
		Assert.assertEquals(formatContentCommandResultDto.getMessages().size(), 8);
		Assert.assertNotNull(formatContentCommandResultDto.getUpdatedTextDto());
	}
	
	@Test
	public void given_one_invalid_textdto_when_it_formats_then_return_invalid_result() {
		TextDTO textDto = TextContext.createInvalidTextDTO();
		
		FormatContentCommandResultDTO formatContentCommandResultDto = new TextFacade().format(textDto);
		
		Assert.assertFalse(formatContentCommandResultDto.sucessful());
		Assert.assertEquals(formatContentCommandResultDto.getErrors().size(),2);
		Assert.assertTrue(formatContentCommandResultDto.getErrors().contains("Invalid content. Input a valid one"));
		Assert.assertTrue(formatContentCommandResultDto.getErrors().contains("Invalid max length. Input a max length greater than 0."));
		Assert.assertEquals(formatContentCommandResultDto.getMessages().size(), 0);
		Assert.assertNull(formatContentCommandResultDto.getUpdatedTextDto());
	}
	
	@Test
	public void given_one_textDto_with_justify_true_textdto_when_it_formats_then_return_error() {
		TextDTO textDto = TextContext.createValidTextWithJustifyTrueDTO();
		
		FormatContentCommandResultDTO formatContentCommandResultDto = new TextFacade().format(textDto);

		Assert.assertFalse(formatContentCommandResultDto.sucessful());
		Assert.assertEquals(formatContentCommandResultDto.getErrors().size(), 2);
		Assert.assertTrue(formatContentCommandResultDto.getErrors().contains("Justify was detected enabled"));
		Assert.assertTrue(formatContentCommandResultDto.getErrors().contains("ERROR: Justify process under development :("));
		Assert.assertEquals(formatContentCommandResultDto.getMessages().size(), 0);
		Assert.assertNull(formatContentCommandResultDto.getUpdatedTextDto());
	}
}
