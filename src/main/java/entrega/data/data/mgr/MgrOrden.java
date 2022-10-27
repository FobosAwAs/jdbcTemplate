package entrega.data.data.mgr;

import entrega.data.data.dto.DTOagente;
import entrega.data.data.dto.DTOorden;

import java.util.List;

public interface MgrOrden {

    void save(DTOorden t);

    void delete(DTOorden t);

    public List<DTOorden> listado() ;
}
