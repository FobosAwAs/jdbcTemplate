package entrega.data.data.dao;

import entrega.data.data.dto.DTOorden;

import java.sql.SQLException;

public interface DAOOrden {

    DTOorden get(DTOorden t);

    void insert(DTOorden t)throws SQLException;

    void update(DTOorden t);

    void eliminar(DTOorden t);
}
