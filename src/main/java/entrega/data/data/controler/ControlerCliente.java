package entrega.data.data.controler;

import entrega.data.data.dto.DTOagente;
import entrega.data.data.dto.DTOcliente;
import entrega.data.data.dto.DTOrespuesta;
import entrega.data.data.mgr.MgrClienteImple;
import entrega.data.data.mgr.MgrCliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "/cliente")
public class ControlerCliente {
    private MgrCliente mgrCliente;

    public ControlerCliente(MgrCliente mgrCliente){
        this.mgrCliente = mgrCliente;
    }

    @PostMapping(path = "/save")
    void save(@RequestBody DTOcliente cliente) {
        try {
            mgrCliente.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam("id") int  id) {
        DTOcliente cliente = new DTOcliente();
        cliente.setCode_cliente(id);
        try {
            mgrCliente.delete(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOcliente cliente) {
        try {
            mgrCliente.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/lista")
    public DTOrespuesta lista(){

        DTOrespuesta respuesta = new DTOrespuesta();
        try {
            List<DTOcliente> lista = mgrCliente.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (Exception e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }

}
