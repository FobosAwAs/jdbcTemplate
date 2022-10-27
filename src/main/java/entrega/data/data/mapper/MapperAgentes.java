package entrega.data.data.mapper;

import entrega.data.data.dto.DTOagente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperAgentes implements RowMapper<DTOagente> {

    @Override
    public DTOagente mapRow(ResultSet rs, int rowNum) throws SQLException {
        DTOagente cl = new DTOagente();
        cl.setId_agente(rs.getInt("AGENT_CODE"));
        cl.setName_agente(rs.getString("AGENT_NAME"));
        cl.setArea_trabajo(rs.getString("WORKING_AREA"));
        cl.setTelefono(rs.getString("PHONE_NO"));
        cl.setPais(rs.getString("COUNTRY"));
        return cl;
    }
}
