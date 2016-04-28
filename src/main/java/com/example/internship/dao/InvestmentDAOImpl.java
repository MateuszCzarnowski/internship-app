package com.example.internship.dao;

import com.example.internship.domain.Investment;
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
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Investment getInvestment(int id) {
        String sql = "SELECT * FROM investment WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Investment>() {

            @Override
            public Investment extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Investment investment = new Investment();
                    investment.setId(rs.getInt("id"));
                    investment.setDate(rs.getDate("date"));
                    investment.setValue(rs.getDouble("value"));
                    return investment;
                }

                return null;
            }

        });
    }

    @Override
    public List<Investment> getAllInvestments() {
        String sql = "SELECT * FROM investment";
        List<Investment> investments = jdbcTemplate.query(sql, new RowMapper<Investment>() {

            @Override
            public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
                Investment investment = new Investment();
                investment.setId(rs.getInt("id"));
                investment.setDate(rs.getDate("date"));
                investment.setValue(rs.getDouble("value"));

                return investment;
            }

        });

        return investments;
    }

    @Override
    public List<Investment> getInvestmentsByDate(String date1, String date2) {
        String sql = "SELECT * FROM investment WHERE date >= \'" + date1 + "\' AND date < \'"+ date2 + "\'";
        List<Investment> investments = jdbcTemplate.query(sql, new RowMapper<Investment>() {

            @Override
            public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
                Investment investment = new Investment();
                investment.setId(rs.getInt("id"));
                investment.setDate(rs.getDate("date"));
                investment.setValue(rs.getDouble("value"));

                return investment;
            }

        });

        return investments;
    }


}
