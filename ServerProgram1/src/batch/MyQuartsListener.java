package batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.SchedulerException;

@WebListener
public class MyQuartsListener implements ServletContextListener {
    
	CronTriggerCreate trigger;
		
	@Override
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	try {
    		trigger.scheduler.clear();
    		trigger.scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
    }
	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("배치 프로그램이 시작되었습니다.");
    	trigger = new CronTriggerCreate("0 0 12 ? * MON-FRI *", MyQuartz.class);
    	trigger.executeTrigger();
    }
	
}