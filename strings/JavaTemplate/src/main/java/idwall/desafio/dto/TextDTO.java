package idwall.desafio.dto;

/* 
 * DTO class responsible for transfering data between client and server
 * */
public class TextDTO {
	private String content;
	private String updatedContent;
	private Integer maxLength;
	private Boolean justify;

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

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public Boolean getJustify() {
		return justify;
	}

	public void setJustify(Boolean justify) {
		this.justify = justify;
	}

	@Override
	public String toString() {
		return "TextDTO [content=" + content + ", updatedContent=" + updatedContent + ", maxLength=" + maxLength
				+ ", justify=" + justify + "]";
	}

}
