package com.fapethedev.tendance.users.form;

import com.fapethedev.tendance.users.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * <p> Data transfer object for account entity.</p>
 *
 * @author Fapethedev
 * @version 1.0
 */

@Data @Builder @AllArgsConstructor
@NoArgsConstructor
public class AccountForm
{
    private UUID id;
    private String picture;
    private String idProof;
    private String bio;
    private User user;
    private boolean active;
}
