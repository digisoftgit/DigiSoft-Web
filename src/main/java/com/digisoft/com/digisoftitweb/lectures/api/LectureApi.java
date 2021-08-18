package com.digisoft.com.digisoftitweb.lectures.api;

import com.digisoft.com.digisoftitweb.lectures.entity.request.LecturesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lecture")
public interface LectureApi {

    @GetMapping("/all")
    ResponseEntity<?> showAll();

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody LecturesRequest lecturesRequest);

    @PutMapping("/update")
    ResponseEntity<?> update(@RequestBody LecturesRequest lecturesRequest);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id);
}
