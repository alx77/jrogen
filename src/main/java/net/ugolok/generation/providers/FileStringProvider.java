package net.ugolok.generation.providers;

import net.ugolok.generation.providers.api.Provider;

import java.io.*;
import java.net.URISyntaxException;

public class FileStringProvider extends BaseStringArrayProvider {

    @Override
    public Provider<String> setDataSource(String dataSource) {
        super.setDataSource(dataSource);
        File dataFile = new File(dataSource);
        if (!dataFile.isFile()) {
            try {
                dataFile = new File(getClass().getClassLoader().getResource(dataSource).toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        try (FileInputStream stream = new FileInputStream(dataFile)) {
            input = new BufferedReader(new InputStreamReader(stream)).lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}
