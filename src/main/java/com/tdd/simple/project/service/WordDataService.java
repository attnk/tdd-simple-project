package com.tdd.simple.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdd.simple.project.exceptions.WordDataRepositoryException;
import com.tdd.simple.project.repository.WordDataRepository;
import com.tdd.simple.project.vo.WordsVo;

@Service
public class WordDataService {

	@Autowired
	private WordDataRepository repository;
	
	public WordsVo getWord(String name) {
		try {
			return repository.getSingleWord(name);
		} catch (WordDataRepositoryException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, WordsVo> getAllWords() {
		return repository.getAllWordsData();
	}

}
