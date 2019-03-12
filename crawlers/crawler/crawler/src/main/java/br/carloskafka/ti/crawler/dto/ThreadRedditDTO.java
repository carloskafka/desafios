package br.carloskafka.ti.crawler.dto;

import java.util.ArrayList;
import java.util.List;

public class ThreadRedditDTO {
	private String fullName;
	private int amountOfUpvotes;
	private String threadName;
	private String threadTitle;
	private String commentariesLink;
	private String threadLink;
	private boolean valid;
	private List<String> errors;

	public ThreadRedditDTO() {
		errors = new ArrayList<String>();
		valid = true;
	}

	public void validate() {
		if (fullName == null || fullName.isEmpty()) {
			valid = false;
			errors.add("Invalid name. Input a valid one.");
		}
		if (amountOfUpVotesBelow5000()) {
			valid = false;
			errors.add("Thread upvotes are below 5000. Choose another one with upvotes above 5000.");
		}
		if (threadName == null || threadName.isEmpty()) {
			valid = false;
			errors.add("Invalid thread name. Input a valid one.");
		}
		if (threadTitle == null || threadTitle.isEmpty()) {
			valid = false;
			errors.add("Invalid thread title. Input a valid one.");
		}
		if (commentariesLink == null || commentariesLink.isEmpty()) {
			valid = false;
			errors.add("Invalid commentaries link. Input a valid one.");
		}
		if (threadLink == null || threadLink.isEmpty()) {
			valid = false;
			errors.add("Invalid thread link. Input a valid one.");
		}
	}

	private boolean amountOfUpVotesBelow5000() {
		return amountOfUpvotes < 5000;
	}

	public List<String> getErrors() {
		return errors;
	}

	public boolean valid() {
		return valid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAmountOfUpvotes() {
		return amountOfUpvotes;
	}

	public void setAmountOfUpvotes(String amountOfUpvotes) {
		this.amountOfUpvotes = amountOfUpvotes != null ? Integer.parseInt(amountOfUpvotes) : 0;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public String getThreadTitle() {
		return threadTitle;
	}

	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}

	public String getCommentariesLink() {
		return commentariesLink;
	}

	public void setCommentariesLink(String commentariesLink) {
		this.commentariesLink = commentariesLink;
	}

	public String getThreadLink() {
		return threadLink;
	}

	public void setThreadLink(String threadLink) {
		this.threadLink = threadLink;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThreadRedditDTO other = (ThreadRedditDTO) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThreadRedditDTO [name=" + fullName + ", amountOfUpvotes=" + amountOfUpvotes + ", threadName="
				+ threadName + ", threadTitle=" + threadTitle + ", commentariesLink=" + commentariesLink
				+ ", threadLink=" + threadLink + ", valid=" + valid + ", errors=" + errors + "]";
	}

}
