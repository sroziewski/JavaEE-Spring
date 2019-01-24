package lab.librari.dao.impl.jdbc;


import lab.librari.model.Publisher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherMapper implements RowMapper<Publisher> {

    @Override
    public Publisher mapRow(ResultSet rs, int i) throws SQLException {
        Publisher r = new Publisher();
        r.setId(rs.getLong("publisher_id"));
        r.setName(rs.getString("publisher_name"));
        r.setLogoImage(rs.getString("publisher_logo"));
        return r;
    }
}
