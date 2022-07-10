package com.demo.dao.hibernate.types;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import com.demo.util.Util;

public class CommunityType  extends ImmutableValueUserType {
	public Class returnedClass() {
		return String[].class;
	}

	public int[] sqlTypes() {
		return new int[]{
						Types.VARCHAR
				};
	}
	
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
	throws HibernateException, SQLException {
			String $names = rs.getString(names[0]);	
			return $names.split(",");
	}
	
	public void nullSafeSet(PreparedStatement ps, Object value, int index)
	throws HibernateException, SQLException {
		if (value == null) {
			ps.setNull(index, Types.VARCHAR);
		} else {
			String[] strings = (String[])value;
			ps.setString(index, Util.getCommunities(strings) );
		}
	}


	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		String $names = rs.getString(names[0]);	
		return $names.split(",");
	}

	@Override
	public void nullSafeSet(PreparedStatement ps, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			ps.setNull(index, Types.VARCHAR);
		} else {
			String[] strings = (String[])value;
			ps.setString(index, Util.getCommunities(strings) );
		}
	}
}
