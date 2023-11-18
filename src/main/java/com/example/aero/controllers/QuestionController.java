package com.example.aero.controllers;

import com.example.aero.dto.Question;
import com.example.aero.model.QCatLim;
import com.example.aero.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @CrossOrigin
    @GetMapping("/get/{id}")
    Question getQuestion(@PathVariable int id) {
        return questionService.getById(id);
    }

    @CrossOrigin
    @GetMapping("/get/category/{cId}")
    List<Question> getQuestionByCategory(@PathVariable int cId) {
        return questionService.getByCategory(cId);
    }

    @CrossOrigin
    @PostMapping("/add")
    Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @CrossOrigin
    @PostMapping("/get/categories")
    List<Question> getQuestionForCategoryList(@RequestBody QCatLim qcatLim){
        return questionService.getForCategoryList(qcatLim);
    }
}
