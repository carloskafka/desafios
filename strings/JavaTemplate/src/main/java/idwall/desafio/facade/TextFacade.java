package idwall.desafio.facade;

import idwall.desafio.domain.Text;
import idwall.desafio.dto.FormatContentCommandResultDTO;
import idwall.desafio.dto.TextDTO;
import idwall.desafio.factory.TextFactory;
import idwall.desafio.repository.FileRepository;
import idwall.desafio.repository.FileRepositoryImpl;

public class TextFacade {

	private FileRepository fileRepository;

	public TextFacade() {
		fileRepository = new FileRepositoryImpl();
	}

	public FormatContentCommandResultDTO format(TextDTO textDto) {
		FormatContentCommandResultDTO formatContentCommandResult = new FormatContentCommandResultDTO();

		Text text = new TextFactory().convertToDomain(textDto);

		text.validateInput();

		if (text.valid()) {
			if (text.getJustify()) {
				formatContentCommandResult.addError("Justify was detected enabled");
				formatContentCommandResult.addError("ERROR: Justify process under development :(");
			} else {
				text.formatLines();

				if (fileRepository.saveFile(text.getUpdatedContent())) {
					formatContentCommandResult.addMessage("Inputs: ");
					formatContentCommandResult.addMessage("Text: " + text.getContent());
					formatContentCommandResult.addMessage("Limit: " + text.getMaxLength());
					formatContentCommandResult.addMessage("Should text.getJustify(): " + text.getJustify());
					formatContentCommandResult.addMessage("=========================");

					formatContentCommandResult.addMessage("\nOutput: ");
					formatContentCommandResult.addMessage(text.getUpdatedContent());
					formatContentCommandResult.addMessage("=========================");
					
					formatContentCommandResult.setUpdatedTextDto(new TextFactory().convertToDTO(text));
				} 
			}
		} else {
			formatContentCommandResult.setErrors(text.getErrors());
		}

		return formatContentCommandResult;
	}

}
