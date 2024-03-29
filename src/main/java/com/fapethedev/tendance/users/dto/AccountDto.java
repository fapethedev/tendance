package com.fapethedev.tendance.users.dto;

import com.fapethedev.tendance.users.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author Fapethedev
 * @version 1.0
 *
 * Data transfer object for account entity
 */

@Data @Builder @AllArgsConstructor
@NoArgsConstructor
public class AccountDto
{
    private UUID id;
    private String picture;
    private String idProof;
    private String bio;
    private User user;
    private boolean active;
}
