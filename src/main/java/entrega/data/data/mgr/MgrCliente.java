package entrega.data.data.mgr;

import entrega.data.data.dto.DTOagente;
import entrega.data.data.dto.DTOcliente;

import java.util.List;

public interface MgrCliente {

    void save(DTOcliente t);

    void delete(DTOcliente t);

    public List<DTOcliente> listado() ;
}
