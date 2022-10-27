package entrega.data.data.dao;

import entrega.data.data.dto.DTOorden;
import entrega.data.data.mapper.MapperOrden;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository

public class DAOOrdenImple implements DAOOrden {

    private JdbcTemplate jdbcTemplate;

    public DAOOrdenImple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(DTOorden t) throws SQLException {

        String insert = "insert into ORDERS (ORD_NUM,ORD_AMOUNT,CUST_CODE,AGENT_CODE) values (?,?,?,?)";
        jdbcTemplate.update(insert,
                t.getId_orden(),
                t.getCantidad(),
                t.getCliente(),
                t.getAgente());
    }

    @Override
    public void update(DTOorden t) {
        try {
            String update = "update ORDERS set (ORD_AMOUNT,CUST_CODE,AGENT_CODE) values (?,?,?) where ORD_NUM = ?";
            jdbcTemplate.update(update,
                    t.getCantidad(),
                    t.getCliente(),
                    t.getAgente(),
                    t.getId_orden());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(DTOorden t) {
        try {
            String delete = "delete from ORDERS where ORD_NUM = ?";
            jdbcTemplate.update(delete,
                    t.getId_orden());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public DTOorden get(DTOorden t) {
        String select = "select * from ORDERS where ORD_NUM = ?";
        try {
            return jdbcTemplate.queryForObject(select, new MapperOrden(), t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DTOorden> listado() {
        List<DTOorden> lista = null;
        String SELECTBYID = "select * from ORDERS";
        try {
            lista = jdbcTemplate.query(SELECTBYID, new MapperOrden());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
