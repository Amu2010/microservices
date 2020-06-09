package com.odx.test.controller;

import com.odx.test.service.PalindromeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {

  @Autowired
  PalindromeService palindromeService;

  @GetMapping(value = "/store")
  public int storeLongestPalindrome(@RequestParam String input) {
    return palindromeService.store(input);
  }

  @GetMapping("/getLongestPalindrome")
  public String getLongestPalindrome(@RequestParam int id) {
    return palindromeService.getLongestPalindrome(id);
  }
}
