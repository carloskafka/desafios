package idwall.desafio.domain;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* Domain class responsible for format text
 * it could be persisted in database if it was necessary.
 * it also validate input given by user*/
public class Text {
	private static final String NEW_LINE_DELIMITER = "\n";

	private String content;
	private String updatedContent;
	private Boolean justify;
	private Integer maxLength;
	private boolean valid;
	private List<String> errors;

	public Text() {
		errors = new ArrayList<>();
		valid = true;
		updatedContent = "";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpdatedContent() {
		return updatedContent;
	}

	public void setUpdatedContent(String updatedContent) {
		this.updatedContent = updatedContent;
	}

	public Boolean getJustify() {
		return justify;
	}

	public void setJustify(Boolean justify) {
		this.justify = justify;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void addError(String error) {
		errors.add(error);
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void setValidado(boolean validado) {
		this.valid = validado;
	}

	public void validateInput() {
		if (content == null || content.isEmpty()) {
			valid = false;
			addError("Invalid content. Input a valid one");
		}
		if (maxLength == 0) {
			valid = false;
			addError("Invalid max length. Input a max length greater than 0.");
		}
	}

	public boolean valid() {
		return valid;
	}

	public String getErrorDescriptions() {
		String errorDescriptions = "";

		for (String error : errors) {
			errorDescriptions += error + "\n";
		}

		return errorDescriptions;
	}

	public void formatLines() {
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
					updatedContent += fullWord + NEW_LINE_DELIMITER;
					fullWord = "";
				}
				if ((!word.isEmpty() || end == BreakIterator.DONE)) {
					fullWord += word;
				}
				start = end;
				end = boundary.next();
			}
			updatedContent += fullWord + NEW_LINE_DELIMITER;

			updatedContent = convertNewLineToWindows(updatedContent);
		}

	}

	private String convertNewLineToWindows(String text) {
		return text.replaceAll(NEW_LINE_DELIMITER, "\r\n");
	}

	@Override
	public String toString() {
		return "Text [content=" + content + ", maxLength=" + maxLength + "]";
	}

}
