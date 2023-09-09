package com.learn_with_me.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn_with_me.models.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
