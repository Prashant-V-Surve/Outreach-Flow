package com.subspace.outreachflow;

import com.subspace.outreachflow.service.PipelineService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final PipelineService pipelineService;

    public StartupRunner(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @Override
    public void run(String... args) {

        String domain =
                args.length > 0
                        ? args[0]
                        : "shopify.com";

        pipelineService.run(domain);

    }
}