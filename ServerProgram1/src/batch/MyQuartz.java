package batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.MemberDAO;


public class MyQuartz implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		int count = MemberDAO.getInstance().updatePoint();
		System.out.println("회원 포인트 증가 완료: " + count + "건");
		
	}
	
}