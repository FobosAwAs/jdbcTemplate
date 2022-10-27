package entrega.data.data.mgr;

import entrega.data.data.dto.DTOagente;

import java.util.List;

public interface MgrAgente {

    void save(DTOagente t);

    void delete(DTOagente t);
    public List<DTOagente> listado() ;
}
