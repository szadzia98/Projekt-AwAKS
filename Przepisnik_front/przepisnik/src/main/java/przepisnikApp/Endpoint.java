package przepisnikApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class Endpoint extends DBConnection{
    private Map<String, String> env = System.getenv();
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    @ResponseBody
    public List<String> requests(@PathVariable int id){
        String urlLista = env.get("LISTA_URL") + id;
        WebClient clientLista = WebClient.create();
        WebClient.ResponseSpec responseSpec = clientLista.get()
                .uri(urlLista).retrieve();
        String responseBodyLista = responseSpec.bodyToMono(String.class).block();
       // System.out.println(responseBody);
        String urlOpis = "OPIS_URL" + id;
        WebClient clientOpis = WebClient.create();
        WebClient.ResponseSpec responseSpecOpis = clientOpis.get()
                .uri(urlOpis).retrieve();
        String responseOpis = responseSpecOpis.bodyToMono(String.class).block();

        List<String> res =  new ArrayList<String>();
        res.add(responseBodyLista);
        res.add(responseOpis);
        return res;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    @ResponseBody
    public List<String> endpoint(){

        List<String> lista = select();
        return lista;
    }

}