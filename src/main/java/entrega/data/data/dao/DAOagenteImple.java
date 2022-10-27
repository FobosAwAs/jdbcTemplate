package entrega.data.data.dao;

import entrega.data.data.dto.DTOagente;
import entrega.data.data.mapper.MapperAgentes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAOagenteImple implements DAOAgente {


    private JdbcTemplate jdbcTemplate;

    public DAOagenteImple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(DTOagente t) throws SQLException {

        String insert = "insert into AGENTS (AGENT_CODE,AGENT_NAME,WORKING_AREA,PHONE_NO,COUNTRY) values (?,?,?,?,?)";
        jdbcTemplate.update(insert,
                t.getId_agente(),
                t.getName_agente(),
                t.getArea_trabajo(),
                t.getTelefono(),
                t.getPais());
    }

    @Override
    public void update(DTOagente t) {
        try {
            String update = "update AGENTS set AGENT_NAME= ?, WORKING_AREA = ? ,PHONE_NO = ? ,COUNTRY = ? where AGENT_CODE = ?";
            jdbcTemplate.update(update,
                    t.getName_agente(),
                    t.getArea_trabajo(),
                    t.getTelefono(),
                    t.getPais(),
                    t.getId_agente()
            );

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void eliminar(DTOagente t) {
        try {
            String delete = "delete from AGENTS where AGENT_CODE = ?";
            jdbcTemplate.update(delete,
                    t.getId_agente()
            );

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public DTOagente get(DTOagente t) {
        String select = "select * from AGENTS where AGENT_CODE = ?";
        try {
            return jdbcTemplate.queryForObject(select, new MapperAgentes(), t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTOagente> listado() {
        List<DTOagente> lista = null;
        String SELECTBYID = "select * from AGENTS";
        try {
            lista = jdbcTemplate.query(SELECTBYID, new MapperAgentes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
