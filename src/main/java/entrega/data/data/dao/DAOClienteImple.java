package entrega.data.data.dao;

import entrega.data.data.dto.DTOagente;
import entrega.data.data.dto.DTOcliente;
import entrega.data.data.mapper.MapperAgentes;
import entrega.data.data.mapper.MapperCliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAOClienteImple implements DAOCliente {

    private JdbcTemplate jdbcTemplate;

    public DAOClienteImple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void insert(DTOcliente t) throws SQLException {
        String insert = "insert into CUSTOMER (CUST_CODE,CUST_NAME,CUST_CITY) values (?,?,?)";
        jdbcTemplate.update(insert,
                t.getCode_cliente(),
                t.getName_cliente(),
                t.getCiudad());
    }

    @Override
    public void update(DTOcliente t) {
        try {
            String update = "update CUSTOMER set CUST_NAME = ?, CUST_CITY = ? where CUST_CODE = ?";
            jdbcTemplate.update(update,
                    t.getName_cliente(),
                    t.getCiudad(),
                    t.getCode_cliente());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(DTOcliente t) {
        try {
            String delete = "delete from CUSTOMER where CUST_CODE = ?";
            jdbcTemplate.update(delete,
                    t.getCode_cliente());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public DTOcliente get(DTOcliente t) {
        String select = "select * from CUSTOMER where CUST_CODE = ?";
        try {
            return jdbcTemplate.queryForObject(select, new MapperCliente(), t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTOcliente> listado() {
        List<DTOcliente> lista = null;
        String SELECTBYID = "select * from CUSTOMER";
        try {
            lista = jdbcTemplate.query(SELECTBYID, new MapperCliente());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}