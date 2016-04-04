package com.tdd.simple.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tdd.simple.project.vo.WordsVo;

@RestController
@RequestMapping(value="/words")
public class WordsDataController {

	/**
	 * Responsável por retornar os dados da palavra fornecida 
	 * em formato JSON.
	 * @return JSON com os dados da palavra informada.
	 */
	@RequestMapping(value = "/data/{word}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WordsVo> getWordData(@PathParam(value = "{word}") String word) {
		return new ArrayList<>();
	}
}
