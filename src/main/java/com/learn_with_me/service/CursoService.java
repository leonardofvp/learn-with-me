package com.learn_with_me.service;

import org.springframework.stereotype.Service;

import com.learn_with_me.models.entity.Curso;
import com.learn_with_me.repository.CursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public Iterable<Curso> findAll() {
        return cursoRepository.findAll();
    }
}