package idwall.desafio;

import idwall.desafio.dto.FormatContentCommandResultDTO;
import idwall.desafio.dto.TextDTO;
import idwall.desafio.facade.TextFacade;

public class Main {

	private static final String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
			+ "\n"
			+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
	private static final Integer DEFAULT_LIMIT = 42;
	private static final Boolean DEFAULT_JUSTIFY = false;

	public static void main(String[] args) throws Exception {
		String content = DEFAULT_INPUT_TEXT;
		Integer maxLength = DEFAULT_LIMIT;
		Boolean justify = DEFAULT_JUSTIFY;

		switch (args.length) {
		case 1:
			content = args[0];
			break;
		case 2:
			content = args[0];
			maxLength = Integer.parseInt(args[1]);
			break;
		case 3:
			content = args[0];
			maxLength = Integer.parseInt(args[1]);
			justify = Boolean.parseBoolean(args[2]);
			break;
		}

		TextFacade facadeFormatter = new TextFacade();

		TextDTO textDto = new TextDTO();

		textDto.setContent(content);
		textDto.setMaxLength(maxLength);
		textDto.setJustify(justify);

		FormatContentCommandResultDTO formatContentCommandResult = facadeFormatter.format(textDto);

		if (formatContentCommandResult.sucessful()) {
			System.out.println(formatContentCommandResult.getMessageDescriptions());
		} else {
			System.out.println(formatContentCommandResult.getErrorDescriptions());
		}
	}

}
