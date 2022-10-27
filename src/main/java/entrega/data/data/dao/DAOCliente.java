package entrega.data.data.dao;

import entrega.data.data.dto.DTOcliente;

import java.sql.SQLException;

public interface DAOCliente {

    DTOcliente get(DTOcliente t);

    void insert(DTOcliente t)throws SQLException;

    void update(DTOcliente t);

    void eliminar(DTOcliente t);
}
