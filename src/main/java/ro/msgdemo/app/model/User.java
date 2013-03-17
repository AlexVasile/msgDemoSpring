package ro.msgdemo.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="USERS")
public class User {

	private int id;
	private String name;
	private String pass;
	private List<Message> megs;
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="user_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column (name="username", nullable = false, length = 30, unique=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column (name="password")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@OneToMany (mappedBy="user")
	public List<Message> getMegs() {
		return megs;
	}
	public void setMegs(List<Message> megs) {
		this.megs = megs;
	}
	
}
