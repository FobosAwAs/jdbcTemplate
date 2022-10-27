package entrega.data.data.mapper;

import entrega.data.data.dto.DTOorden;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperOrden implements RowMapper<DTOorden> {
    @Override
    public DTOorden mapRow(ResultSet rs, int rowNum) throws SQLException {
        DTOorden ram = new DTOorden();
        ram.setId_orden(rs.getDouble("ORD_NUM"));
        ram.setCantidad(rs.getDouble("ORD_AMOUNT"));
        ram.setAgente(rs.getInt("CUST_CODE"));
        ram.setCliente(rs.getInt("AGENT_CODE"));
        return ram;
    }
}
