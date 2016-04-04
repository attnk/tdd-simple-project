package com.tdd.simple.project.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.tdd.simple.project.enumx.Words;
import com.tdd.simple.project.exceptions.WordDataRepositoryException;
import com.tdd.simple.project.repository.WordDataRepository;
import com.tdd.simple.project.vo.WordsVo;

public class WordDataServiceTest {

	@InjectMocks
	private WordDataService service;
	
	@Mock
	private WordDataRepository repository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveRetornarWordsVoAoReceberUmaPalavraValida() throws WordDataRepositoryException {
		// GIVEN
		WordsVo result;
		WordsVo expected = new WordsVo(
				"\"Ave\" cujo um de seus objetivos de vida é defecar na cabeça dos humanos.", 
				"O pombo deixou o pãozinho de lado, para pegar um batatão!", 
				"http://goo.gl/FXAPTI", 
				"https://goo.gl/Zc6Pl2", 
				Words.POMBO);
		
		Mockito.when(repository.getSingleWord(Matchers.anyString())).thenReturn(expected);
		
		// WHEN
		result = service.getWord(Words.POMBO.name());
		
		// THEN
		Mockito.verify(repository, Mockito.times(1)).getSingleWord(Matchers.anyString());
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void deveRetornarNuloQuandoRepositoryRetornarException() throws WordDataRepositoryException {
		// GIVEN
		WordsVo result;
		Mockito.doThrow(WordDataRepositoryException.class).when(repository).getSingleWord(Matchers.anyString());
		
		// WHEN
		result = service.getWord(Words.POMBO.name());
		
		// THEN
		Mockito.verify(repository, Mockito.times(1)).getSingleWord(Matchers.anyString());
		Assert.assertNull(result);
	}
	
	@Test
	public void deveRetornarMapaComTodasAsPalavrasQuandoSolicitado() {
		// GIVEN
		Map<String, WordsVo> result;
		WordsVo pombo = new WordsVo(
				"\"Ave\" cujo um de seus objetivos de vida é defecar na cabeça dos humanos.", 
				"O pombo deixou o pãozinho de lado, para pegar um batatão!", 
				"http://goo.gl/FXAPTI", 
				"https://goo.gl/Zc6Pl2", 
				Words.POMBO);
		
		Map<String, WordsVo> expected = new HashMap<>();
		expected.put(Words.POMBO.name(), pombo);
		
		
		Mockito.when(repository.getAllWordsData()).thenReturn(expected);
		
		// WHEN
		result = service.getAllWords();
		
		// THEN
		Mockito.verify(repository, Mockito.times(1)).getAllWordsData();
		Assert.assertEquals(expected, result);
	}
}
