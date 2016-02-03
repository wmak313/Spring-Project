package com.benjamin.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offerDao")
public class OffersDao {

	private NamedParameterJdbcTemplate jdbc;

	public OffersDao() {
		System.out.println("Successfully loaded offers DAO");
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers (name, email, text) values (:name,:email,:text)", params)==1;
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("delete from offers where id =:id", params) == 1;

	}
	
	public boolean update(Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set name=:name, email=:email, text=:text where id =:id", params)==1;
	}

	public List<Offer> getOffers() {

		
		return jdbc.query("select * from offers",
				new RowMapper<Offer>() {

					public Offer mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						Offer offer = new Offer();
						offer.setId(rs.getInt("ID"));
						offer.setName(rs.getString("NAME"));
						offer.setEmail(rs.getString("EMAIL"));
						offer.setText(rs.getString("TEXT"));

						return offer;
					}

				});

	}

	

}
