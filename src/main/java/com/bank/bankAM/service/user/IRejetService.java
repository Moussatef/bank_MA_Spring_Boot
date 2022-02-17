package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.RejetDTO;
import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IRejetService {

    List<RejetDTO> getAllRejet();
    RejetDTO getRejet(long id);
    RejetDTO addNewRejet(RejetDTO rejet, MultipartFile file);
    void deleteRejet(Long userId);
    RejetDTO updateRejet(RejetDTO rejet);

}
