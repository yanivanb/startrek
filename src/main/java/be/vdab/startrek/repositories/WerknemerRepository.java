package be.vdab.startrek.repositories;

import be.vdab.startrek.domain.Werknemer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class WerknemerRepository {
    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;

    public WerknemerRepository(JdbcTemplate template) {
        this.template = template;
        insert = new SimpleJdbcInsert(template).withTableName("werknemers").usingGeneratedKeyColumns("id");
    }

    private final RowMapper<Werknemer> werknemerMapper =
            (result, rowNum) ->
                    new Werknemer(result.getLong("id"), result.getString("voornaam"),
                            result.getString("familienaam"), result.getBigDecimal("budget"), ""+result.getLong("id")+".jpg");

    public List<Werknemer> findAll() {
        var sql = """
        select id, voornaam, familienaam, budget
        from werknemers
        """;
        return template.query(sql, werknemerMapper);
    }
}
