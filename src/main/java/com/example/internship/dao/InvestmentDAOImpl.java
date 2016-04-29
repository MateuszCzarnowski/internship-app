package com.example.internship.dao;

import com.example.internship.domain.Investment;
import com.example.internship.mappers.InvestmentMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InvestmentDAOImpl implements InvestmentDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Investment> getInvestmentsByDate(String date1, String date2) {
        String sql = "SELECT * FROM investment WHERE date >= \'" + date1 + "\' AND date <= \'"+ date2 + "\'";
        List<Investment> investments = jdbcTemplate.query(sql, new InvestmentMapper());

        return investments;

    }


}
