package com.zhzt.teamwork.repository;

import com.zhzt.teamwork.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    Project findProjectById(Long id);
}
