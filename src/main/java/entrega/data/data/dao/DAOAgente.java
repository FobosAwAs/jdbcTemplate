package entrega.data.data.dao;

import entrega.data.data.dto.DTOagente;

import java.sql.SQLException;
import java.util.List;

public interface DAOAgente {

    DTOagente get(DTOagente dtOagente);

    void insert(DTOagente dtOagente)throws SQLException;

    void update(DTOagente dtOagente);

    void eliminar(DTOagente dtOagente);

    public List<DTOagente> listado();
}
