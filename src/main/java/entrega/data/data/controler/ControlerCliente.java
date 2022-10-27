package entrega.data.data.controler;

import entrega.data.data.dto.DTOcliente;
import entrega.data.data.mgr.MgrClienteImple;
import entrega.data.data.mgr.MgrCliente;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "/cliente")
public class ControlerCliente {
    @PostMapping(path = "/save")
    void save(@RequestBody DTOcliente cliente) {
        MgrCliente manager = new MgrClienteImple();
        try {
            manager.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam("id") int  id) {
        DTOcliente cliente = new DTOcliente();
        cliente.setCode_cliente(id);
        MgrCliente manager = new MgrClienteImple();
        try {
            manager.delete(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOcliente cliente) {
        MgrCliente manager = new MgrClienteImple();
        try {
            manager.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
