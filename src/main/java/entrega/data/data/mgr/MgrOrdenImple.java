package entrega.data.data.mgr;

import bd.ManagerConexion;
import entrega.data.data.dao.DAOOrden;
import entrega.data.data.dao.DAOOrdenImple;
import entrega.data.data.dto.DTOorden;

import java.sql.SQLException;

public class MgrOrdenImple implements MgrOrden {

    DAOOrden agentevar = new DAOOrdenImple();

    @Override
    public void save(DTOorden t) {

        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();


        DTOorden awas = agentevar.get(t);

        if (awas == null) {
            try {
                agentevar.insert(t);
                managerConexion.commit();
            } catch (SQLException ex) {
                managerConexion.rollback();
            }
        } else {
            agentevar.update(t);
            managerConexion.commit();
        }
        managerConexion.close();
    }

    @Override
    public void delete(DTOorden t) {
        ManagerConexion managerConexion = ManagerConexion.getIntance();
        managerConexion.reconectar();

        DTOorden awas = agentevar.get(t);
        try {
            if (awas == null) {
                System.out.println("el agente no existe");
            } else {
                agentevar.eliminar(t);
                managerConexion.commit();
            }
        } catch (Exception e) {
            managerConexion.rollback();
        }
        managerConexion.close();

    }

}
