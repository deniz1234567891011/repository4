package az.developia.az.developia.info;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teachers")

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public Integer getAge() {
		return age;
	}
	public Long getCourseId() {
		return courseId;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@NotBlank(message = "Заполни")
    private String name;
@NotBlank(message = "Заполни")
    private String surname;
@Min(value = 1,message = "min age not equal to it")
@Max(value = 35,message = "max age not equal to it")
@NotNull(message = "not null")
    private Integer age;
    private Long courseId;
    
    

}

