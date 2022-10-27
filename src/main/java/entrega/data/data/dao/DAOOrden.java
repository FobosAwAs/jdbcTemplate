package entrega.data.data.dao;

import entrega.data.data.dto.DTOcliente;
import entrega.data.data.dto.DTOorden;

import java.sql.SQLException;
import java.util.List;

public interface DAOOrden {

    DTOorden get(DTOorden t);

    void insert(DTOorden t)throws SQLException;

    void update(DTOorden t);

    void eliminar(DTOorden t);

    public List<DTOorden> listado();
}
