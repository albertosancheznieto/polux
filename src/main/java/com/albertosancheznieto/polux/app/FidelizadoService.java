package com.albertosancheznieto.polux.app;

import com.albertosancheznieto.polux.entity.CustomerComerzzia;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.io.IOException;
import java.io.InputStream;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;
import static org.springframework.web.reactive.function.client.WebClient.*;

@Component
public class FidelizadoService {

    public static final String URL_OBTENER_FIDELIZADOS = "https://hiperusera.saas.comerzzia.com/api/v2/loyalty/customers";

    //private final WebClient webClient;

    /*
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .authenticator(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            "user",
                            "password".toCharArray());
                }

            })
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    */

    public void buscarFidelizado() {

    }

    public void obtenerFidelizados() {
        //CustomerComerzzia[] customersComerzzia = restTemplate.getForObject(PATH_OBTENER_FIDELIZADOS, CustomerComerzzia[].class);
        //return Arrays.asList(customersComerzzia)
        //System.out.println("Cliente: " + customersComerzzia.toString());
        /*
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(PATH_OBTENER_FIDELIZADOS))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
        try {
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            if (response.statusCode() == HttpStatus.OK.value()) {
                CustomerComerzzia responseElement = new ObjectMapper().readValue(response.body(), CustomerComerzzia.class);
            } else {
                // process incorrect response
            }
        } catch (IOException e) {
            // process error
        } catch (InterruptedException e) {
            // process error
        }


        ResponseEntity<CustomerComerzzia[]> responseEntity = restTemplate.getForEntity(URL_OBTENER_FIDELIZADOS, CustomerComerzzia[].class);
        CustomerComerzzia[] customerArray = responseEntity.getBody();
        System.out.println("paro aqui");
*/
        WebClient webClient = WebClient.builder()
                .baseUrl(URL_OBTENER_FIDELIZADOS)
                //.defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .filter(basicAuthentication("administrador", "x1ybuufdA9pA"))
                //.defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
                .build();


        Mono<List<CustomerComerzzia>> response = webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CustomerComerzzia>>() {});
        List<CustomerComerzzia> fidelizados = response.block();
        System.out.println("paro aqui");

    }

    private void obtenerToken() {
        /*
        String encodedClientData =
                Base64Utils.encodeToString("bael-client-id:bael-secret".getBytes());
        Mono<String> resource = client.post()
                .uri("localhost:8085/oauth/token")
                .header("Authorization", "Basic " + encodedClientData)
                .body(BodyInserters.fromFormData("grant_type", "client_credentials"))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .flatMap(tokenResponse -> {
                    String accessTokenValue = tokenResponse.get("access_token")
                            .textValue();
                    return client.get()
                            .uri("localhost:8084/retrieve-resource")
                            .headers(h -> h.setBearerAuth(accessTokenValue))
                            .retrieve()
                            .bodyToMono(String.class);
                });
        return resource.map(res ->
                "Retrieved the resource using a manual approach: " + res);
        */
    }



}