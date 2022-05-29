package dsdb.frontend.Service;

import dsdb.frontend.Model.Features;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("DSDB-Features")
public interface FeaturesClient {

    @GetMapping("/features/")
    public List<Features> getAllFeatures();

    @GetMapping("/features/{id}")
    public Features getFeaturesById(@PathVariable Integer id);
}
