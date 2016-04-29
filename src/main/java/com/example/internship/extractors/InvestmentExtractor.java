package com.example.internship.extractors;

import com.example.internship.domain.Investment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestmentExtractor implements ResultSetExtractor<Investment>{

    @Override
    public Investment extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
            Investment investment = new Investment();
            investment.setId(rs.getInt("id"));
            investment.setDate(rs.getDate("date"));
            investment.setValue(rs.getDouble("value"));
            return investment;
        }

        return null;
    }
}
