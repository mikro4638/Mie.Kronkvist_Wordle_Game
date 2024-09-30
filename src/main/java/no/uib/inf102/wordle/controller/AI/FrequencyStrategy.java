package no.uib.inf102.wordle.controller.AI;

import no.uib.inf102.wordle.model.Dictionary;
import no.uib.inf102.wordle.model.word.WordleWord;
import no.uib.inf102.wordle.model.word.WordleWordList;

import java.util.HashMap;
import java.util.Map;

/**
 * This strategy selects guesses based on letter frequency in the possible 
 * answers. Words with more frequently occurring letters are prioritized.
 */
public class FrequencyStrategy implements IStrategy {

    private Dictionary dictionary;
    private WordleWordList guesses;

    /**
     * Constructor for FrequencyStrategy.
     * Initializes the dictionary and resets the guess list.
     * 
     * @param dictionary the dictionary containing valid words
     */
    public FrequencyStrategy(Dictionary dictionary) {
        this.dictionary = dictionary;
        reset();
    }

    @Override
    public String makeGuess(WordleWord feedback) {
        if (feedback != null) {
            guesses.eliminateWords(feedback); 
        }

        Map<Character, int[]> frequencyTable = calculateFrequencyTable();
        String bestGuess = null;
        int bestScore = -1;

        // Iterate through possible words (m words of length k)
        for (String word : guesses.possibleAnswers()) {
            int score = calculateScore(word, frequencyTable);  // O(k) per word
            if (score > bestScore) {
                bestScore = score;
                bestGuess = word;
            }
        }
        return bestGuess;
    }

    /**
     * Calculates the frequency score for a word by summing the frequencies 
     * of its letters based on their positions.
     * 
     * @param word the word to calculate the score for
     * @param frequencyTable a map of character frequencies for each position
     * @return the frequency score for the word
     */
    private int calculateScore(String word, Map<Character, int[]> frequencyTable) {
        int score = 0;
        char[] letters = word.toCharArray();
        
        // Add the frequency of each letter at its corresponding position
        for (int i = 0; i < letters.length; i++) {
            score += frequencyTable.getOrDefault(letters[i], new int[guesses.wordLength()])[i];
        }
        return score;
    }

    /**
     * Builds a frequency table that tracks how often each letter appears 
     * in each position across all possible words.
     * 
     * @return a map where the key is a character and the value is an array 
     *         representing the frequency of that character at each position
     */
    private Map<Character, int[]> calculateFrequencyTable() {
        Map<Character, int[]> frequencyTable = new HashMap<>();
        int wordLength = guesses.wordLength();

        // Populate frequency table for all m possible words
        for (String word : guesses.possibleAnswers()) {
            char[] letters = word.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                frequencyTable.putIfAbsent(letters[i], new int[wordLength]);
                frequencyTable.get(letters[i])[i]++;
            }
        }
        return frequencyTable;
    }

    @Override
    public void reset() {
        guesses = new WordleWordList(dictionary);
    }
}