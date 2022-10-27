package entrega.data.data.mgr;


import entrega.data.data.dao.DAOAgente;
import entrega.data.data.dto.DTOagente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
@Service
public class MgrAgenteImple implements MgrAgente {

    DAOAgente daoAgente;

    public MgrAgenteImple(DAOAgente daoAgente) {
        this.daoAgente = daoAgente;
    }

    @Override
    public void save(DTOagente t) {


        DTOagente awas = daoAgente.get(t);

        if (awas == null) {
            try {
                daoAgente.insert(t);

            } catch (SQLException ex) {

            }
        } else {
            daoAgente.update(t);
        }

    }

    @Override
    public void delete(DTOagente t) {


        DTOagente awas = daoAgente.get(t);
        try {
            if (awas == null) {
                System.out.println("el agente no existe");
            } else {
                daoAgente.eliminar(t);

            }
        } catch (Exception e) {

        }


    }

    @Override
    public List<DTOagente> listado() {
        try {
            return daoAgente.listado();
        } catch (Exception e) {

        }
        return null;
    }

}