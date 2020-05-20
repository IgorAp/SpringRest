package employee.springrest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data //Essa anotation posibilita a a criação dos getters, seterrs para os atributos
@Entity //Informa ao JPA que essa classe deve ser mapeada
public class Employee {
    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    Employee() {}

    Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}