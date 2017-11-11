package net.ugolok.generation.providers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import net.ugolok.generation.providers.api.Provider;

public class FileStringProvider extends BaseStringArrayProvider {

	@Override
	public Provider<String> setDataSource(String dataSource) {
		super.setDataSource(dataSource);
		File dataFile = new File(dataSource);
		if (!dataFile.isFile()) {
			dataFile = new File("src/" + dataSource);
		}
		try (FileInputStream stream = new FileInputStream(dataFile)) {
			List<String> in = new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.toList());
			input = in.toArray(new String[in.size()]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
}
