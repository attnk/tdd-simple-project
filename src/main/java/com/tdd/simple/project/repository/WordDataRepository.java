package com.tdd.simple.project.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tdd.simple.project.enumx.Words;
import com.tdd.simple.project.exceptions.WordDataRepositoryException;
import com.tdd.simple.project.vo.WordsVo;

/**
 * Responsável por retornar os dados ficticios
 * de cada palavra - Os dados estão em um mapa. 
 *
 */
@Component
public class WordDataRepository {
	
	private Map<String, WordsVo> wordsMap;
	
	public WordDataRepository() {
		wordsMap = generateWordsMap();
	}
	
	private Map<String, WordsVo> generateWordsMap() {
		Map<String, WordsVo> map = new HashMap<>();
		
		//TDD
		map.put(Words.TDD.name(), 
				new WordsVo(
					"Test Driven Development", 
					"TDD vamos treinar e aprender!", 
					"http://goo.gl/ilolXb", 
					"https://goo.gl/COJ3gV", 
					Words.TDD)
				);
		//POMBO
		map.put(Words.POMBO.name(), 
				new WordsVo(
					"\"Ave\" cujo um de seus objetivos de vida é defecar na cabeça dos humanos.", 
					"O pombo deixou o pãozinho de lado, para pegar um batatão!", 
					"http://goo.gl/FXAPTI", 
					"https://goo.gl/Zc6Pl2", 
					Words.POMBO)
				);
		//BATMAN
		map.put(Words.BATMAN.name(), 
				new WordsVo(
					"Herói/detetive bilionário, que perdeu os pais logo em sua infância, combate o crime de sua cidade.", 
					"Batman vs Superman, vale a pena?", 
					"http://goo.gl/rP7wUu", 
					"https://goo.gl/YjWmv3", 
					Words.BATMAN)
				);
		
		//SUPERMAN
		map.put(Words.SUPERMAN.name(), 
				new WordsVo(
					"Um Super-herói cuja origem é extra-terrestre, utiliza seus poderes super humanos para savar a terra de diversos males...", 
					"Superman, o todo quase onipotente...", 
					"goo.gl/FjuCiw", 
					"https://goo.gl/59Ekst", 
					Words.SUPERMAN)
				);
		
		//IRONMAN
		map.put(Words.IRONMAN.name(), 
				new WordsVo(
					"Ironman, um super ricasso conhecedor de muitos recursos tecnológicos e armamentistas, criou sua própria armadura.", 
					"Ironman um dos lados da Guerra Civil da Marvel. #TEAMIRON", 
					"http://goo.gl/39mLxm", 
					"https://goo.gl/Y6EEzq", 
					Words.IRONMAN)
				);
		
		//CAPTAIN_AMERICA
		map.put(Words.CAPTAIN_AMERICA.name(), 
				new WordsVo(
					"Captain America, um super soldado originário da Segunda Guerra Mundial, é um dos líderes e ícones dos quadrinhos da Marvel.", 
					"Captain America um dos lados da Guerra Civil da Marvel. #TEMACAPTAIN", 
					"http://goo.gl/HhijoO", 
					"https://goo.gl/ChJnNj", 
					Words.CAPTAIN_AMERICA)
				);
		
		return map;
	}

	/**
	 * Retorna o mapa contendo todos dados de todas as palavras.
	 * @return Mapa com os dados de todas as palavras cadastradas.
	 */
	public Map<String, WordsVo> getAllWordsData() {
		return this.wordsMap;
	}
	
	/**
	 * Retorna uma palavra contendo os dados da palavra definida como busca.
	 * @param word {@link Enum} referente a palavra buscada.
	 * @return A palavra com suas definições.
	 * @throws WordDataRepositoryException 
	 */
	public WordsVo getSingleWord(Words word) throws WordDataRepositoryException {
		if(word == null || !this.wordsMap.containsKey(word.name())) {
			throw new WordDataRepositoryException("Palavra não encontrada!");
		}
		return this.wordsMap.get(word.name());
	}
}
