package com.tdd.simple.project.vo;

import java.io.Serializable;

import com.tdd.simple.project.enumx.Words;

public class WordsVo implements Serializable {
	
	private static final long serialVersionUID = -7458589281645047787L;
	
	private String definition;
	private String phrase;
	private String imageUrl;
	private String wikiUrl;
	private int numberOfCharacters;
	private Words word;
	
	public WordsVo(String definition, String phrase, String imageUrl, String wikiUrl, Words word) {
		this.definition = definition;
		this.phrase = phrase;
		this.imageUrl = imageUrl;
		this.wikiUrl = wikiUrl;
		this.word = word;
	}

	public int getNumberOfCharacters() {
		return numberOfCharacters;
	}

	public void setNumberOfCharacters(int numberOfCharacters) {
		this.numberOfCharacters = numberOfCharacters;
	}

	public String getDefinition() {
		return definition;
	}

	public String getPhrase() {
		return phrase;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getWikiUrl() {
		return wikiUrl;
	}

	public Words getWord() {
		return word;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WordsVo [definition=");
		builder.append(definition);
		builder.append(", phrase=");
		builder.append(phrase);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", wikiUrl=");
		builder.append(wikiUrl);
		builder.append(", numberOfCharacters=");
		builder.append(numberOfCharacters);
		builder.append(", word=");
		builder.append(word);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((definition == null) ? 0 : definition.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + numberOfCharacters;
		result = prime * result + ((phrase == null) ? 0 : phrase.hashCode());
		result = prime * result + ((wikiUrl == null) ? 0 : wikiUrl.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordsVo other = (WordsVo) obj;
		if (definition == null) {
			if (other.definition != null)
				return false;
		} else if (!definition.equals(other.definition))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (numberOfCharacters != other.numberOfCharacters)
			return false;
		if (phrase == null) {
			if (other.phrase != null)
				return false;
		} else if (!phrase.equals(other.phrase))
			return false;
		if (wikiUrl == null) {
			if (other.wikiUrl != null)
				return false;
		} else if (!wikiUrl.equals(other.wikiUrl))
			return false;
		if (word != other.word)
			return false;
		return true;
	}
	
}
