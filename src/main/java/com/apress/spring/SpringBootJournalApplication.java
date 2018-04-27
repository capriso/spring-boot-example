package com.apress.spring;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJournalApplication {
    @Bean
    InitializingBean saveData(JournalRepository journalRepository) {
        return () -> {
            journalRepository.save(new Journal("Title 1", "Summary 1", "01/01/2015"));
            journalRepository.save(new Journal("Title 2", "Summary 2", "01/01/2016"));
            journalRepository.save(new Journal("Title 3", "Summary 3", "01/01/2017"));
            journalRepository.save(new Journal("Title 4", "Summary 4", "01/01/2018"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);
    }
}
