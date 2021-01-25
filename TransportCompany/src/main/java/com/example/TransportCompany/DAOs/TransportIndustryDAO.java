package com.example.TransportCompany.DAOs;

import com.example.TransportCompany.Models.TransportCompany;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class TransportIndustryDAO
{
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public TransportIndustryDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
  {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  //@formatter:off
  public void insertNewCompany(String name,String email)
  {
    MapSqlParameterSource source = new MapSqlParameterSource()
        .addValue("name", name)
        .addValue("email",email);

    String sql = "INSERT INTO WORLD_OF_TRANSPORTS(COMPANY_NAME,EMAIL)  "
               + "VALUES(:name,:email)                                 "
        ;

    namedParameterJdbcTemplate.update(sql,source);
  }

  public List<TransportCompany> getCompanyInfoByMail(String email)
  {
    MapSqlParameterSource source = new MapSqlParameterSource()
        .addValue("email",email);

        String sql = "SELECT COMPANY_NAME FROM WORLD_OF_TRANSPORTS WHERE EMAIL = :email";

    return namedParameterJdbcTemplate.query(sql, source, (ResultSet rs, int rowNum) -> {
      TransportCompany p1 = new TransportCompany();
      p1.setCompanyName(rs.getString("COMPANY_NAME"));
     // p1.setEmail(rs.getString("email"));
      return p1;
    });
  }

}
