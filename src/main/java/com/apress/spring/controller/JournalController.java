package com.apress.spring.controller;

import com.apress.spring.domain.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JournalController {
    private static List<JournalEntry> entries = new ArrayList<>();
    static {
        try {
            entries.add(new JournalEntry("Introduction to Spring Boot", "Learned Spring Boot", "01/01/2015"));
            entries.add(new JournalEntry("Simple Spring Boot Project", "Created Spring Boot Project", "01/01/2016"));
            entries.add(new JournalEntry("Spring Boot Cloud", "Applied Spring Boot on Cloud", "01/01/2017"));
        } catch (ParseException e) {
           e.printStackTrace();
        }
    }

    @RequestMapping("/journal/all")
    public List<JournalEntry> getAll() {
        return entries;
    }

    @RequestMapping("/journal/findBy/title/{title}")
    public List<JournalEntry> findByTitleContains(@PathVariable String title) {
        return entries
                .stream()
                .filter(entry -> entry.getTitle().toLowerCase().contains(
                        title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/journal", method = RequestMethod.POST)
    public JournalEntry add(@RequestBody JournalEntry entry) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(entry.toString());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        entries.add(entry);
        return entry;
    }
}
