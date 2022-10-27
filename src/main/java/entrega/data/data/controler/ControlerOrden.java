package entrega.data.data.controler;

import entrega.data.data.dto.DTOorden;
import entrega.data.data.mgr.MgrOrdenImple;
import entrega.data.data.mgr.MgrOrden;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "/orden")
public class ControlerOrden {
    @PostMapping(path = "/save")
    void save(@RequestBody DTOorden orden) {
        MgrOrden manager = new MgrOrdenImple();
        try {
            manager.save(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam("id") int  id) {
        DTOorden orden = new DTOorden();
        orden.setId_orden(id);
        MgrOrden manager = new MgrOrdenImple();
        try {
            manager.delete(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOorden orden) {
        MgrOrden manager = new MgrOrdenImple();
        try {
            manager.save(orden);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
