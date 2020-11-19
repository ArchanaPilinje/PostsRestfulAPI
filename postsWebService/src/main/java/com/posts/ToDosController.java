package com.posts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dao.ToDosDAOImpl;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("todos")
public class ToDosController {
	ToDosDAOImpl impl = new ToDosDAOImpl();

	@GetMapping("/all")
	public List<ToDos> getToDos() {
		return impl.view();
	}
	
	@PostMapping("/add")
	public ToDos insert(@RequestBody ToDos t) {
		return impl.insert(t);
	}

	@PutMapping("/update/{id}")
	public ToDos updateToDos(@PathVariable int id) {
		return impl.update(id);
	}

	@DeleteMapping("/delete/{id}")
	public Status deleteToDos(@PathVariable int id) {
		return impl.delete(id);
	}
	
	
}
