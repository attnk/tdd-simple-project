package com.tdd.simple.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.http.HttpStatus;
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
	 * @throws IOException 
	 */
	@RequestMapping(value = "/data/{word}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WordsVo> getWordData(@PathParam(value = "{word}") String word, HttpServletResponse response) {
		try {
			return new ArrayList<>();
		} catch (Exception e) {
			try {
				response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}
	}
}
