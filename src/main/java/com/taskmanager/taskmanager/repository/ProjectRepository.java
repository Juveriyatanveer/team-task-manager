
package com.taskmanager.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.taskmanager.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}