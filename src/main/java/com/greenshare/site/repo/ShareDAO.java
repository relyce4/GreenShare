package com.greenshare.site.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.greenshare.site.entities.Share;

public interface ShareDAO extends JpaRepository<Share, Integer> {

}
