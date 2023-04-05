package learn.automation.online.complex.pojo;

import java.util.List;
import lombok.Data;

//@Getter
//@Setter //class level will create getter setter for all variables
//@Data public class Movies -- another way is to use @Data at class declaration line 
@Data public class Movies {

	//@Getter
	//@Setter -- applicable only for particular variable above which is written
	private String title;
	private int year;
	private List<String> cast;
}
