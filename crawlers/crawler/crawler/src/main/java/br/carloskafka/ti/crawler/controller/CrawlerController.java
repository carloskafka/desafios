package br.carloskafka.ti.crawler.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.carloskafka.ti.crawler.dto.ThreadRedditDTO;

@RestController
public class CrawlerController {

	@GetMapping("/threads/{threadName}")
	public List<ThreadRedditDTO> fetchApi(@PathVariable String threadName) {
		return Arrays.asList(new ThreadRedditDTO());
	}
	
}
