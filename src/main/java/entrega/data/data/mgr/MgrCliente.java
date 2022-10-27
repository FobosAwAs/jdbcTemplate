package entrega.data.data.mgr;

import entrega.data.data.dto.DTOcliente;

public interface MgrCliente {

    void save(DTOcliente t);

    void delete(DTOcliente t);
}
