package br.carloskafka.ti.crawler.dto;

import java.util.ArrayList;
import java.util.List;

public class ThreadManagerDTO {
	private List<ThreadRedditDTO> threadsRedditDto;
	
	public ThreadManagerDTO() {
		threadsRedditDto = new ArrayList<ThreadRedditDTO>();
	}
	
	public void addThreadRedditDtoOnlyIfAbove5000UpVotes(ThreadRedditDTO threadRedditDto) {
		threadRedditDto.validate();
		
		if (threadRedditDto.valid() && !getThreadsRedditDto().contains(threadRedditDto)) {
			threadsRedditDto.add(threadRedditDto);
			System.out.println(threadRedditDto + " added successfully.");
		}
	}
	
	public List<ThreadRedditDTO> getThreadsRedditDto() {
		return threadsRedditDto;
	}

}
