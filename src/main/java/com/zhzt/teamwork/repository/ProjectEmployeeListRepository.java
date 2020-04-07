package com.zhzt.teamwork.repository;

import com.zhzt.teamwork.model.ProjectEmployeeList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProjectEmployeeListRepository extends PagingAndSortingRepository<ProjectEmployeeList, Long> {
     Iterable<ProjectEmployeeList> findProjectEmployeeListsByProjectId(Long prjId);
}
