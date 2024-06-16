package com.fapethedev.tendance.main.cdn;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>An implementation of {@link CdnUploader} that's absolutely does nothing
 * but filled test requirement.</p>
 *
 * @see com.fapethedev.tendance.main.cdn.CdnUploader
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
public class NoopUploader extends CdnUploader
{
    @Override
    public String upload(Object file, String path, String uniqueFilename) throws CdnException
    {
        try
        {
            Objects.requireNonNull(file) ;
            Objects.requireNonNull(path) ;
            Objects.requireNonNull(uniqueFilename) ;
        }
        catch (Exception e) {
            throw new CdnException(e.getMessage(), e) ;
        }

        return "https://example.com/cdn/" + path + '/' + uniqueFilename ;
    }
}