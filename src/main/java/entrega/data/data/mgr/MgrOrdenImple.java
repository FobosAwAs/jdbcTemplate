package entrega.data.data.mgr;

import entrega.data.data.dao.DAOOrden;
import entrega.data.data.dto.DTOorden;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
@Service
public class MgrOrdenImple implements MgrOrden {

    DAOOrden daoOrden;

    public MgrOrdenImple(DAOOrden daoOrden) {
        this.daoOrden = daoOrden;
    }

    @Override
    public void save(DTOorden t) {


        DTOorden awas = daoOrden.get(t);

        if (awas == null) {
            try {
                daoOrden.insert(t);
            } catch (SQLException ex) {
            }
        } else {
            daoOrden.update(t);
        }
    }

    @Override
    public void delete(DTOorden t) {
        DTOorden awas = daoOrden.get(t);
        try {
            if (awas == null) {
                System.out.println("el agente no existe");
            } else {
                daoOrden.eliminar(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DTOorden> listado() {
        try {
            return daoOrden.listado();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

