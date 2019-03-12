package br.carloskafka.ti.crawler.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.carloskafka.ti.crawler.dto.ThreadManagerDTO;
import br.carloskafka.ti.crawler.dto.ThreadRedditDTO;
import br.carloskafka.ti.crawler.utils.DriverUtils;

public class RedditPage extends BasePage {
	private static final String ATTRIBUTE_FULL_NAME = "data-fullname";
	private static final String ATTRIBUTE_AMOUNT_OF_UPVOTES = "data-score";
	private static final String ATTRIBUTE_THREAD_NAME = "data-subreddit";
	private static final String ATTRIBUTE_THREAD_TITLE = "title";
	private static final String ATTRIBUTE_COMMENTARIES_LINK = "data-permalink";
	private static final String ATTRIBUTE_THREAD_LINK = "data-url";
	
	private static final String PREFIX_HTTPS = "https";
	
	private static final String URL_BASE_OLD_REDDIT = "https://old.reddit.com";

	private String threadName;
	
	public void redirectToThread(String threadName) {
		this.threadName = threadName;
		DriverUtils.ir(URL_BASE_OLD_REDDIT + "/r/" + threadName);
	}

	public void loadThreadRedditDtos(ThreadManagerDTO threadManagerDto, int amountOfPages) {
		int pageActual = 0;
		do {
			List<WebElement> elements = DriverUtils.getDriver().findElement(By.id("siteTable"))
					.findElements(By.tagName("div"));

			System.out.println(elements.size() + " records found to the threadName: " + threadName);
			for (int i = 0; i < elements.size(); i++) {
				System.out.println((i + 1) + " of " + elements.size());
				WebElement element = elements.get(i);
				String classText = element.getAttribute("data-context");

				if (classText != null && classText.equals("listing")) {
					ThreadRedditDTO threadRedditDto = new ThreadRedditDTO();

					threadRedditDto.setFullName(getFullName(element));
					threadRedditDto.setAmountOfUpvotes(getAmountOfUpvotes(element));
					threadRedditDto.setThreadName(getThreadName(element));
					threadRedditDto.setThreadTitle(getThreadTitle(element));
					threadRedditDto.setCommentariesLink(getCommentariesLink(element));
					threadRedditDto.setThreadLink(getThreadLink(element));

					threadManagerDto.addThreadRedditDtoOnlyIfAbove5000UpVotes(threadRedditDto);
				}
			}
			
			DriverUtils.getDriver().findElement(By.className("next-button")).click();
			pageActual++;
		} while (pageActual <= amountOfPages);
	}

	private String getThreadLink(WebElement element) {
		return element.getAttribute(ATTRIBUTE_THREAD_LINK).startsWith(PREFIX_HTTPS)
				? element.getAttribute(ATTRIBUTE_THREAD_LINK)
				: URL_BASE_OLD_REDDIT + element.getAttribute(ATTRIBUTE_THREAD_LINK);
	}

	private String getCommentariesLink(WebElement element) {
		return element.getAttribute(ATTRIBUTE_COMMENTARIES_LINK).startsWith(PREFIX_HTTPS)
				? element.getAttribute(ATTRIBUTE_COMMENTARIES_LINK)
				: URL_BASE_OLD_REDDIT + element.getAttribute(ATTRIBUTE_COMMENTARIES_LINK);
	}

	private String getThreadTitle(WebElement element) {
		return element.findElement(By.className(ATTRIBUTE_THREAD_TITLE)).getText();
	}

	private String getThreadName(WebElement element) {
		return element.getAttribute(ATTRIBUTE_THREAD_NAME);
	}

	private String getAmountOfUpvotes(WebElement element) {
		return element.getAttribute(ATTRIBUTE_AMOUNT_OF_UPVOTES);
	}
	
	private String getFullName(WebElement element) {
		return element.getAttribute(ATTRIBUTE_FULL_NAME);
	}
}
