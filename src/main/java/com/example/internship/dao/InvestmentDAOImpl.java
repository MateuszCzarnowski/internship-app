package com.example.internship.dao;

import com.example.internship.domain.Investment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                    investment.setInvestmentId(rs.getInt("id"));
                    investment.setInvestmentDate(rs.getDate("date"));
                    investment.setInvestmentValue(rs.getDouble("value"));
                    return investment;
                }

                return null;
            }

        });
    }


}
