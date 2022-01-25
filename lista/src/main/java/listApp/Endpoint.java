package listApp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class Endpoint extends DBConnection{
    private Map<String, String> env = System.getenv();

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    @ResponseBody
    public String endpoint(@PathVariable int id){
        String lista = select(id);
        return lista;
    }

}
