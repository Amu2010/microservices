package com.odx.test.service;

import com.odx.test.entity.Palindrome;
import com.odx.test.repository.PalindromeRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

  @Autowired
  PalindromeRepository palindromeRepository;

  public int store(String input) {
    if (input == null || input.length() < 2) {
      Palindrome palindrome = new Palindrome(input);
      palindromeRepository.save(palindrome);
      return palindrome.getId();
    }

    int length = input.length();

    boolean[][] isPalindrome = new boolean[length][length];

    int left = 0;
    int right = 0;

    for (int j = 1; j < length; j++) {
      for (int i = 0; i < j; i++) {
        boolean isInnerWordPalindrome = isPalindrome[i + 1][j - 1] || j - i <= 2;

        if (input.charAt(i) == input.charAt(j) && isInnerWordPalindrome) {
          isPalindrome[i][j] = true;

          if (j - i > right - left) {
            left = i;
            right = j;
          }
        }
      }
    }

    Palindrome palindrome = new Palindrome(input.substring(left, right + 1));
    palindromeRepository.save(palindrome);
    return palindrome.getId();
  }

  public String getLongestPalindrome(int id) {
    Optional<Palindrome> palindrome = palindromeRepository.findById(id);
    if (palindrome.isPresent()) {
      return palindrome.get().getName();
    }
    return "";
  }

}
