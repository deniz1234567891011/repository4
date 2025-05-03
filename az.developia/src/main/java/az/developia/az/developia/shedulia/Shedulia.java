package az.developia.az.developia.shedulia;

import java.time.LocalDate;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Shedulia {
@Scheduled(fixedDelay = 1000)
public void printDate() {
	LocalDate date = LocalDate.now();
System.out.println("date" + date);
}
}