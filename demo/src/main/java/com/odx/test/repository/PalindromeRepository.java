package com.odx.test.repository;

import com.odx.test.entity.Palindrome;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends CrudRepository<Palindrome, Integer> {


}
