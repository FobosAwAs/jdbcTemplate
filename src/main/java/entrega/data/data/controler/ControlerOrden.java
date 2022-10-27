package entrega.data.data.controler;

import entrega.data.data.dto.DTOcliente;
import entrega.data.data.dto.DTOorden;
import entrega.data.data.dto.DTOrespuesta;
import entrega.data.data.mgr.MgrOrdenImple;
import entrega.data.data.mgr.MgrOrden;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "/orden")
public class ControlerOrden {

    private MgrOrden mgrOrden;

    public ControlerOrden(MgrOrden mgrOrden) {
        this.mgrOrden = mgrOrden;
    }

    @PostMapping(path = "/save")
    void save(@RequestBody DTOorden orden) {
        try {
            mgrOrden.save(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam("id") int id) {
        DTOorden orden = new DTOorden();
        orden.setId_orden(id);

        try {
            mgrOrden.delete(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOorden orden) {
        try {
            mgrOrden.save(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/lista")
    public DTOrespuesta lista(){
        DTOrespuesta respuesta = new DTOrespuesta();
        try {
            List<DTOorden> lista = mgrOrden.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (Exception e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }

}
