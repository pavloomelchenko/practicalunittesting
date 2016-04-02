package com.mycompany.put.bookingrevisited;

import java.util.Objects;

class Two<K1, K2> {

	K1 k1;
	K2 k2;

	public Two(K1 k1, K2 k2) {
		super();
		this.k1 = k1;
		this.k2 = k2;
	}

	public K1 getK1() {
		return k1;
	}

	public void setK1(K1 k1) {
		this.k1 = k1;
	}

	public K2 getK2() {
		return k2;
	}

	public void setK2(K2 k2) {
		this.k2 = k2;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Two<K1, K2> other = (Two<K1, K2>) obj;
		return this.k1.equals(other.k1) && this.k2.equals(other.k2);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.k1, this.k2);
	}

	@Override
	public String toString() {
		return "Two [k1=" + k1 + ", k2=" + k2 + "]";
	}

}