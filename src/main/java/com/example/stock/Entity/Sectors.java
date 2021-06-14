package com.example.stock.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sectors {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false, unique = true)
	private String sectorName;
	
	@Column(nullable = false)
	private String brief;
	
	@OneToOne(mappedBy = "sector", fetch=FetchType.LAZY)
    private Company company;

	public int getId() {
		return id;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@JsonManagedReference
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Sectors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sectors(String sectorName, String brief) {
		super();
		this.sectorName = sectorName;
		this.brief = brief;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", sectorName=" + sectorName + ", brief=" + brief + "]";
	}

}
