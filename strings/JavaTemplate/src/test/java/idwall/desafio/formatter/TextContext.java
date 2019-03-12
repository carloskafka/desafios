package idwall.desafio.formatter;

import idwall.desafio.domain.Text;
import idwall.desafio.dto.TextDTO;

public class TextContext {

	public static TextDTO createInvalidTextDTO() {
		String content = null;
		String updatedContent = null;
		Integer maxLength = 0;
		Boolean justify = false;

		TextDTO textDto = new TextDTO();

		textDto.setContent(content);
		textDto.setUpdatedContent(updatedContent);
		textDto.setMaxLength(maxLength);
		textDto.setJustify(justify);

		return textDto;
	}
	
	public static TextDTO createValidTextDTO() {
		String content = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
				+ "\n"
				+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
		String updatedContentExpected = "In the beginning God created the heavens\r\n" 
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

		TextDTO textDto = new TextDTO();

		textDto.setContent(content);
		textDto.setUpdatedContent(updatedContentExpected);
		textDto.setMaxLength(maxLength);
		textDto.setJustify(justify);
		
		return textDto;
	}
	
	public static Text createInvalidText() {
		String content = null;
		String updatedContent = null;
		Integer maxLength = 0;
		Boolean justify = false;

		Text text = new Text();

		text.setContent(content);
		text.setUpdatedContent(updatedContent);
		text.setMaxLength(maxLength);
		text.setJustify(justify);

		return text;
	}
	
	public static Text createValidText() {
		String content = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
				+ "\n"
				+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
		String updatedContentExpected = "In the beginning God created the heavens\r\n" 
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

		Text text = new Text();

		text.setContent(content);
		text.setUpdatedContent(updatedContentExpected);
		text.setMaxLength(maxLength);
		text.setJustify(justify);
		
		return text;
	}

}