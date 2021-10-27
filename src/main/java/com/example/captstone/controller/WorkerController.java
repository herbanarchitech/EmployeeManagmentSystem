package com.example.captstone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.captstone.exception.ResourceNotFoundException;
import com.example.capstone.model.Workers;
import com.example.captstone.repository.WorkerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController 
@RequestMapping("/api/v1")
public class WorkerController{
	@Autowired
	private WorkerRepository workerRepository;
	
	//this is used to get all employees
	@GetMapping("/workers")
	public List  <Workers > getAllWorkers() {
		
		return workerRepository.findAll();
	}
	
	
	//will use this create employees(A.K.A our REST API)
	@PostMapping("/workers")
	public Workers createWorker(@RequestBody Workers worker) {
		return workerRepository.save(worker);
		
		
	}
	
	// we will be using this annotation to query this worker by specifically by ID(worker)
	@GetMapping("employee/{id}")
	
	public ResponseEntity < Workers > getWokerById(@PathVariable Long id) {
		Workers worker = workerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Uh-OH this worker is not existent!" + id));
				return ResponseEntity.ok(worker);
		
	}
	
	
	// will using this annotation for updating the REST API
	
	@PutMapping("/workers{id}")
	public ResponseEntity < Workers > updateWorkers(@PathVariable Long id, @RequestBody Workers workerDetails){
		Workers worker = workerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Uh-OH this worker is not existent!" + id));
		
		
		worker.setEmailAddr(workerDetails.getEmailAddr());
		worker.setfName(workerDetails.getfName());
		worker.setlName(workerDetails.getlName());
		
		Workers updatedWorker = workerRepository.save(worker);
		
		return ResponseEntity.ok(updatedWorker);
	}
 		
	// this will be used to deleted the rest api
	
	@DeleteMapping("/workers/{id}")
    public ResponseEntity < Map < String, Boolean >> deleteWorker(@PathVariable Long id) {
        Workers work = workerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        workerRepository.delete(work);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
	
	
	
 }
}
