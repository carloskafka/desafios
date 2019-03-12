package br.carloskafka.ti.crawler;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.carloskafka.ti.crawler.dto.ThreadManagerDTO;
import br.carloskafka.ti.crawler.pages.RedditPage;
import br.carloskafka.ti.crawler.utils.DriverUtils;

@SpringBootApplication
public class CrawlerApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(CrawlerApplication.class, args);
		
		ThreadManagerDTO threadManagerDto = new ThreadManagerDTO();
		
		DriverUtils.inicializarFirefoxDriver();
		RedditPage redditPage = new RedditPage();
		
		Scanner scanner = new Scanner(System.in);
		String threadName = scanner.nextLine();
		
		int amountOfPages = 10;
 		for (String threadNameSplitted : threadName.split(";")) {
			redditPage.redirectToThread(threadNameSplitted);
			redditPage.loadThreadRedditDtos(threadManagerDto, amountOfPages);
		}
		
		System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(threadManagerDto.getThreadsRedditDto()));
		scanner.close();
	}

}
