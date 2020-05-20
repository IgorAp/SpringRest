package employee.springrest;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(final Long id) {
      super("Could not find employee " + id);
    }
  }