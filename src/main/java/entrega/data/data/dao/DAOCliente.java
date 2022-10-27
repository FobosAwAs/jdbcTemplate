package entrega.data.data.dao;

import entrega.data.data.dto.DTOagente;
import entrega.data.data.dto.DTOcliente;

import java.sql.SQLException;
import java.util.List;

public interface DAOCliente {

    DTOcliente get(DTOcliente t);

    void insert(DTOcliente t)throws SQLException;

    void update(DTOcliente t);

    void eliminar(DTOcliente t);

    public List<DTOcliente> listado();
}
