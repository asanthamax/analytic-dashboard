package thilina.spring.dao;

import java.util.List;

import thilina.spring.bean.Applicant;

public interface ApplicantDao {

	public void create(Applicant customer);

	public void update(Applicant customer);

	public boolean deleteById(String Id);

	public Applicant findById(String Id);

	public List<Applicant> getAllCustomers();
	
	public boolean logAuthenticate(String userName,String password);
}
