package com.example.demospringdata.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "t_evento" )
public class Evento {
	private Long id;
	private String titulo;
	private Date fecha;

	public Evento() {
	}

	public Evento(String titulo, Date fecha) {
		this.titulo = titulo;
		this.fecha = fecha;
	}

	@Id
	@Column(name = "evento_id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
		return id;
    }

    private void setId(Long id) {
		this.id = id;
    }

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "evento_fecha")
    public Date getFecha() {
		return fecha;
    }

    public void setFecha(Date fecha) {
		this.fecha = fecha;
    }
    
    @Column(name = "titulo")
    public String getTitulo() {
		return titulo;
    }

    public void setTitulo(String titulo) {
		this.titulo = titulo;
    }
    
//    @ManyToOne @JoinColumn(name="mother_id", updatable=false)
//    public Cat getMother() { return mother; }
//    public void setMother(Cat mother) { this.mother = mother; }
//    private Cat mother;
//
//    @OneToMany(mappedBy="mother") @OrderBy("litterId")
//    public Set<Cat> getKittens() { return kittens; }
//    public void setKittens(Set<Cat> kittens) { this.kittens 
}
