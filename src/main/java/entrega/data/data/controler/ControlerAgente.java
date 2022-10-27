package entrega.data.data.controler;

import entrega.data.data.dto.DTOagente;
import entrega.data.data.dto.DTOrespuesta;
import entrega.data.data.mgr.MgrAgente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/agente")

public class ControlerAgente {

    private MgrAgente mgrAgente ;

    public ControlerAgente(MgrAgente mgrAgente){
         this.mgrAgente = mgrAgente;
    }
    @PostMapping(path = "/save")
    public @ResponseBody
    void save(@RequestBody DTOagente agente) {
        try {
            mgrAgente.save(agente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "/delete")
    void delete(@RequestParam int  id){
    DTOagente dtOagente = new DTOagente();
    dtOagente.setId_agente(id);

        try {
            mgrAgente.delete(dtOagente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping(path = "/update")
    void update(@RequestBody DTOagente agente) {

        try {
            mgrAgente.save(agente);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping(path = "/lista")
    public DTOrespuesta lista(){

        DTOrespuesta respuesta = new DTOrespuesta();
        try {
            List<DTOagente> lista = mgrAgente.listado();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (Exception e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
}