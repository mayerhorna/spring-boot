package com.demo.dao.hibernate.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public abstract class ImmutableValueUserType implements UserType {

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		if(x == y){
			return true;
		} 
		return x.equals(y);
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	public abstract Class returnedClass();

	public abstract int[] sqlTypes();

	public abstract Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException,
			SQLException;

	public abstract void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException,
			SQLException;

}
