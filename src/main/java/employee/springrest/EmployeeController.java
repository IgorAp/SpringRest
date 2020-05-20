package employee.springrest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @GetMapping("/employees")
    List<Employee> all() {
        return this.repository.findAll();
    }

    @PostMapping("/employees")
    Employee create(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @DeleteMapping("employees/{id}")
    void delete(@PathVariable Long id) {
        try {
            repository.deleteById(id);
        } catch (EmployeeNotFoundException e) {
            throw e;
        }
    }
    @PutMapping("employees/{id}")
    Employee update(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repository.save(employee);
        })
        .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}