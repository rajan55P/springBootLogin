package com.example.springbootmongodb.service;

import com.example.springbootmongodb.exception.TodoCollectionException;
import com.example.springbootmongodb.model.TodoDTO;

public interface TodoService {
    public void createTodo(TodoDTO todo) throws TodoCollectionException;
    public TodoDTO getSingleTodo(String id) throws TodoCollectionException;
    public void updateTode(String id,TodoDTO todo) throws TodoCollectionException;
}
