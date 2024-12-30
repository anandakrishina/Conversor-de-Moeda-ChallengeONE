package org.oracle.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.oracle.model.Moeda;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    public void salvaJson(Moeda moeda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(moeda.getBase_code() + ".json");
        escrita.write(gson.toJson(moeda));
        escrita.close();
    }
}
