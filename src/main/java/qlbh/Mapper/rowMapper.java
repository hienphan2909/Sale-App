package qlbh.Mapper;

import java.sql.ResultSet;

public interface rowMapper<T> {
	T ProductMapper(ResultSet resultSet);
}
