package com.example.springbootmongodb.exception;

public class TodoCollectionException extends  Exception{

    private static final long serialVersionUID = 1L;
    public TodoCollectionException(String message)
    {
        super(message);
    }

    public static String NotFoundException(String id)
    {
        return "Todo with id"+ id+ "not found";
    }
    public static String TodoAlreadyExist()
    {
        return "Todo with given name already exist";
    }
}
