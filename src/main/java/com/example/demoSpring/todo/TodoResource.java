package com.example.demoSpring.todo;

import com.example.demoSpring.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();

    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){
        return todoService.findById(id);

    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
       Todo todo =  todoService.deleteById(id);
       if(todo!=null){
           //if success
           return ResponseEntity.noContent().build();
       }

       return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{todo_id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
                                           @RequestBody Todo todo){
       Todo todoUpdated = todoService.save(todo);
       return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        }


    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo2(@PathVariable String username, @PathVariable long id,

                                           @RequestBody Todo todo){
        //call save method and got the details of the created todo
        Todo createdTodo = todoService.save(todo);

        //Location
        //Get current URL
        //{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }


}
