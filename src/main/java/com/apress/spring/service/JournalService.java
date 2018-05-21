package com.apress.spring.service;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    public static final Logger logger = LoggerFactory.getLogger(JournalService.class);

    @Autowired
    private JournalRepository journalRepository;

    public Journal save(Journal journal) {
        return journalRepository.save(journal);
    }

    public List<Journal> findAll() {
        return journalRepository.findAll();
    }

    public List<Journal> findByTitleContaining(String word) {
        return journalRepository.findByTitleContaining(word);
    }
}
