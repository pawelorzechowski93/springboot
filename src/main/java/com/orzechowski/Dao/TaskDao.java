package com.orzechowski.Dao;

import com.orzechowski.Entity.Task;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
/**
 * Created by user on 30.11.2016.
 */
public interface TaskDao extends JpaRepository<Task, Integer> {


}
