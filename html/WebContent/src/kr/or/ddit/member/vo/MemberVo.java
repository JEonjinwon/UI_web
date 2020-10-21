package kr.or.ddit.member.vo;

public class MemberVo {
	
	private int seq;
	private String id;
	private String name;
	private int age;
	private String birthday;
	private String addr;
	private String tel;
	private String gender;
	
	public MemberVo() {
	}
	
	public MemberVo(int seq, String id, String name, int age, String birthday, String addr, String tel, String gender) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.addr = addr;
		this.tel = tel;
		this.gender = gender;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
