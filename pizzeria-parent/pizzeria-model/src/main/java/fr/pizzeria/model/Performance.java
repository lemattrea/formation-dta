package fr.pizzeria.model;

import java.time.LocalDateTime;
import java.util.Comparator;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

@Entity
public class Performance implements Comparable<Performance>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String service;
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime date;
	private Integer tempsExecution; 

	
	/**
	 * 
	 */
	public Performance() {
		super();
	}

	/**
	 * @param id
	 * @param service
	 * @param date
	 * @param tempsExecution
	 */
	public Performance(Integer id, String service, LocalDateTime date, Integer tempsExecution) {
		super();
		this.id = id;
		this.service = service;
		this.date = date;
		this.tempsExecution = tempsExecution;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(Integer tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Performance other = (Performance) obj;
		
		return new EqualsBuilder()
                 .append(id, other.id)
                 .isEquals();
		
	}
	
	@Override
	public int compareTo(Performance o) {
		return Comparator.comparing(Performance::getId).thenComparing(Performance::getId).compare(this, o);
	}
	
}
