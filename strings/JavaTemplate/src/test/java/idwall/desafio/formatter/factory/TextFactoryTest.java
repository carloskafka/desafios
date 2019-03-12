package idwall.desafio.formatter.factory;

import org.testng.Assert;
import org.testng.annotations.Test;

import idwall.desafio.domain.Text;
import idwall.desafio.dto.TextDTO;
import idwall.desafio.factory.TextFactory;
import idwall.desafio.formatter.TextContext;

public class TextFactoryTest {

	@Test
	public void given_one_new_text_when_factory_convert_to_dto_returns_textdto() {
		Text text = TextContext.createValidText();

		TextDTO textDto = new TextFactory().convertToDTO(text);

		Assert.assertEquals(textDto.getContent(), text.getContent());
		Assert.assertEquals(textDto.getUpdatedContent(), text.getUpdatedContent());
		Assert.assertEquals(textDto.getMaxLength(), text.getMaxLength());
		Assert.assertEquals(textDto.getJustify(), text.getJustify());
	}
	
	@Test
	public void given_one_new_textdto_when_factory_convert_to_domain_returns_text() {
		TextDTO textDto = TextContext.createValidTextDTO();
		
		Text text = new TextFactory().convertToDomain(textDto);

		Assert.assertEquals(text.getContent(), textDto.getContent());
		Assert.assertEquals(text.getMaxLength(), textDto.getMaxLength());
		Assert.assertEquals(text.getJustify(), textDto.getJustify());
	}
}
