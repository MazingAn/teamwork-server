package com.zhzt.teamwork.Controller;

import com.zhzt.teamwork.error.QueryNotFoundException;
import com.zhzt.teamwork.model.Employee;
import com.zhzt.teamwork.model.Project;
import com.zhzt.teamwork.model.ProjectEmployeeList;
import com.zhzt.teamwork.repository.EmployeeRepository;
import com.zhzt.teamwork.repository.ProjectEmployeeListRepository;
import com.zhzt.teamwork.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectEmployeeListRepository projectEmployeeListRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    Page<Project> getProject(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return projectRepository.findAll(pageable);
    }

    /** get one project by id */
    @GetMapping(path = "/{id}")
    Project getOne(@PathVariable @Min(1) Long id){
        return projectRepository.findById(id).orElseThrow(()->new QueryNotFoundException(id));
    }

    /** save a new project */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Project addOne(@Valid @RequestBody Project project){
        return projectRepository.save(project);
    }

    /** find members by projectId */
    @GetMapping(path = "member/{pid}")
    List<Employee> getMembers(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @PathVariable long pid){
        List<Employee> employees = new ArrayList<>();
        Iterable<ProjectEmployeeList> tmpList =  projectEmployeeListRepository.findProjectEmployeeListsByProjectId(pid);
        for(ProjectEmployeeList pel : tmpList){
             System.out.println(pel.getEmployeeId());
             Employee employee = employeeRepository.findEmployeeById(pel.getEmployeeId());
             employees.add(employee);
        }
        return employees;
    }

    /** add member */
    @PostMapping(path = "member/{pid}/{eid}")
    String addOneMember(@PathVariable long pid, @PathVariable long eid){
        ProjectEmployeeList projectEmployeeList = new ProjectEmployeeList();
        projectEmployeeList.setProjectId(pid);
        projectEmployeeList.setEmployeeId(eid);
        projectEmployeeListRepository.save(projectEmployeeList);
        return "success";
    }
}
