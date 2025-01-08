package com.springdemo.helloworld1;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    private Map<Integer, String> database = new HashMap<>();
    private int idCounter = 1;

    // GET
    @GetMapping("/")
    public String getIndex() {
        return "Hello, World!";
    }

    // POST
    @PostMapping("/create")
    public String create(@RequestBody String data) {
        database.put(idCounter++, data);
        return "Data created: " + data;
    }

    // PUT
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody String newData) {
        if (database.containsKey(id)) {
            database.put(id, newData);
            return "Data with ID " + id + " updated to: " + newData;
        } else {
            return "Data with ID " + id + " not found.";
        }
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        if (database.containsKey(id)) {
            database.remove(id);
            return "Data with ID " + id + " has been deleted.";
        } else {
            return "Data with ID " + id + " not found.";
        }
    }
}
