package entrega.data.data.mgr;

import entrega.data.data.dto.DTOorden;

public interface MgrOrden {

    void save(DTOorden t);

    void delete(DTOorden t);
}
