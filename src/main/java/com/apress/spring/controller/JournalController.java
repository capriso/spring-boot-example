package com.apress.spring.controller;

import com.apress.spring.domain.Journal;
import com.apress.spring.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JournalController {
    @Autowired
    private JournalService journalService;

    @RequestMapping("/journal/all")
    public List<Journal> getAll() {
        return journalService.findAll();
    }

    @RequestMapping("/journal/findBy/title/{title}")
    public List<Journal> findByTitleContaining(@PathVariable String title) {
        return journalService.findByTitleContaining(title);
    }

    @RequestMapping(value = "/journal", method = RequestMethod.POST)
    public Journal add(@RequestBody Journal journal) {
        return journalService.save(journal);
    }
}
