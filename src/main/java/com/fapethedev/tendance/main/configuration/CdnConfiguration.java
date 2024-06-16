package com.fapethedev.tendance.main.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>CDN bucket configuration class which is different from the cdn provider
 * configuration in the application source.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Configuration
@Getter @Setter
@ConfigurationProperties(prefix = "cdn")
public class CdnConfiguration
{
    /**
     * <p>The usually name of cdn bucket implementation in lowercase.</p>
     */
    private String name ;

    /**
     * <p>The base path of cdn bucket implementation.</p>
     */
    private String basePath ;

    /**
     * <p>Get the storage path for audios.</p>
     *
     * @return The audio files path.
     */
    public final String audioPath() {
        return basePath + "/audio" ;
    }

    /**
     * <p>Get the storage path for documents.</p>
     *
     * @return The documents files path.
     */
    public final String documentPath() {
        return basePath + "/document" ;
    }

    /**
     * <p>Get the storage path for videos.</p>
     *
     * @return The videos files path.
     */
    public final String videoPath() {
        return basePath + "/video" ;
    }

    /**
     * <p>Get the storage path for images.</p>
     *
     * @return The images path.
     */
    public final String imagePath() {
        return basePath + "/image" ;
    }
}