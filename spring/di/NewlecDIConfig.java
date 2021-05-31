package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

@ComponentScan("spring.di.ui")
@Configuration
public class NewlecDIConfig {
	//여기서 함수명 exam은 spring bean에서 사용하는 name으로 생각해야 한다.
	@Bean
	public Exam exam() {
		return new NewlecExam();
	}//exam
}//class
