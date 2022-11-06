package com.example.demoSpring.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();

    private static int idCounter = 0;

    static{
        todos.add(new Todo(++idCounter, "AmyLeon","Learn to dance", new Date(), false));
        todos.add(new Todo(++idCounter, "AmyLeon","Clean room", new Date(), false));
        todos.add(new Todo(++idCounter, "AmyLeon","Study", new Date(), false));
    }

    public List<Todo>findAll(){
        return todos;
    }


    //delete method
    public Todo deleteById(long id){
        Todo todo = findById(id);
        if(todo==null) return null;

        if(todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {

        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);

        }else{
            //use delete by id method, delete it,
            //then add the new to do to that id
            deleteById(todo.getId());
            todos.add(todo);
        }
        //return the updated todo
        return todo;
    }


}
