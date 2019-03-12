package idwall.desafio.domain;

import java.text.BreakIterator;
import java.util.Locale;

public class Text {
	private static final String NEW_LINE_DELIMITER = "\n";
	
	private String content;
	private int maxLength;

	public Text(String content, int maxLength) {
		this.content = content;
		this.maxLength = maxLength;
	}

	public String formatLines() {
		String formattedText = "";

		if (content != null && !content.isEmpty()) {
			BreakIterator boundary = BreakIterator.getLineInstance(Locale.getDefault());
			boundary.setText(content);
			int start = boundary.first();
			int end = boundary.next();
			int lineLength = 0;
			String fullWord = "";

			while (end != BreakIterator.DONE) {
				String word = content.substring(start, end);

				lineLength = lineLength + word.length();
				if (lineLength >= maxLength) {
					lineLength = word.length();

					int fullWordMinusOne = fullWord.length() - 1;
					if (fullWordMinusOne != -1) {
						fullWord = fullWord.substring(0, fullWord.length() - 1);
					}
					formattedText += fullWord + NEW_LINE_DELIMITER;
					fullWord = "";
				}
				if ((!word.isEmpty() || end == BreakIterator.DONE)) {
					fullWord += word;
				}
				start = end;
				end = boundary.next();
			}
			formattedText += fullWord + NEW_LINE_DELIMITER;

			formattedText = convertNewLineToWindows(formattedText);
		}

		return formattedText;
	}

	private String convertNewLineToWindows(String formattedText) {
		return formattedText.replaceAll(NEW_LINE_DELIMITER, "\r\n");
	}

	@Override
	public String toString() {
		return "Text [content=" + content + ", maxLength=" + maxLength + "]";
	}

}
