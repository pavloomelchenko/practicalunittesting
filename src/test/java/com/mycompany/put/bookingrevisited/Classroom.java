package com.mycompany.put.bookingrevisited;

public class Classroom {
	long id;

	public Classroom(long id) {
		super();
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o){
		Classroom classroom = (Classroom) o;
		return this.id == classroom.id;
		
	}
}
