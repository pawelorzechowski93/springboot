package com.orzechowski.Controller;

import com.orzechowski.Dao.TaskDao;
import com.orzechowski.Entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
 // @RequestMapping("/api")

/**
 * Created by user on 29.11.2016.
 */
public class TaskController {

    @Autowired
     private TaskDao taskDao;

     @RequestMapping(value = "/task", method = RequestMethod.GET)
    public List<Task> getAllTasks(){

        return this.taskDao.findAll();

    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
     public Task getTaskById(@PathVariable("id") int id){


            return this.taskDao.findOne(id);


    }


     @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
     public void deleteTaskById(@PathVariable("id") int id){
            this.taskDao.delete(id);
     }

    @RequestMapping(value = "/task", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insertTask(@RequestBody Task task){

         this.taskDao.save(task);
        return new ResponseEntity(task,HttpStatus.CREATED);
    }


     @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity updateTask(@PathVariable("id") int id,@RequestBody Task task) {

            if(this.taskDao.findOne(id)!= null) {

                Task t = this.taskDao.findOne(id);
                if (task.getName() != null) {
                    t.setName(task.getName());
                }
                if (task.getDescryption() != null) {
                    t.setDescryption(task.getDescryption());
                }
                if (task.getStart_date() != null) {
                    t.setStart_date(task.getStart_date());
                }
                if (task.getEnd_date() != null) {
                    t.setEnd_date(task.getEnd_date());
                }
                this.taskDao.save(t);
                return new ResponseEntity(HttpStatus.OK);
            }
            else  return new ResponseEntity(HttpStatus.BAD_REQUEST);

     }



}
