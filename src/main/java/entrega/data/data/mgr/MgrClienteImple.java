package entrega.data.data.mgr;


import entrega.data.data.dao.DAOCliente;
import entrega.data.data.dao.DAOClienteImple;
import entrega.data.data.dto.DTOagente;
import entrega.data.data.dto.DTOcliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Service
public class MgrClienteImple implements MgrCliente {

    DAOCliente daoCliente;

    public MgrClienteImple(DAOClienteImple daoCliente){
        this.daoCliente = daoCliente;
    }
    @Override
    public void save(DTOcliente t) {
        DTOcliente awas = daoCliente.get(t);
        if (awas == null) {
            try {
                daoCliente.insert(t);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            daoCliente.update(t);
        }
    }

    @Override
    public void delete(DTOcliente t) {
        DTOcliente awas = daoCliente.get(t);
        try {
            if (awas == null) {
                System.out.println("el agente no existe");
            } else {
                daoCliente.eliminar(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DTOcliente> listado() {

        try {
            return daoCliente.listado();
        } catch (Exception e) {

        } finally {

        }
        return null;
    }

}
