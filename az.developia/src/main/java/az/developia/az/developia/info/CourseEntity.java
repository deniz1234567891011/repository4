package az.developia.az.developia.info;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@NotBlank(message = "zapolni")
    private String name;
@NotBlank(message = "zapolni")
    private String description;
@Min(value = 1 ,message = "malo")
@Max(value = 111,message = "mnogo")
    private int durationInWeeks;

}
