package idwall.desafio.factory;

import idwall.desafio.domain.Text;
import idwall.desafio.dto.TextDTO;

public class TextFactory {

	public Text convertToDomain(TextDTO textDto) {
		Text text = null;

		if (textDto != null) {
			text = new Text();

			text.setContent(textDto.getContent());
			text.setMaxLength(textDto.getMaxLength());
			text.setJustify(textDto.getJustify());
		}

		return text;
	}

	public TextDTO convertToDTO(Text text) {
		TextDTO textDto = null;

		if (text != null) {
			textDto = new TextDTO();

			textDto.setContent(text.getContent());
			textDto.setMaxLength(text.getMaxLength());
			textDto.setJustify(text.getJustify());
			textDto.setUpdatedContent(text.getUpdatedContent());
		}

		return textDto;
	}
}
