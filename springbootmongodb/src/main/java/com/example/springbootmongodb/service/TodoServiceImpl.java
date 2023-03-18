package com.example.springbootmongodb.service;

import com.example.springbootmongodb.exception.TodoCollectionException;
import com.example.springbootmongodb.model.TodoDTO;
import com.example.springbootmongodb.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepo;
    @Override
    public void createTodo(TodoDTO todo) throws TodoCollectionException {
     Optional<TodoDTO> todoOptional= todoRepo.findByTodo(todo.getTodo());
     if(todoOptional.isPresent())
     {
         throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExist());
     }
     else {
         todo.setCreatedAt(new Date(System.currentTimeMillis()));
         todoRepo.save(todo);
     }
    }

    @Override
    public TodoDTO getSingleTodo(String id) throws TodoCollectionException {
    Optional<TodoDTO> optionalTodo =   todoRepo.findById(id);
    if(!optionalTodo.isPresent())
    {
        throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
    }
    else {
        return optionalTodo.get();
    }
    }

    @Override
    public void updateTode(String id, TodoDTO todo) throws TodoCollectionException {
        Optional<TodoDTO> optionalTodo= todoRepo.findById(id);
        Optional<TodoDTO> todoWithSameName=todoRepo.findByTodo(todo.getTodo());

         if(optionalTodo.isPresent())
         {
             if(todoWithSameName.isPresent() && todoWithSameName.get().getId().equals(id))
             {
                 throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExist());

             }
             TodoDTO todotosave= optionalTodo.get();
             todotosave.setTodo(todo.getTodo()!=null ? todo.getTodo():todotosave.getTodo());
             todotosave.setDescription(todo.getDescription()!=null ? todo.getDescription():
                     todotosave.getDescription());
             todoRepo.save(todotosave);
         }
         else {
             throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
         }
    }
}
