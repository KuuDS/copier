package me.kuuds.copier.api;


import me.kuuds.copier.domain.User;
import me.kuuds.copier.mapper.BlobDataRepository;
import me.kuuds.copier.mapper.RelationRepository;
import me.kuuds.copier.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public abstract class BaseApi {

    @Autowired
    protected BlobDataRepository blobDataRepository;
    @Autowired
    protected RelationRepository relationRepository;
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    private HttpSession httpSession;

    protected User getUser() {
        return (User) httpSession.getAttribute("user");
    }

    protected int getUserId() {
        return getUser().getId();
    }


}
