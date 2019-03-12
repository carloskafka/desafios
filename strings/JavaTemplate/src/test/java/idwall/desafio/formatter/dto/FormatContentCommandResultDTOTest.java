package idwall.desafio.formatter.dto;

import org.testng.Assert;
import org.testng.annotations.Test;

import idwall.desafio.dto.FormatContentCommandResultDTO;
import idwall.desafio.dto.TextDTO;
import idwall.desafio.formatter.TextContext;

public class FormatContentCommandResultDTOTest {

	@Test
	public void given_a_new_formatcontentcommandresultdto_when_it_is_created_then_return_a_valid_formatcontentcommandresultdto() {
		FormatContentCommandResultDTO formatContentCommandResultDTO = new FormatContentCommandResultDTO();
		
		TextDTO updatedTextDto = TextContext.createValidTextDTO();
		
		formatContentCommandResultDTO.setUpdatedTextDto(updatedTextDto);
		
		Assert.assertTrue(formatContentCommandResultDTO.sucessful());
		Assert.assertNotNull(formatContentCommandResultDTO.getUpdatedTextDto());
		Assert.assertEquals(formatContentCommandResultDTO.getErrors().size(), 0);
		Assert.assertEquals(formatContentCommandResultDTO.getMessages().size(), 0);
	}
	
	@Test
	public void given_a_invalid_formatcontentcommandresultdto_when_it_is_created_then_return_a_invalid_formatcontentcommandresultdto() {
		FormatContentCommandResultDTO formatContentCommandResultDTO = new FormatContentCommandResultDTO();
		
		Assert.assertFalse(formatContentCommandResultDTO.sucessful());
		Assert.assertNull(formatContentCommandResultDTO.getUpdatedTextDto());
		Assert.assertEquals(formatContentCommandResultDTO.getErrors().size(), 0);
		Assert.assertEquals(formatContentCommandResultDTO.getMessages().size(), 0);
	}
	
}
