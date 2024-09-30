package no.uib.inf102.wordle.controller.AI;

import no.uib.inf102.wordle.model.Dictionary;
import no.uib.inf102.wordle.model.word.WordleWord;
import no.uib.inf102.wordle.model.word.WordleWordList;

import java.util.*;

public class MyStrategy implements IStrategy {
    private WordleWordList guesses;
    private Dictionary dictionary;

    /**
     * Constructor for MyStrategy.
     * Initializes the dictionary and resets the guess list.
     *
     * @param dictionary the dictionary containing valid words
     */
    public MyStrategy(Dictionary dictionary) {
        this.dictionary = dictionary;
        reset();
    }

    @Override
    public String makeGuess(WordleWord feedback) {
        if (feedback != null) {
            guesses.eliminateWords(feedback);
        }
        return selectBestGuess();
    }

    /**
     * Selects the best guess based on expected scores.
     *
     * @return the word with the highest expected score or the first possible answer if none exist
     */
    private String selectBestGuess() {
        List<String> possibleAnswers = guesses.possibleAnswers();
        if (possibleAnswers.isEmpty()) {
            return ""; 
        }
    
        Map<String, Integer> expectedScores = calculateExpectedScores(possibleAnswers);
        
        String bestGuess = possibleAnswers.get(0); 
        int highestScore = expectedScores.get(bestGuess); 
    
        for (String candidate : possibleAnswers) {
            int score = expectedScores.get(candidate);
            if (score > highestScore) {
                highestScore = score;
                bestGuess = candidate;
            }
        }
    
        return bestGuess; 
    }

    /**
     * Calculates expected scores for each possible answer based on letter frequencies.
     *
     * @param possibleAnswers the list of possible answers
     * @return a map of words to their expected scores
     */
    private Map<String, Integer> calculateExpectedScores(List<String> possibleAnswers) {
        Map<String, Integer> expectedScores = new HashMap<>();
        Map<Character, Integer> letterFrequencies = calculateLetterFrequencies(possibleAnswers);

        for (String candidate : possibleAnswers) {
            int score = calculateFrequencyScore(candidate, letterFrequencies);
            expectedScores.put(candidate, score);
        }

        return expectedScores;
    }

    /**
     * Calculates the frequency score for a word based on the letters it contains
     * and their occurrence in possible answer words.
     *
     * @param guess the word to evaluate
     * @param letterFrequencies the frequency map of letters
     * @return the calculated frequency score
     */
    private Integer calculateFrequencyScore(String guess, Map<Character, Integer> letterFrequencies) {
        int score = 0;
        Set<Character> uniqueLetters = new HashSet<>();
        for (char c : guess.toCharArray()) {
            if (uniqueLetters.add(c)) { 
                score += letterFrequencies.getOrDefault(c, 0);
            }
        }
        return score;
    }

    /**
     * Calculates the frequency of letters in possible answer words.
     *
     * @param possibleAnswers The list of possible answers.
     * @return A map storing how many times each letter occurs.
     */
    private Map<Character, Integer> calculateLetterFrequencies(List<String> possibleAnswers) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (String word : possibleAnswers) {
            for (char c : word.toCharArray()) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }
        return frequencyMap;
    }

    @Override
    public void reset() {
        guesses = new WordleWordList(dictionary);
    }
}