package com.fapethedev.tendance.main.cdn;

import com.cloudinary.Cloudinary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * <p>A cdn uploader implementation with cloudinary cdn as</p>
 *
 * @see <a href='https://cloudinary.com/documentation/image_upload_api_reference'> Upload API reference </a>
 * @see com.fapethedev.tendance.main.cdn.CdnUploader
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
public class CloudinaryUploader extends CdnUploader
{
    private final Cloudinary cloudinary;

    public CloudinaryUploader(
            @Value("${cloudinary.api.key}")final String key,
            @Value("${cloudinary.api.secret}") final String secret,
            @Value("${cloudinary.api.cloudname}") final String cloudName
    )
    {
        this.cloudinary = new Cloudinary(Map.of(
                "api_key", key,
                "api_secret", secret,
                "cloud_name", cloudName
        )) ;
    }

    @Override
    public String upload(Object file, String path, String id) throws CdnException
    {
        Map<?, ?> result;
        try
        {
            Objects.requireNonNull(file);
            Objects.requireNonNull(path);
            Objects.requireNonNull(id);

            log.info("Uploading file: " + file);
            result = cloudinary.uploader().upload(file, Map.of(
                    "extra_headers", Map.of("accept", "application/json"),
                    "folder", path,
                    "overwrite", true,
                    "resource_type", "auto",
                    "public_id", id
            ));
        }
        catch (Exception e) {
            throw new CdnException(e.getMessage(), e);
        }

        if(result.containsKey("error")) {
            log.debug("An error occurred when uploading");
            throw new CdnException((String) ((Map<?, ?>) result.get("error")).get("message"));
        }

        return (String) result.get("secure_url");
    }
}