package przepisnikApp;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class Endpoint extends DBConnection{
    private final RestTemplate restTemplate;
    private Map<String, String> env = System.getenv();
    public Endpoint(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    @ResponseBody
    public List<String> requests(@PathVariable int id){
        List<String> res =  new ArrayList<String>();
        String urlLista = env.get("LISTA_URL") + id;
/*        WebClient clientLista = WebClient.create();
        WebClient.ResponseSpec responseSpec = clientLista.get()
                .uri(urlLista)
                .retrieve();
        responseSpec.bodyToMono(String.class).subscribe(
                responseBodyLista -> res.add(responseBodyLista),
                error -> error.printStackTrace()
        );*/
        ResponseEntity<String> responseLista = this.restTemplate.getForEntity(urlLista, String.class, id);
        if(responseLista.getStatusCode() == HttpStatus.OK) {
            res.add(responseLista.getBody());
        }
        String urlOpis = env.get("OPIS_URL") + id;
        ResponseEntity<String> responseOpis = this.restTemplate.getForEntity(urlOpis, String.class, id);
        if(responseOpis.getStatusCode() == HttpStatus.OK) {
            res.add(responseOpis.getBody());
        }
 /*       WebClient clientOpis = WebClient.create();
        WebClient.ResponseSpec responseSpecOpis = clientOpis.get()
                .uri(urlOpis)
                .retrieve();

        responseSpecOpis.bodyToMono(String.class).subscribe(
                responseOpis -> res.add(responseOpis),
                error -> error.printStackTrace()
        );
*/

        //res.add(responseBodyLista);
        //res.add(responseOpis);
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