package idwall.desafio.dto;

import java.util.ArrayList;
import java.util.List;

public class FormatContentCommandResultDTO {
	private List<String> errors;
	private List<String> messages;
	private boolean sucessful;
	private TextDTO updatedTextDto;

	public FormatContentCommandResultDTO() {
		errors = new ArrayList<>();
		messages = new ArrayList<>();
	}

	public TextDTO getUpdatedTextDto() {
		return updatedTextDto;
	}

	public void setUpdatedTextDto(TextDTO updatedTextDto) {
		this.updatedTextDto = updatedTextDto;
		markAsSuccessful();
	}

	public boolean sucessful() {
		return sucessful;
	}

	public void addMessage(String message) {
		messages.add(message);
	}

	public void addError(String error) {
		errors.add(error);
	}

	public void markAsSuccessful() {
		sucessful = true;
	}

	public String getMessageDescriptions() {
		return getDescriptions(messages);
	}

	public String getErrorDescriptions() {
		return getDescriptions(errors);
	}

	public String getDescriptions(List<String> messagesDescriptions) {
		String descriptions = "";

		for (String description : messagesDescriptions) {
			descriptions += description + "\n";
		}

		return descriptions;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public List<String> getErrors() {
		return errors;
	}

	public List<String> getMessages() {
		return messages;
	}

	@Override
	public String toString() {
		return "FormatContentCommandResultDTO [errors=" + errors + ", messages=" + messages + ", sucessful=" + sucessful
				+ ", updatedTextDto=" + updatedTextDto + "]";
	}

}
