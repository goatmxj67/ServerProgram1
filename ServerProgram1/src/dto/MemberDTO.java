package dto;

public class MemberDTO {

	private long no;
	private String id;
	private String name;
	private String grade;
	private long point;
	
	public MemberDTO(){}

	public MemberDTO(long no, String id, String name, String grade, long point) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.point = point;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getPoint() {
		return point;
	}

	public void setPoint(long point) {
		this.point = point;
	}
	
}
