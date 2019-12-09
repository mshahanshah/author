package info.ali.auther;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;

public class ShutDownController implements ApplicationContextAware {

	private ApplicationContext context;

	@PostMapping("/shutdown")
	public void shutDown() {
		((ConfigurableApplicationContext) context).close();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}