package com.example.springbootmongodb.model;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="todos")
public class TodoDTO {

    @Id
    private String id;
    @NotNull("todo can not be null")
    private String todo;
    @NotNull("description can not be null")
    private String description;
    @NotNull("completed can not be null")
    private boolean completed;
    private Date createdAt;
    private Date updatedAt;
}
