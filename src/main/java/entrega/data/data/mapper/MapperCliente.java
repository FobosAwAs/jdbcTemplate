package entrega.data.data.mapper;

import entrega.data.data.dto.DTOcliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperCliente implements RowMapper<DTOcliente> {
    @Override
    public DTOcliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        DTOcliente ram = new DTOcliente();
        ram.setCode_cliente(rs.getInt("CUST_CODE"));
        ram.setName_cliente(rs.getString("CUST_NAME"));
        ram.setCiudad(rs.getString("CUST_CITY"));
        return ram;
    }
}
