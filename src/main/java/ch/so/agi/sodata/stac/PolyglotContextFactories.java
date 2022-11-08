package ch.so.agi.sodata.stac;

import java.nio.file.Paths;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Prototype;
import jakarta.inject.Singleton;

@Factory
public class PolyglotContextFactories {
    @Singleton
    @Bean
    Engine createEngine() {
        return Engine.newBuilder().build();
    }

    @Prototype
    @Bean
    Context createContext(Engine engine) {
        String VENV_EXECUTABLE = PolyglotContextFactories.class.getClassLoader()
              .getResource(Paths.get("venv", "bin", "graalpy").toString()).getPath();
        
        return Context
                .newBuilder("python")
                    .allowAllAccess(true)
                    .option("python.Executable", VENV_EXECUTABLE)
                    .option("python.ForceImportSite", "true")
                    .engine(engine)
                    .build();
    }
}
