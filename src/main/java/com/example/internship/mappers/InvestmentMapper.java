package com.example.internship.mappers;

import com.example.internship.domain.Investment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestmentMapper implements RowMapper<Investment> {
    @Override
    public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Investment investment = new Investment();
        investment.setId(rs.getInt("id"));
        investment.setDate(rs.getDate("date"));
        investment.setValue(rs.getDouble("value"));

        return investment;
    }
}
