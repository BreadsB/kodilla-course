package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TaskDao extends CrudRepository<Task, Integer> {

    List<Task> findByDuration(int duration);
}
