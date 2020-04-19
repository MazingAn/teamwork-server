package com.zhzt.teamwork.Controller;

import com.zhzt.teamwork.error.QueryNotFoundException;
import com.zhzt.teamwork.model.Employee;
import com.zhzt.teamwork.model.Project;
import com.zhzt.teamwork.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    Page<Employee> getEmployees(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
    }

    @GetMapping("/all")
    Iterable<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    /** get one project by id
     * @return*/
    @GetMapping(path = "/{id}")
    Employee getOne(@PathVariable @Min(1) Long id){
        return employeeRepository.findById(id).orElseThrow(()->new QueryNotFoundException(id));
    }

    /** save a new project */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Employee addOne(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

}
