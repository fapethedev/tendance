package com.fapethedev.tendance.main.cdn;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * <p>A factory for getting an instance of {@link CdnUploader}.<br/>
 * The {@link #getUploader()} method will produce a bean following the value of the property {@code cdn.name}.<br/>
 * The bean will be injection with to shadowing the real impl {@link CdnUploader}.</p>
 *
 * @see CdnUploader
 * @see NoopUploader
 * @see CloudinaryUploader
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Configuration
@RequiredArgsConstructor
public class CdnFactory
{
    /**
     * <p>The cdn service name following the value of the property cdn.name.</p>
     */
    @Value("${cdn.name}")
    private String cdnName;

    /**
     * <p>The {@code CdnUploader} impl that will be inject.</p>
     */
    private final CdnUploader cloudinaryUploader;

    /**
     * <p>The noop impl of {@code CdnUploader}.</p>
     */
    private final NoopUploader noopUploader;

    /**
     * <p>Return a bean of an instance of {@code CdnUploader} implementation
     * according the value of {@link #cdnName} property so an upload
     * operation will be possible.</p>
     *
     * @return the implementation of {@link CdnUploader}
     */
    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CdnUploader getUploader()
    {
        return switch (cdnName)
        {
            case "cloudinary" -> this.cloudinaryUploader;
            case "noop" -> this.noopUploader;
            default -> throw new IllegalArgumentException(
                    "There is no BucketUploader implementation for: '" + cdnName + "'." +
                    """
                    Available are :
                    -   cloudinary
                    -   noop
                    """
            );
        };
    }
}