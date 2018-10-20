package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("phonesDao")
public class PhonesDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	// List of all phones in DB
	public List<Phone> getAllPhones() {
		return jdbc.query("SELECT * FROM phone", new RowMapper<Phone>() {

			public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
				Phone phone = new Phone();
				phone.setId(rs.getInt("id"));
				phone.setBrand(rs.getString("brand"));
				phone.setModel(rs.getString("model"));
				phone.setProcessor(rs.getString("processor"));
				phone.setMemory(rs.getString("memory"));
				return phone;
			}
		});
	}

	// Get Phone by id
	public Phone getPhoneById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.queryForObject("SELECT * FROM phone WHERE id = :id", params, new RowMapper<Phone>() {
			public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
				Phone phone = new Phone();
				phone.setId(rs.getInt("id"));
				phone.setBrand(rs.getString("brand"));
				phone.setModel(rs.getString("model"));
				phone.setProcessor(rs.getString("processor"));
				phone.setMemory(rs.getString("memory"));
				return phone;
			}
		});
	}
	
	//Insert phone into DB
	public boolean insert(Phone phone) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(phone);
		return jdbc.update("INSERT INTO phone (id, brand, model, processor, memory) values (:id, :brand, :model, :processor, :memory)", params) == 1;
	}
	
	//Update phone
	public boolean update(Phone phone) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(phone);
		return jdbc.update("UPDATE phone SET brand = :brand, model = :model, processor = :processor, memory = :memory WHERE id = :id", params) == 1;
	}
	
	//Delete phone from DB
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("DELETE FROM phone WHERE id =:id", params) == 1;
	}
}
