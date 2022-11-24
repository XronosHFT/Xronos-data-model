package io.github.xronoshft.util;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

public class YamlUtil {

  public static Map<String, Object> parse(String path) {
    Yaml yaml = new Yaml();
    InputStream resourceAsStream = YamlUtil.class.getClassLoader().getResourceAsStream(path);
    return yaml.load(resourceAsStream);
  }

  public static <T> T parse(String path, Class<T> t) {

    Yaml yaml = new Yaml(new Constructor(t));
    InputStream inputStream = YamlUtil.class
        .getClassLoader()
        .getResourceAsStream(path);
    return yaml.load(inputStream);
  }
}
