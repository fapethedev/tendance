package com.fapethedev.tendance.main.cdn;

import com.fapethedev.tendance.main.configuration.CdnConfiguration;
import com.fapethedev.tendance.main.exception.CdnException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Abstraction of all classes that will do upload operation to
 * the cdn bucket.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Getter
public abstract class CdnUploader
{
    @Autowired
    protected CdnConfiguration conf;

    /**
     * <p>Upload a file in the cdn bucket.</p>
     *
     * @param file The file to upload should be the string name or the url or the binary or {@code File} instance.
     * @param path The path where the file will be store.
     * @param uniqueFilename the id ou the name of the file, it should be unique.
     *
     * @return The public url of the file in the bucket.
     *
     * @throws CdnException if something went wrong.
     */
    public abstract String upload(Object file, String path, String uniqueFilename) throws CdnException ;
}
