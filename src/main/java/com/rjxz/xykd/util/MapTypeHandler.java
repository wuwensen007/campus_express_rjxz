package com.rjxz.xykd.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MapTypeHandler extends BaseTypeHandler<HashMap> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, HashMap hashMap, JdbcType jdbcType) throws SQLException {
        try {
            preparedStatement.setString(i, objectMapper.writeValueAsString(hashMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap getNullableResult(ResultSet resultSet, String s) throws SQLException {
        try {
            return objectMapper.readValue(resultSet.getString(s), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap getNullableResult(ResultSet resultSet, int i) throws SQLException {
        try {
            return objectMapper.readValue(resultSet.getString(i), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        try {
            return objectMapper.readValue(callableStatement.getString(i), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
