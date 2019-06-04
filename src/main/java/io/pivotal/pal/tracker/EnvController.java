package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private static String PORT;
    private static String MEMORY_LIMIT;
    private static String CF_INSTANCE_INDEX;
    private static String CF_INSTANCE_ADDR;
    private Map<String, String> map;

    public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory.limit:NOT SET}") String memory_limit, @Value("${cf.instance.index:NOT SET}") String cd_instance_index,
                         @Value("${cf.instance.addr:NOT SET}") String cf_instance_addr) {
        map = new HashMap<>();
        map.put("PORT", port);
        map.put("MEMORY_LIMIT", memory_limit);
        map.put("CF_INSTANCE_INDEX", cd_instance_index);
        map.put("CF_INSTANCE_ADDR", cf_instance_addr);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return map;
    }
}
