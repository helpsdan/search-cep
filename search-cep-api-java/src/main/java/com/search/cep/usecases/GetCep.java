package com.search.cep.usecases;

import com.search.cep.entities.Cep;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class GetCep {

    public Cep execute(final String cep) throws Exception {

        final StringBuilder result = new StringBuilder();

        try {
            final URL url = new URL("http://viacep.com.br/ws/" + cep + "/json/");
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                result.append(line);
            }

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        final JSONObject obj = new JSONObject(result.toString());

        return Cep.builder()
                .cep(obj.getString("cep"))
                .logradouro(obj.getString("localidade"))
                .complemento(obj.getString("complemento"))
                .bairro(obj.getString("bairro"))
                .localidade(obj.getString("localidade"))
                .uf(obj.getString("uf"))
                .ibge(obj.getString("ibge"))
                .gia(obj.getString("gia"))
                .build();

    }
}
